package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;

public class ConciseOrders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer orderId;
	
	private String itemName;
	
	private Integer itemCount;
	
	private String itemHeadImg;

	public ConciseOrders() {
		super();
	}

	public ConciseOrders(Integer orderId, String itemName, Integer itemCount, String itemHeadImg) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemHeadImg = itemHeadImg;
	}

	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemHeadImg() {
		return itemHeadImg;
	}

	public void setItemHeadImg(String itemHeadImg) {
		this.itemHeadImg = itemHeadImg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
