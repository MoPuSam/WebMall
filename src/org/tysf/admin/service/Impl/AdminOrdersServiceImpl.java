package org.tysf.admin.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.tysf.admin.dao.AdminOrdersDao;
import org.tysf.admin.dao.Impl.AdminOrdersDaoImpl;
import org.tysf.admin.domain.Orders;
import org.tysf.admin.service.AdminOrdersService;


public class AdminOrdersServiceImpl implements AdminOrdersService{
	AdminOrdersDao adminOrdersDao=new AdminOrdersDaoImpl();
	@Override
	public List<Orders> findAll() throws SQLException {
		List<Orders> list = adminOrdersDao.findAll();
		return list;
		
	}
	
}
