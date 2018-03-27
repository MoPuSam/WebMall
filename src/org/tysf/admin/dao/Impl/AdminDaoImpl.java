package org.tysf.admin.dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.tysf.admin.dao.AdminDao;
import org.tysf.admin.domain.Admin;
import org.tysf.utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin find(String adminName, int adminPwd) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from admin where adminName=? and adminPwd=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class), adminName, adminPwd);
	}

}
