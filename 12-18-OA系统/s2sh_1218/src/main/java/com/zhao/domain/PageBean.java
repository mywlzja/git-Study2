package com.zhao.domain;

import java.io.Serializable;

public class PageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pageNum;
	private int rowsNum;
	private int rowsPerPage;
	private int maxPage;
	private int lastPage;
	private int nextPage;
	private int startLine;
	private int startPage;
	private int endPage;
	
	
	public PageBean(int pageNum, int rowsNum, int rowsPerPage) {
		super();
		this.pageNum = pageNum;
		this.rowsNum = rowsNum;
		this.rowsPerPage = rowsPerPage;
		
		this.maxPage=(int) (Math.ceil(this.rowsNum*1.0/this.rowsPerPage));
		if(this.pageNum<1){
			this.pageNum=1;
		}
		if(this.pageNum>this.maxPage){
			this.pageNum=this.maxPage;
		}
		
		this.lastPage=this.pageNum-1;
		this.nextPage=this.pageNum+1;
		this.startLine=(this.pageNum-1)*this.rowsPerPage;
		if(this.maxPage<10){
			this.startPage=1;
			this.endPage=this.maxPage;
		}else{
			this.startPage=this.pageNum-5;
			this.endPage=this.pageNum+4;
			if(this.startPage<1){
				this.startPage=1;
				this.endPage=10;
			}
			if(this.endPage>this.maxPage){
				this.endPage=this.maxPage;
				this.startPage=this.maxPage-9;
			}
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getRowsNum() {
		return rowsNum;
	}
	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", rowsNum=" + rowsNum
				+ ", rowsPerPage=" + rowsPerPage + ", maxPage=" + maxPage
				+ ", lastPage=" + lastPage + ", nextPage=" + nextPage
				+ ", startLine=" + startLine + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}
	
	
}
