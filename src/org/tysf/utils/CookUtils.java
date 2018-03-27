package org.tysf.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookUtils {
	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * @param name cookie名称
	 * @param cookies  cookie数组
	 * @return
	 */
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}
	//查询历史记录（在查询物品方法中调用）
		public static String queryHistory(HttpServletRequest req, HttpServletResponse resp){
			Cookie[] cookies = req.getCookies();
			String history = null;
			Cookie c=getCookieByName("history", cookies);
			if (c!=null) {
				history = c.getValue();
				/*if(history!=null){
					if(history.split("-").length>6){
						history=history.substring(0, history.lastIndexOf("-"));
					}
				}*/
				System.out.println(history);
				//写入cookie
				c.setValue(history);
				c.setMaxAge(60 * 60 * 24 * 7);
				resp.addCookie(c);
			}
			/*			String[] his=history.split("-");
			List list = new ArrayList<Product>();
			for(String id:his){
//				list.add(service.findByID(id));
			}*/
			return history;
		}
		public static String addHistory(HttpServletRequest req, HttpServletResponse resp){
			Cookie[] cookies = req.getCookies();
			String history = null;
			Cookie c=getCookieByName("history", cookies);
			if(c!=null){
			history=c.getValue();
			String pid = req.getParameter("pid");
			if(history.indexOf("pid")==-1){
				if(history==null)
				{
					history+=pid;
				}else{
					history=pid+"-"+history;
				}
			}
			
			c.setValue(history);
			c.setMaxAge(60*60*24*7);
			resp.addCookie(c);
			}
			return history;
		}
		public static String addCart(HttpServletRequest req, HttpServletResponse resp){
			Cookie[] cookies = req.getCookies();
			Cookie c = null;
			String cart = null;
			if(CookUtils.getCookieByName("shoppingcart", cookies)==null){
				c = new Cookie("shoppingcart",cart);
			}else{
				c =  CookUtils.getCookieByName("shoppingcart", cookies);
				cart = c.getValue();
				String pid = req.getParameter("pid");
				String quantity = req.getParameter("quantity");
				//如果购物车中没有这件商品
				if (cart.indexOf(pid) == -1) { //如果是-1，代表字符串cart中没有pid这个字符串
					if (cart == null) {
						cart += "[" + pid + "," + quantity + "]";
					} else {
						cart = "[" + pid + "," + quantity + "]" + "-" + cart;
					}
				}
				//如果购物车中有这件商品
				else {
					String[] s = cart.split("-");
					String str = null;
					for (int i = 0; i < s.length; i++) {
						if (s[i].indexOf(pid) != -1) {
							str = s[i];
						}
					}
					//将之前的字符串中的商品数量替换成现在的商品数量
					cart.replace(str, "[" + pid + "," + quantity + "]");

				}
				}	
			c.setValue(cart);
			c.setMaxAge(60 * 60 * 24 * 7);
			resp.addCookie(c);
			System.out.println("==============");
			System.out.println(cart);
			return cart;
		}
		//删除购物车中的指定物品
		public static String deleteCartBypid(HttpServletRequest req, HttpServletResponse resp){
			Cookie[] cookies = req.getCookies();
			Cookie c = CookUtils.getCookieByName("shoppingcart", cookies);
			String cart = c.getValue();
		/*	if(CookUtils.getCookieByName("shoppingcart", cookies)==null){
				c = new Cookie("shoppingcart",cart);
			}else{*/

			String pid = req.getParameter("pid");
			String quantity = req.getParameter("quantity");
			int from = cart.indexOf("pid");
			//1.如果获取的该商品是购物车中的第一件商品2.否则
			String[] s = cart.split("-");
			if(cart.indexOf(pid)==1){
				
				for(int i=0;i<s.length;i++ ){
					if(s[i].indexOf(pid)!=-1){
						int size = s[i].length();
						cart.substring(from-1, (from-1)+size+1);
					}
				}
			}else{
				for(int i=0;i<s.length;i++){
					if(s[i].indexOf(pid)!=-1){
						int size = s[i].length();
						cart.substring(from-2,(from-1)+size);
					}
				}
			}
			c.setValue(cart);
			c.setMaxAge(60*60*24*7);
			resp.addCookie(c);
			return cart;
		}
		
		public static String empty(HttpServletRequest req, HttpServletResponse resp){
			Cookie[] cookies = req.getCookies();
			Cookie c = CookUtils.getCookieByName("shoppingcart", cookies);
			String cart = c.getValue();
			cart.substring(0);
			c.setValue(cart);
			c.setMaxAge(60*60*24*7);
			resp.addCookie(c);
			return cart;
			
		}

		
}
