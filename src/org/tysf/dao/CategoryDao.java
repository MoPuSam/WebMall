package org.tysf.dao;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Category;

public interface CategoryDao {
	List<Category>  findAll() throws SQLException;
	Category  findById(String cid) throws SQLException;
}
