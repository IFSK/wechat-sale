package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "agencyOrderDetail")
public class Agencyorderdetail implements Serializable {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_count")
    private Integer itemCount;

    private static final long serialVersionUID = 1L;

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * @return item_count
     */
    public Integer getItemCount() {
        return itemCount;
    }

    /**
     * @param itemCount
     */
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}