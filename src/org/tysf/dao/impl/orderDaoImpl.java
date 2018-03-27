package org.tysf.dao.impl;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.dao.orderDao;
import org.tysf.domain.Order;
import org.tysf.domain.OrderItem;
import org.tysf.domain.Product;
import org.tysf.domain.User;
import org.tysf.utils.JdbcUtils;
public class orderDaoImpl implements orderDao {
	
	QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());

/**
 * 添加订单
 * @param List 
 */
	
	@Override
	public void addOrder(Order order) throws SQLException {
	//	try{
		/**它允许 JDBC API 将该类标识为 SQL TIMESTAMP 值
		 * 将util的date转换为sql的TIMESTAMP
		*/
		Timestamp timestamp=new Timestamp(order.getOrdertime().getTime());//使用毫秒时间值构造 Timestamp 对象。
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		//使用object[]封装订单对象
//		[] params={order.getOid(),timestamp,order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUid()};
//		qr.update(sql,params);
//		}catch(SQLException e){
//			throw new RuntimeException(e);
				
	/**
	 * 插入订单条目
	 * 由于一个订单是一个object的一维数组，所以多个订单就构成了二维数组
	 */
	}
	@Override
	public void addOrderItemList(List<OrderItem> OrderItemList) {
		try {
			
			/**使用批处理batch(String sql,object params[][])
			 * 循环遍历OrderItemList，使用每个OrderItem对象为param一维数组赋值
			 */
			String sql="insert into orderitem values(?,?,?,?,?)";
			Object[][]params=new Object[OrderItemList.size()][];
			for(int i=0;i<OrderItemList.size();i++){
				OrderItem item=new OrderItem();
				params[i]=new Object[]{item.getItemid(),item.getCount(),item.getSubtotle(),item.getPid(),item.getOid()};	
			}
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		
		
	}
	@Override
	public Order findUserOrder(User user) throws SQLException {
		String sql = "select * from orders where uid='"+user.getUid()+"'";
		Order orders = qr.query(sql,new BeanHandler<Order>(Order.class));
		return orders;
		
	}
	@Override
	public User findUser(String uid) throws SQLException {
		String sql = "select * from user where uid=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),uid);
		return user;
	}
	@Override
	public List<OrderItem> findOrderItem(Order orders) throws SQLException {
		String sql = "select * from orderitem where oid=? ";
		List<OrderItem> orderItem = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orders.getOid());
		return orderItem;
	}
	@Override
	public Product findProductItem(OrderItem orderItem) throws SQLException {
		String sql ="select * from product where pid = ?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),orderItem.getPid());
		return product;
	}
	@Override
	public Product queryProductMsg(String pid) throws SQLException {
		String sql = "select * from product where pid=?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;

	}
//	/**
//	 * 通过uid查询所拥有的订单
//	 */
//	@Override
//	public List<Order> findOrderById(String uid) throws SQLException {
//		try {
//		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
//		//通过uid查询当前用户的所有的订单
//		String sql="select * from orders where uid=?";
//		List<Order> orderlist=qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
//		//循环遍历订单，加载所有的订单条目
//		for(Order order:orderlist){
//			loadOrderItem(order);//为order对象添加订单条目
//		}
//		//返回订单列表
//		return orderlist;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//			
//		}
//	}
//	/**
//	 * 加载指定的订单的订单条目
//	 */
//	public void loadOrderItem(Order order) {
//		/**
//		 * 查询两张表，一个是orderitem一个是product
//		 */
//		try {
//			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
//			String sql="select * from orderitem o,product p where o.pid=p.pid and oid=?";
//			//因为一行结果集对应的不再是一个Javabean，所以不能在使用beanlistHandr，使用maplistHander
//			List<Map<String,Object>> mapList=qr.query(sql, new MapListHandler(),order.getOid());
//			//maplist是多个map，每个map对应一个结果集
//			//循环遍历每一个map，使用map转换成两个对象，product和orderitem最终形成一个orderitem。并保存
//			//List<OrderItem> Orderitem=toOrderItem(mapList);
//			//order.setOrderItemList(orderItemList);
//			return ;
//			}catch (SQLException e) {
//				throw new RuntimeException(e);
//				
//			}
//		
//	}
//	//吧每个map转换成两个对象，建立关系
//	public  List<OrderItem> toOrderItem(Map<String, String[]> map) {
//		
//		BeanTools.populate(OrderItem.class,map);
//		return null;
//	}
	
}














