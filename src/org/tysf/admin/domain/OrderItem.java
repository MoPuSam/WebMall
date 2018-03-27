package org.tysf.admin.domain;
//订单信息
public class OrderItem {
	private int itemid;//订单编号
	private int count;
	private int subtotal;//钱
	private int pid;//产品ID
	private int oid;//订单单号
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int itemid, int count, int subtotal, int pid, int oid) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.pid = pid;
		this.oid = oid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Orderitem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", pid=" + pid + ", oid="
				+ oid + "]";
	}
	
}
