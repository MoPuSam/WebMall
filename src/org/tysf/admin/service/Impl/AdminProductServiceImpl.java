package org.tysf.admin.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.tysf.admin.dao.AdminProductDao;
import org.tysf.admin.dao.Impl.AdminProductDaoImpl;
import org.tysf.admin.service.AdminProductService;
import org.tysf.domain.Product;

public class AdminProductServiceImpl implements AdminProductService {
	AdminProductDao dao = new AdminProductDaoImpl();
	
	@Override
	public List<Product> findAll() throws SQLException {
		List<Product> productList = dao.findAll();
		return productList;
	}

	@Override
	public List<Product> add(Product product) throws SQLException {
		List<Product> addedProductList = dao.add(product);
		return addedProductList;
	}

	@Override
	public List<String> cid() throws SQLException {
		List<String> category = dao.cid();
		return category;
	}
	
	

}
