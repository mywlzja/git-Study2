package com.zhao.action;


import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhao.biz.IDeptServ;
import com.zhao.domain.PageBean;
import com.zhao.entity.DeptBean;

@Controller
@Scope("prototype")
@Namespace("/dept")
@ParentPackage("admin")
public class DeptAction extends ActionSupport implements ModelDriven<DeptBean>,SessionAware {
	private static final long serialVersionUID = 1571370449133921709L;
	private Map<String, Object> session;
	private DeptBean dept=new DeptBean();
	private PageBean page;
	private int pageNum;
	@Value("#{constants.deptPage}")
	private int rowsPerPage=10;
	@Autowired
	private IDeptServ dserv;
	
	//==================================================
	@Action(value="list",results={
			@Result(name="success",location="/WEB-INF/content/dept/list.jsp")
	})
	public String list() throws Exception{
		if(dept.getParent()!=null && dept.getParent().getId()!=null){
			DeptBean parent=dserv.findOneDept(dept.getParent().getId());
			ActionContext.getContext().put("parent", parent);
		}
		int rowsNum=dserv.getRowsNum(dept);
		page=new PageBean(pageNum, rowsNum, rowsPerPage);
		List<DeptBean> list=dserv.findByPage(dept,page);
		ActionContext.getContext().put("deptList", list);
		return SUCCESS;
	}
	
	@Action(value="delete",results={
			@Result(name="success",location="list.action",type="redirectAction")
	})
	public String delete() throws Exception{
		dserv.remove(dept);
		session.put("msg", "删除成功");
		return SUCCESS;
	}
	
	@Action(value="toadd",results={
			@Result(name="success",location="/WEB-INF/content/dept/add.jsp")
	})
	public String toadd(){
		return SUCCESS;
	}
	
	
	@Override
	public DeptBean getModel() {
		return dept;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	//==================================================

	public PageBean getPage() {
		return page;
	}
	public void setPage(PageBean page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	
	
	
	
}
