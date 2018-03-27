package org.tysf.dao;

import java.sql.SQLException;
import java.util.List;

import org.tysf.domain.Order;
import org.tysf.domain.OrderItem;
import org.tysf.domain.Product;
import org.tysf.domain.User;

public interface orderDao {
	//添加订单
public void addOrder(Order order) throws SQLException;
public void addOrderItemList(List<OrderItem> OrderItemList );
Order findUserOrder(User user) throws SQLException;
User findUser(String uid) throws SQLException;
List<OrderItem> findOrderItem(Order orders) throws SQLException;
Product findProductItem(OrderItem orderItem) throws SQLException;
Product queryProductMsg(String pid) throws SQLException;

}
