package com.zhao.biz;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhao.entity.DeptBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DeptServTest {
	@Autowired
	private IDeptServ dserv;
	
	@Test
	public void testCreate() throws Exception {
		DeptBean dept=new DeptBean();
		DeptBean parent=new DeptBean();
		parent.setId(14l);
		dept.setDeptname("吉祥集团14444");
		dept.setParent(parent);
		dserv.create(dept);
		assertNotNull(dept.getId());
	}

}
