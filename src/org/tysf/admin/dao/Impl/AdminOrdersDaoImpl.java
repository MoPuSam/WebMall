package org.tysf.admin.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.admin.dao.AdminOrdersDao;
import org.tysf.admin.domain.Orders;
import org.tysf.utils.JdbcUtils;

public class AdminOrdersDaoImpl implements AdminOrdersDao{
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public List<Orders> findAll() throws SQLException {
		String sql="select * from orders ";
		return	qr.query(sql, new BeanListHandler<>(Orders.class));
	}
	
}
