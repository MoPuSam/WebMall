package org.tysf.domain;
public class OrderItem {
	private String itemid;//条目
	private int count;//数量
	private double subtotle;//小计
	private String pid;//产品编号
	private String oid;//订单编号
	/**
	 * 
	 */
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param itemid
	 * @param count
	 * @param subtotle
	 * @param pid
	 * @param oid
	 */
	public OrderItem(String itemid, int count, double subtotle, String pid, String oid) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotle = subtotle;
		this.pid = pid;
		this.oid = oid;
	}
	/**
	 * @return the itemid
	 */
	public String getItemid() {
		return itemid;
	}
	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the subtotle
	 */
	public double getSubtotle() {
		return subtotle;
	}
	/**
	 * @param subtotle the subtotle to set
	 */
	public void setSubtotle(double subtotle) {
		this.subtotle = subtotle;
	}
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotle=" + subtotle + ", pid=" + pid + ", oid="
				+ oid + "]";
	}
	
}
