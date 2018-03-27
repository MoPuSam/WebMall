package org.tysf.admin.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.tysf.admin.dao.AdminCategoryDao;
import org.tysf.admin.dao.Impl.AdminCategoryDaoImpl;
import org.tysf.admin.service.AdminCategoryService;
import org.tysf.domain.Category;

public class AdminCategoryServiceImpl implements AdminCategoryService {
	
	AdminCategoryDao categoryDao = new AdminCategoryDaoImpl();
	@Override
	public List<Category> findAll() throws SQLException {
		List<Category> list = categoryDao.findAll();
		return list;
	}
	@Override
	public void delete(String cid) throws SQLException {
		categoryDao.delete(cid);
		
	}
	@Override
	public void add(Category category) throws SQLException {
		categoryDao.add(category);
		
	}
	@Override
	public Category queryById(String cid) throws SQLException {
		Category category= categoryDao.queryById(cid);
		return category;
	}
	@Override
	public void update(Category category) throws SQLException {
		categoryDao.update(category);
		
	}

}
