package org.tysf.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.tysf.admin.domain.Orders;



public interface AdminOrdersDao {

	List<Orders> findAll() throws SQLException;

}
