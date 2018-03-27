package org.tysf.domain;

import java.util.Date;
import java.util.List;

public class Order {
   private String oid;//主键
   private Date ordertime;//下单时间
   private double total;
   private int state;
   private String address;//收货地址
   private String name;//用户
   private String telephone;
   private String uid;
   private List<OrderItem> orderItemList;
public List<OrderItem> getOrderItemList() {
	return orderItemList;
}
public void setOrderItemList(List<OrderItem> orderItemList) {
	this.orderItemList = orderItemList;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(String oid, Date ordertime, double total, int state, String address, String name, String telephone,
		String uid) {
	super();
	this.oid = oid;
	this.ordertime = ordertime;
	this.total = total;
	this.state = state;
	this.address = address;
	this.name = name;
	this.telephone = telephone;
	this.uid = uid;
}
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
@Override
public String toString() {
	return "orders [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", address="
			+ address + ", name=" + name + ", telephone=" + telephone + ", uid=" + uid + "]";
}
   
   
   
}
