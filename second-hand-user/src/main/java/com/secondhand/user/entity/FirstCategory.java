package com.secondhand.user.entity;

import java.util.List;

public class FirstCategory {
	private Integer fcid;
	private String fcname;
	private List<SecondCategory> SClist;
	private List<Product> plist;
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	public String getFcname() {
		return fcname;
	}
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}
	public List<SecondCategory> getSClist() {
		return SClist;
	}
	public void setSClist(List<SecondCategory> sClist) {
		SClist = sClist;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "FirstCategory [fcid=" + fcid + ", fcname=" + fcname + "]";
	}
}
