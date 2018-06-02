package com.zhao.biz;

import java.util.List;

import com.zhao.domain.PageBean;
import com.zhao.entity.DeptBean;

public interface IDeptServ {

	int getRowsNum(DeptBean dept) throws Exception;

	List<DeptBean> findByPage(DeptBean dept, PageBean page) throws Exception;

	DeptBean findOneDept(Long id) throws Exception;

	void remove(DeptBean dept) throws Exception;
	
	void create(DeptBean dept) throws Exception;
	
	
}
