package xyz.oilpea.wechat.sale.core.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "inform")
public class Inform implements Serializable {
    @Column(name = "inform_id")
    private Integer informId;

    @Column(name = "informer_id")
    private Integer informerId;

    @Column(name = "defendant_id")
    private Integer defendantId;

    @Column(name = "reason")
    private String reason;

    private static final long serialVersionUID = 1L;

    /**
     * @return inform_id
     */
    public Integer getInformId() {
        return informId;
    }

    /**
     * @param informId
     */
    public void setInformId(Integer informId) {
        this.informId = informId;
    }

    /**
     * @return informer_id
     */
    public Integer getInformerId() {
        return informerId;
    }

    /**
     * @param informerId
     */
    public void setInformerId(Integer informerId) {
        this.informerId = informerId;
    }

    /**
     * @return defendant_id
     */
    public Integer getDefendantId() {
        return defendantId;
    }

    /**
     * @param defendantId
     */
    public void setDefendantId(Integer defendantId) {
        this.defendantId = defendantId;
    }

    /**
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}