package com.ms1491.modules.api.utils;

import java.util.List;

import com.ms1491.modules.shop.entity.StoreGoodsEntity;

public class GoodscategoryResponse {
	
	private String icon;
	
	private String name;
	
	private String goodscategoryId;
	
	private List<StoreGoodsEntity> storeGoods;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoodscategoryId() {
		return goodscategoryId;
	}

	public void setGoodscategoryId(String goodscategoryId) {
		this.goodscategoryId = goodscategoryId;
	}

	public List<StoreGoodsEntity> getStoreGoods() {
		return storeGoods;
	}

	public void setStoreGoods(List<StoreGoodsEntity> storeGoods) {
		this.storeGoods = storeGoods;
	}
	
	
}
