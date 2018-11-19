package com.secondhand.user.entity;

/**
 * <p>Title: Seller</p>
*<p>Description: 卖家实体类</p>
*@author kid_way
*@date 2018-1-8 下午10:36:18
 */
public class Seller {
	//卖家id
	private Integer sid;
	//卖家名称
	private String sname;
	//卖家登录密码
	private String password;
	//卖家电话
	private String sphone;
	//卖家性别
	private int gender;
	//卖家年龄
	private Integer age;
	//卖家地址
	private String address;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + ", password="
				+ password + ", sphone=" + sphone + ", gender=" + gender
				+ ", age=" + age + ", address=" + address + "]";
	}
}
