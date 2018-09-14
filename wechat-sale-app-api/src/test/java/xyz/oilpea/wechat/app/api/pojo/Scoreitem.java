package xyz.oilpea.wechat.app.api.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "scoreItem")
public class Scoreitem implements Serializable {
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "itemType_id")
    private Integer itemtypeId;

    @Column(name = "large_code")
    private String largeCode;

    @Column(name = "small_code")
    private String smallCode;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "is_used")
    private String isUsed;

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
     * @return itemType_id
     */
    public Integer getItemtypeId() {
        return itemtypeId;
    }

    /**
     * @param itemtypeId
     */
    public void setItemtypeId(Integer itemtypeId) {
        this.itemtypeId = itemtypeId;
    }

    /**
     * @return large_code
     */
    public String getLargeCode() {
        return largeCode;
    }

    /**
     * @param largeCode
     */
    public void setLargeCode(String largeCode) {
        this.largeCode = largeCode == null ? null : largeCode.trim();
    }

    /**
     * @return small_code
     */
    public String getSmallCode() {
        return smallCode;
    }

    /**
     * @param smallCode
     */
    public void setSmallCode(String smallCode) {
        this.smallCode = smallCode == null ? null : smallCode.trim();
    }

    /**
     * @return security_code
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * @param securityCode
     */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode == null ? null : securityCode.trim();
    }

    /**
     * @return is_used
     */
    public String getIsUsed() {
        return isUsed;
    }

    /**
     * @param isUsed
     */
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }
}