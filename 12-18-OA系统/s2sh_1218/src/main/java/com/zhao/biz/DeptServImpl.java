package com.zhao.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.zhao.dao.IDeptDao;
import com.zhao.domain.PageBean;
import com.zhao.entity.DeptBean;

@Service("deptService")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class DeptServImpl implements IDeptServ {
	@Autowired
	private IDeptDao deptDao;

	@Override
	public int getRowsNum(DeptBean dept) throws Exception {
		return deptDao.selectByExampleRowsNum(dept);
	}

	@Override
	public List<DeptBean> findByPage(DeptBean dept, PageBean page)
			throws Exception {
		return deptDao.selectByExample(dept, page.getStartLine(),
				page.getRowsPerPage());
	}

	@Override
	public DeptBean findOneDept(Long id) throws Exception {
		if(id!=null)
			return deptDao.load(id);
		return null;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void remove(DeptBean dept) throws Exception {
		Assert.notNull(dept.getId(),"参数不合法");
		dept=deptDao.load(dept.getId());
		deptDao.delete(dept);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void create(DeptBean dept) throws Exception {
		if(dept.getParent()!=null && dept.getParent().getId()!=null){
			DeptBean parent=deptDao.load(dept.getParent().getId());
			if(parent!=null){
				parent.setLeaf(false);
				dept.setParent(parent);
			}
		}
		deptDao.save(dept);
	}	
}
