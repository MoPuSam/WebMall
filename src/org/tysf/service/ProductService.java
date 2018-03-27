package org.tysf.service;

import java.sql.SQLException;
import java.util.List;
import org.tysf.domain.Product;


public interface ProductService {

	List<Product> findAll(String cid) throws SQLException;
	List<Product> findHot() throws SQLException;
	Product findByName(String pname) throws SQLException;
	Product findByPid(String pid) throws SQLException;
	List<Product> findNew() throws SQLException;
}
