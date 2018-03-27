package org.tysf.service.impl;
import java.sql.SQLException;
import java.util.List;

import org.tysf.dao.orderDao;
import org.tysf.dao.impl.orderDaoImpl;
import org.tysf.domain.Order;
import org.tysf.domain.OrderItem;
import org.tysf.domain.Product;
import org.tysf.domain.User;
import org.tysf.service.orderService;
import org.tysf.utils.DataSourceUtils;
public class orderServiceImpl implements orderService{
	@Override
	public void add(Order order) throws SQLException {
		/**
		 * 添加订单需要处理事务
		 */
		try{
			DataSourceUtils.startTransaction();
			orderDao dao= new orderDaoImpl();
			dao.addOrder(order);
			dao.addOrderItemList(order.getOrderItemList());
			/**
			 * 提交事务
			 */
			DataSourceUtils.commitAndClose();
		    }catch(Exception e){
			/**
			 * 回滚事务
			 */
			try{
				DataSourceUtils.rollbackAndClose();
			    }catch(Exception e1){
			     }
			throw new RuntimeException();
			}
		}

	@Override
	public User findUser(String uid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findOrderItem(Order orders) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductItem(OrderItem orderItem) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product queryProductMsg(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findUserOrder(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
			
	}



