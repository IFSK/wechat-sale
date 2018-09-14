package xyz.oilpea.wechat.app.api.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "agencyStock")
public class Agencystock implements Serializable {
    @Id
    @Column(name = "stock_id")
    private Integer stockId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_stock")
    private Integer itemStock;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @Column(name = "agency_id")
    private Integer agencyId;

    @Column(name = "item_name")
    private String itemName;

    private static final long serialVersionUID = 1L;

    /**
     * @return stock_id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * @param stockId
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * @return item_id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * @return item_stock
     */
    public Integer getItemStock() {
        return itemStock;
    }

    /**
     * @param itemStock
     */
    public void setItemStock(Integer itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * @return item_price
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice
     */
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return agency_id
     */
    public Integer getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId
     */
    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
}