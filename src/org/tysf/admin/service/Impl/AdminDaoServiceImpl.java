package org.tysf.admin.service.Impl;

import java.sql.SQLException;

import org.tysf.admin.dao.AdminDao;
import org.tysf.admin.dao.Impl.AdminDaoImpl;
import org.tysf.admin.domain.Admin;
import org.tysf.admin.service.AdminDaoService;

public class AdminDaoServiceImpl implements AdminDaoService{

	@Override
	public Admin login(Admin admin) throws SQLException {
		AdminDao dao=new AdminDaoImpl();
		return dao.find(admin.getAdminName(), admin.getAdminPwd());
	}

}
