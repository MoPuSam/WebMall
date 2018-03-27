package org.tysf.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tysf.domain.Order;
import org.tysf.domain.OrderItem;
import org.tysf.domain.Product;
import org.tysf.domain.User;
import org.tysf.service.orderService;
import org.tysf.service.impl.orderServiceImpl;
import org.tysf.servlet.base.BaseServlet;
@WebServlet("/ordersServlet")
public class ordersServlet extends BaseServlet{
	/**
	 * 从session中得到cart
	 * 使用cart生成order对象
	 * 调用service方法完成添加订单
	 * 保存order到request域中，
	 */
	private static final long serialVersionUID = 1L;
	orderService userservice=new orderServiceImpl();
	
	/*
	 * 查询订单前，先获取该用户的所有订单
	 */
	public void findUserOrder(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ServletException, IOException{
		String uid = req.getParameter("uid");
		//通过uid获取用户信息
		User user = userservice.findUser(uid);
		//通过用户信息找到该用户的所有订单信息
		Order orders = userservice.findUserOrder(user);
		//通过订单的订单号找到订单列表
		List<OrderItem> orderItem = userservice.findOrderItem(orders);
		List<Product> productItem  = new ArrayList<Product>();
		Product product = null;
		//通过订单列表中的商品号找到商品信息
		for (int i = 0; i < orderItem.size(); i++) {
			 product = userservice.findProductItem(orderItem.get(i));
			 productItem.add(product);
		}		
		req.setAttribute("orderItem", orderItem);
		req.setAttribute("productItem", productItem);
		req.getRequestDispatcher("/jsp/order_list.jsp").forward(req, resp);
	}
	/*
	 * 查找订单中商品的详细信息
	 */
	public void queryProductMsg(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ServletException, IOException{
		String pid = req.getParameter("pid");
		Product  product = userservice.queryProductMsg(pid);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/jsp/order_info.jsp").forward(req, resp);}
	/*public String add(HttpServletRequest req,HttpServletResponse resp) {
       Cart cart= (Cart) req.getSession().getAttribute("cart");//返回一个cart对象
        //将cart转换成order对象
        //创建order对象，设置属性
		Order order = BeanTools.populate(Order.class, req.getParameterMap());
	    order.setOid(UUIDUtils.getCode());	   
	    order.setTotal(1403);//cart.gettotal
	    order.setTelephone((String)req.getSession().getAttribute("confirmpwd"));
	    User user=(User) req.getSession().getAttribute("user");
	    order.setName(user.getName());
	    order.setUid(user.getUid());
	    order.setOrdertime(new Date());
	    order.setState(1);
	    /**
	     * 创建订单条目
	     */
	/*
		List<OrderItem> orderItemList=new ArrayList<>();
		for(CartItem cartItem:){
			OrderItem oi=new OrderItem();
			oi.setCount(12);
			oi.setItemid(new Integer(UUIDUtils.getCode()));
			oi.setPid("");
			oi.setPid("pid");
			oi.setSubtotle(34);
			orderItemList.add(oi);
		}
		order.setOrderItemList(orderItemList);
		//添加订单
		orderService service=new orderServiceImpl();
		service.add(order);
		//保存order到request域，转发
		req.setAttribute("order", order);
	    return "/jsp/order_list.jsp";
	}*/
	

}
