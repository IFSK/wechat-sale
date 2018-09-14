package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer itemId;
	
	private Integer itemStock;
	
	private String itemName;
	
	private BigDecimal itemPrice;
	
	private Integer agencyId;
	
	private String itemHeadImg;

	public StockInfo() {
		super();
	}

	public StockInfo(Integer itemId, Integer itemStock, String itemName, BigDecimal itemPrice, Integer agencyId,
			String itemHeadImg) {
		super();
		this.itemId = itemId;
		this.itemStock = itemStock;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.agencyId = agencyId;
		this.itemHeadImg = itemHeadImg;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemStock() {
		return itemStock;
	}

	public void setItemStock(Integer itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
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
