package org.tysf.admin.service;

import java.sql.SQLException;
import java.util.List;

import org.tysf.admin.domain.Orders;

public interface AdminOrdersService {

	List<Orders> findAll() throws SQLException;
	
}
