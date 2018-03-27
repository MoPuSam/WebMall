package org.tysf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.dao.ProductDao;
import org.tysf.domain.Product;
import org.tysf.utils.JdbcUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll(String cid) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		/*
		 * oracle
		 * 页数page，记录数12
		 * 查询x到x+12，（page-1）*12
		 *  select t.*
			from (select product.*,rownum r from product where rownum<=（page-1）*12+12)t
			where r>=（page-1）*12;
		 */
		/*
		 * mysql
		 *  SELECT *
			FROM product
			LIMIT (page-1)*12,page*12;
		 */
		String sql="SELECT * FROM product where cid=?";
		List<Product> productList=qr.query(sql, new BeanListHandler<Product>(Product.class),cid);
		return productList;
	}
	//查找热门商品
	@Override
	public List<Product> findHot() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="SELECT * FROM product where is_hot=1 LIMIT 9";
		List<Product> productList=qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}
	@Override
	public Product findByName(String pname) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		System.out.println(pname);
		String sql = "select * from product where pname = %?%";
		Product pro = qr.query(sql,new BeanHandler<Product>(Product.class),pname);
		System.out.println(pro);
		return pro;
		
	}
	@Override
	public Product findByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from product where pid = ?";
		Product pro = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
		return pro;
	}
	@Override
	public List<Product> findNew() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="SELECT * FROM product ORDER BY pdate DESC LIMIT 9";
		List<Product> productList=qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

}
