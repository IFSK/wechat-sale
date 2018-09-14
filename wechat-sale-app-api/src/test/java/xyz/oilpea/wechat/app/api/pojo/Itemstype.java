package xyz.oilpea.wechat.app.api.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "itemsType")
public class Itemstype implements Serializable {
    @Id
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "item_price")
    private Integer itemPrice;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_img")
    private String itemImg;

    @Column(name = "item_head_img")
    private String itemHeadImg;

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
     * @return item_brand
     */
    public String getItemBrand() {
        return itemBrand;
    }

    /**
     * @param itemBrand
     */
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand == null ? null : itemBrand.trim();
    }

    /**
     * @return item_price
     */
    public Integer getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice
     */
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
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
     * @return item_img
     */
    public String getItemImg() {
        return itemImg;
    }

    /**
     * @param itemImg
     */
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg == null ? null : itemImg.trim();
    }

    /**
     * @return item_head_img
     */
    public String getItemHeadImg() {
        return itemHeadImg;
    }

    /**
     * @param itemHeadImg
     */
    public void setItemHeadImg(String itemHeadImg) {
        this.itemHeadImg = itemHeadImg == null ? null : itemHeadImg.trim();
    }
}