package com.zhao.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhao.entity.DeptBean;

@Repository("deptDao")
public class DeptDaoImpl extends BaseDaoImpl<DeptBean, Long> implements IDeptDao {
	
	@Override
	protected DetachedCriteria getCriteria(DeptBean record) {
		DetachedCriteria dc= super.getCriteria(record);//注意这里需要通过super
		if(record!=null){
			//只显示根节点
			if(record.getParent()==null || record.getParent().getId()==null){
				dc.add(Restrictions.isNull("parent.id"));//只显示父节点为null的数据
			}else{
				//这个是为了只查找一个相关根节点的孩子（页面传入的参数为--parent.id）
				dc.add(Restrictions.eq("parent.id", record.getParent().getId()));//只显示同一个父节点下子节点数据
			}
		}
		//这个排序用的真是太他妈好了
		dc.addOrder(Order.asc("id"));
		return dc;
	}
}
