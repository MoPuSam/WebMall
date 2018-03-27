package org.tysf.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.tysf.dao.CategoryDao;
import org.tysf.dao.impl.CategoryDaoImpl;
import org.tysf.domain.Category;
import org.tysf.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao dao=new CategoryDaoImpl();
	@Override
	public List<Category> findAll() throws SQLException {
	
		return 	dao.findAll();
	}
	@Override
	public Category findById(String cid) throws SQLException {
		return dao.findById(cid);
	}

}
