package org.tysf.admin.service;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Product;

public interface AdminProductService {

	List<Product> findAll() throws SQLException;

	List<Product> add(Product product) throws SQLException;
	List<String> cid() throws SQLException ;
}
