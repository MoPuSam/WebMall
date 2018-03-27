package org.tysf.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Product;

public interface AdminProductDao {

	List<Product> findAll() throws SQLException;

	List<Product> add(Product product) throws SQLException;
	List<String> cid() throws SQLException ;	

}
