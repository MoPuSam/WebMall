package org.tysf.admin.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.admin.dao.AdminCategoryDao;
import org.tysf.domain.Category;
import org.tysf.utils.JdbcUtils;


public class AdminCategoryDaoImpl implements AdminCategoryDao{
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public List<Category> findAll() throws SQLException {
		String sql = "select * from category ";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}
	@Override
	public void delete(String cid) throws SQLException {
		String sql = "delete from category where cid='"+cid+"'";
		qr.update(sql);
		
	}
	@Override
	public void add(Category category) throws SQLException {
		String sql = "insert into category values('"+category.getCid()+"','"+category.getCname()+"')";
		qr.update(sql);
		
	}
	@Override
	public Category queryById(String cid) throws SQLException {
		String sql = "select *  from category where cid='"+cid+"'";
		Category category = qr.query(sql, new BeanHandler<Category>(Category.class));
		return category;
	}
	@Override
	public void update(Category category) throws SQLException {
		String sql = "update category set cname=? where cid='"+category.getCid()+"'";
		qr.update(sql,category.getCname());
		
	}

}
