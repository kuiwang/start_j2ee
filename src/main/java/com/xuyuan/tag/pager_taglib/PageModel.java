package com.xuyuan.tag.pager_taglib;import java.util.List;public class PageModel {	private int total;	//总记录数	private List data;	//当前页的记录集		public int getTotal() {		return total;	}	public void setTotal(int total) {		this.total = total;	}	public List getData() {		return data;	}	public void setData(List data) {		this.data = data;	}}