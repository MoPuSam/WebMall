package org.tysf.admin.service;

import java.sql.SQLException;

import org.tysf.admin.domain.Admin;

public interface AdminDaoService {
	public Admin login(Admin admin) throws SQLException;
}
