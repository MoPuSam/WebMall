package org.tysf.admin.dao;

import java.sql.SQLException;

import org.tysf.admin.domain.Admin;

public interface AdminDao {
	public Admin find(String adminName,int adminPwd) throws SQLException;
}
