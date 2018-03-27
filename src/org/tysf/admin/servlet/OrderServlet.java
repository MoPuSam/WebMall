package org.tysf.admin.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.tysf.servlet.base.BaseServlet;


@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String findOrderItem(String oid) throws SQLException{
		/*OrderDaoService orderMsgService=new OrderDaoServiceImpl();
		List<Orders> list=orderMsgService.findOrderItem(oid);
		for(Orders o:list){
			System.out.println(o);
		}*/
		return "/admin/order/orderItem.jsp";
	}
}
