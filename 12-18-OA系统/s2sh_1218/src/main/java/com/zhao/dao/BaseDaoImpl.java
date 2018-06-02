package com.zhao.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T extends Serializable, ID extends Serializable>
		implements IBaseDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistClass;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public T save(T record) {
		this.getCurrentSession().save(record);
		return record;
	}

	@Override
	public T delete(T record) {
		this.getCurrentSession().delete(record);
		return record;
	}

	@Override
	public T load(ID id) {
		return this.getCurrentSession().get(persistClass, id);
	}

	@Override
	public T update(T record) {
		this.getCurrentSession().update(record);
		return record;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectByExample(T record, int... page) {
		Criteria c=this.getCriteria(record).getExecutableCriteria(this.getCurrentSession());
		if(page!=null && page.length>0){
			c.setFirstResult(page[0]);
		}
		if(page!=null && page.length>1){
			c.setMaxResults(page[1]);
		}
		return c.list();
	}

	@Override
	public int selectByExampleRowsNum(T record) {
		Criteria c=this.getCriteria(record).getExecutableCriteria(this.getCurrentSession());
		c.setProjection(Projections.rowCount());
		return ((Number) c.uniqueResult()).intValue();
	}
	
	
	protected DetachedCriteria getCriteria(T record){
		DetachedCriteria dc=DetachedCriteria.forClass(persistClass);
		if(record!=null){
			dc.add(Example.create(record).enableLike());
		}
		return dc;
			
		
	}
	
}
