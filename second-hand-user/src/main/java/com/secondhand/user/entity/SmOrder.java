package com.secondhand.user.entity;

import java.util.Date;

/**
 * <p>Title: SmOrder</p>
*<p>Description: 小订单实体类</p>
*@author kid_way
*@date 2018-1-18 上午12:09:51
 */
public class SmOrder {
	private String soid;
	private String iid;
	private Integer state;
	private Date createTime;
	private String oid;
	private Item item;
	private String raddress;
	private String rphone;
	private String rname;
	private Orders order;

	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public String getSoid() {
		return soid;
	}
	public void setSoid(String soid) {
		this.soid = soid;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
}
