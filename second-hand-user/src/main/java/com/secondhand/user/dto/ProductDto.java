package com.secondhand.user.dto;

import java.util.List;

import com.secondhand.user.entity.Product;
/**
 * <p>Title: ProductDto</p>
*<p>Description: 商品封装实体类</p>
*@author kid_way
*@date 2018-1-14 下午8:52:47
 */
public class ProductDto {
	//一级分类名称
	private String fcname;
	//二级分类名称
	private String scname;
	//二级分类id
	private Integer scid;
	//商品列表
	private List<Product> pList;
	//总记录数
	private Integer count;
	//总页数
	private Integer pageCount;
	//每页展示的记录数
	private Integer pieces;
	
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPieces() {
		return pieces;
	}
	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getFcname() {
		return fcname;
	}
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public List<Product> getpList() {
		return pList;
	}
	public void setpList(List<Product> pList) {
		this.pList = pList;
	}
	@Override
	public String toString() {
		return "ProductDto [fcname=" + fcname + ", scname=" + scname
				+ ", pList=" + pList + "]";
	}
}
