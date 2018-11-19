package com.secondhand.user.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: Order</p>
*<p>Description:大订单实体类 </p>
*@author kid_way
*@date 2018-1-18 上午12:14:28
 */
public class Orders {
	private String oid;
	private Date createTime;
	private Integer uid;
	private double total;
	private Integer state;
	private List<SmOrder> list;
	private Map<Seller,List<SmOrder>> map;
	private String rname;
	private String rphone;
	private String raddress;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public List<SmOrder> getList() {
		return list;
	}
	public void setList(List<SmOrder> list) {
		this.list = list;
	}
	public Map<Seller, List<SmOrder>> getMap() {
		return map;
	}
	public void setMap(Map<Seller, List<SmOrder>> map) {
		this.map = map;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
}
