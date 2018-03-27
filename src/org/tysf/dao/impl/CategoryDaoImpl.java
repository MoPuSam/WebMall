package org.tysf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.dao.CategoryDao;
import org.tysf.domain.Category;
import org.tysf.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public  List<Category> findAll() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from category";
		return (List<Category>)qr.query(sql, new BeanListHandler<>(Category.class));
	}

	@Override
	public Category findById(String cid) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from category where cid = ?";
		return qr.query(sql,new BeanHandler<>(Category.class),cid);
	}
}
