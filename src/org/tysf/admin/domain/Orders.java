package org.tysf.admin.domain;

import java.util.Date;
//详细信息
public class Orders {
	private int oid;//订单号
	private Date ordertime;//下单时间
	private int total;
	private String state;//订单状态 1表示未付款，2表示已付款，3表示未发货，4表示已完成，5表示全部订单
	private String address;
	private String name;
	private String telephone;
	private int uid;//订单的所有者
	private int money;//商品总额
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int oid, Date ordertime, int total, String state, String address, String name, String telephone,
			int uid, int money) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.uid = uid;
		this.money = money;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state
				+ ", address=" + address + ", name=" + name + ", telephone=" + telephone + ", uid=" + uid + ", money="
				+ money + "]";
	}

		
}	

