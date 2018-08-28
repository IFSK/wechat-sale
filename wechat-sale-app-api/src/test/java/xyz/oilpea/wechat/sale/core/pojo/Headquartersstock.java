package xyz.oilpea.wechat.sale.core.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "headquartersStock")
public class Headquartersstock implements Serializable {
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_stock")
    private Integer itemStock;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    private static final long serialVersionUID = 1L;

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
}