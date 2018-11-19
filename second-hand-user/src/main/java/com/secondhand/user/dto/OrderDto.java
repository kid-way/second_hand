package com.secondhand.user.dto;

import java.util.List;
import java.util.Map;

import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.SmOrder;

public class OrderDto {
	private Map<Integer,List<SmOrder>> map1;
	private Map<Integer,Seller> map2;
	public Map<Integer, List<SmOrder>> getMap1() {
		return map1;
	}
	public void setMap1(Map<Integer, List<SmOrder>> map1) {
		this.map1 = map1;
	}
	public Map<Integer, Seller> getMap2() {
		return map2;
	}
	public void setMap2(Map<Integer, Seller> map2) {
		this.map2 = map2;
	}
}
