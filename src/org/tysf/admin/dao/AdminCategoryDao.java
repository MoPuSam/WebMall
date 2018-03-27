package org.tysf.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Category;

public interface AdminCategoryDao {

	List<Category> findAll() throws SQLException;

	void delete(String cid) throws SQLException;

	void add(Category category) throws SQLException;

	Category queryById(String cid) throws SQLException;

	void update(Category category) throws SQLException;

}
