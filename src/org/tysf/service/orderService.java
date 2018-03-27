package org.tysf.service;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Order;
import org.tysf.domain.OrderItem;
import org.tysf.domain.Product;
import org.tysf.domain.User;

public interface orderService {
	
  public void add(Order order) throws SQLException;


  


public User findUser(String uid) throws SQLException;


public List<OrderItem> findOrderItem(Order orders) throws SQLException;




public Product findProductItem(OrderItem orderItem) throws SQLException;


public Product queryProductMsg(String pid) throws SQLException;


Order findUserOrder(User user) throws SQLException;


   
}
