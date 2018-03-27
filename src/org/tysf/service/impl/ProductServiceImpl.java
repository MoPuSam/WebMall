package org.tysf.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.tysf.dao.ProductDao;
import org.tysf.dao.impl.ProductDaoImpl;
import org.tysf.domain.Product;
import org.tysf.service.ProductService;


public class ProductServiceImpl implements ProductService{
	ProductDao dao = new ProductDaoImpl();

	@Override
	public List<Product> findAll(String cid) throws SQLException {
		return dao.findAll(cid);
	}

	@Override
	public List<Product> findHot() throws SQLException {
		return dao.findHot();
	}

	@Override
	public Product findByName(String pname) throws SQLException {
		ProductDao dao = new ProductDaoImpl();
		Product pro = dao.findByName(pname);
		return pro;
	}

	@Override
	public Product findByPid(String pid) throws SQLException {
		ProductDao dao = new ProductDaoImpl();
		Product pro = dao.findByPid(pid);
		return pro;
	}

	@Override
	public List<Product> findNew() throws SQLException{
		return dao.findNew();
	}
	

}


