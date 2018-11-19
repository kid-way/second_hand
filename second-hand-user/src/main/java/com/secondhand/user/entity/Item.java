package com.secondhand.user.entity;

/**
 * <p>Title: Item</p>
*<p>Description: 条目实体类</p>
*@author kid_way
*@date 2018-1-15 下午8:23:46
 */
public class Item {
	//条目id
	private String iid;
	//小计
	private double subtotal;
	//购买商品数量
	private Integer count;
	//商品id
	private Integer pid;
	//用户id
	private Integer uid;
	//商品对象
	private Product product;
	//用户对象
	private User user;
	
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", subtotal=" + subtotal + ", count="
				+ count + ", pid=" + pid + ", uid=" + uid + ", product="
				+ product + ", user=" + user + "]";
	}
}
