package org.tysf.service;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Category;

public interface CategoryService {

	List<Category> findAll() throws SQLException;
	Category  findById(String cid) throws SQLException;
}
