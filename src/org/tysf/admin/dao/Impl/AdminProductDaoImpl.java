package org.tysf.admin.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.admin.dao.AdminProductDao;
import org.tysf.domain.Product;
import org.tysf.utils.JdbcUtils;

public class AdminProductDaoImpl implements AdminProductDao {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	@Override
	public List<Product> findAll() throws SQLException {
		String sql = "select * from product";
		List<Product> findAllList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return findAllList;
	}

	@Override
	public List<Product> add(Product product) throws SQLException {
		String sql = "insert into product(pid,pname,market_price,shop_price,pimage,pdate,is_hot,pdesc,pflag,cid)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), 0, product.getCid());
		List<Product> addedProductList = findAll();
		return addedProductList;
	}
	@Override
	public List<String> cid() throws SQLException {
		System.out.println("88888888888888");
		String sql = "select * from category";
		List<String> category = qr.query(sql, new BeanListHandler<>(String.class));
		System.out.println("分类"+category);
		return category;
	}

}
