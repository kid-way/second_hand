package com.secondhand.user.entity;

public class SecondCategory {
	private Integer scid;
	private String scname;
	private Integer fcid;
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	@Override
	public String toString() {
		return "SecondCategory [scid=" + scid + ", scname=" + scname
				+ ", fcid=" + fcid + "]";
	}
}
