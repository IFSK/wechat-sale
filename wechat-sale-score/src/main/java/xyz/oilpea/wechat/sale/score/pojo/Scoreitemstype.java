package xyz.oilpea.wechat.sale.score.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "scoreItemsType")
public class Scoreitemstype implements Serializable {
    @Id
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_img")
    private String itemImg;

    @Column(name = "item_head_img")
    private String itemHeadImg;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_description")
    private Date itemDescription;

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

    /**
     * @return item_category
     */
    public String getItemCategory() {
        return itemCategory;
    }

    /**
     * @param itemCategory
     */
    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory == null ? null : itemCategory.trim();
    }

    /**
     * @return item_description
     */
    public Date getItemDescription() {
        return itemDescription;
    }

    /**
     * @param itemDescription
     */
    public void setItemDescription(Date itemDescription) {
        this.itemDescription = itemDescription;
    }
}