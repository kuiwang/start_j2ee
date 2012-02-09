package com.xuyuan.pager_ftl.service.ibatis;import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.orm.ibatis.SqlMapClientTemplate;import com.opensymphony.xwork2.ActionContext;import com.opensymphony.xwork2.util.ValueStack;import com.xuyuan.pager_ftl.dao.ibatis.PagingList;public class BaseServiceIbatis {		private JdbcTemplate jdbcTemplate;	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {		this.jdbcTemplate = jdbcTemplate;	}	public ValueStack getValueStack() {		return ActionContext.getContext().getValueStack();	}	public PagingList getPagingList(String statementName, SqlMapClientTemplate sqlMapClientTemplate) {		int pageNum = (Integer) getValueStack().findValue("pageNum");		int pageSize = (Integer) getValueStack().findValue("pageSize");		return new PagingList(statementName, pageNum, pageSize, sqlMapClientTemplate, jdbcTemplate);	}	public PagingList getPagingList(String statementName, Object parameterObject, SqlMapClientTemplate sqlMapClientTemplate) {		int pageNum = (Integer) getValueStack().findValue("pageNum");		int pageSize = (Integer) getValueStack().findValue("pageSize");		return new PagingList(statementName, parameterObject, pageNum, pageSize, sqlMapClientTemplate, jdbcTemplate);	}}