package xyz.oilpea.wechat.sale.score.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "scoreItme")
public class Scoreitme implements Serializable {
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "large_code")
    private String largeCode;

    @Column(name = "small_code")
    private String smallCode;

    @Column(name = "security_code")
    private String securityCode;

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
}