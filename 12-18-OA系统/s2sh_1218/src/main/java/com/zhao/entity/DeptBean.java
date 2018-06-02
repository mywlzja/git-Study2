package com.zhao.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;

@Entity(name="t_dept")
@DynamicInsert
public class DeptBean implements Serializable {
	private static final long serialVersionUID = -9050760536874934850L;
	@Id
	@GeneratedValue(generator="seq1",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq1",sequenceName="seq_dept",initialValue=1,allocationSize=1)
	private Long id;
	@Column(length=32,unique=true,nullable=false)
	private String deptname;
	@Basic(fetch=FetchType.LAZY)
	@Column(length=200)
	private String descn;
	@ManyToOne(optional=true)
	@JoinColumn(name="parent_id")
	private DeptBean parent;
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL)
	private Set<DeptBean> children =new LinkedHashSet<>();
	@Column(columnDefinition="number(1) default 1")
	private Boolean leaf;
	
	
	public String getShowId(){
		if(parent!=null && parent.getId()!=null)
			return parent.getId()+"_"+this.id;
		return "_"+this.id;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public DeptBean getParent() {
		return parent;
	}
	public void setParent(DeptBean parent) {
		this.parent = parent;
	}
	public Set<DeptBean> getChildren() {
		return children;
	}
	public void setChildren(Set<DeptBean> children) {
		this.children = children;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deptname == null) ? 0 : deptname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptBean other = (DeptBean) obj;
		if (deptname == null) {
			if (other.deptname != null)
				return false;
		} else if (!deptname.equals(other.deptname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
