package com.secondhand.user.dto;

import java.util.List;

import com.secondhand.user.entity.Item;

public class ItemDto {
	private List<Item> items;
	private double total;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
