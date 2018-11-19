package com.secondhand.user.entity;

/**
 * <p>Title: Product</p>
*<p>Description: 商品实体类</p>
*@author kid_way
*@date 2018-1-9 下午4:11:44
 */
public class Product {
	//商品主键
	private Integer pid;
	//商品名称
	private String pname;
	//商品小图名称
	private String apicname;
	//商品大图名称
	private String bpicname;
	//商品价格
	private Double price;
	//商品库存
	private Integer stock;
	//卖家id
	private Integer sid;
	//一级分类id
	private Integer fcid;
	//二级分类id
	private Integer scid;
	//商品是否下架
	private Integer undercarriage;
	//卖家对象
	private Seller seller;
	//一级分类对象
	private FirstCategory firstCategory;
	//二级分类对象
	private SecondCategory secondCategory;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getApicname() {
		return apicname;
	}
	public void setApicname(String apicname) {
		this.apicname = apicname;
	}
	public String getBpicname() {
		return bpicname;
	}
	public void setBpicname(String bpicname) {
		this.bpicname = bpicname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public FirstCategory getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(FirstCategory firstCategory) {
		this.firstCategory = firstCategory;
	}
	public SecondCategory getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(SecondCategory secondCategory) {
		this.secondCategory = secondCategory;
	}
	public Integer getUndercarriage() {
		return undercarriage;
	}
	public void setUndercarriage(Integer undercarriage) {
		this.undercarriage = undercarriage;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", apicname="
				+ apicname + ", bpicname=" + bpicname + ", price=" + price
				+ ", stock=" + stock + ", sid=" + sid + ", fcid=" + fcid
				+ ", scid=" + scid + "]";
	}
}
