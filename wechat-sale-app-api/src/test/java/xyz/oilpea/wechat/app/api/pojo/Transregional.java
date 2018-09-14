package xyz.oilpea.wechat.app.api.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "transregional")
public class Transregional implements Serializable {
    @Id
    @Column(name = "transregional_id")
    private Integer transregionalId;

    @Column(name = "agency_id")
    private Integer agencyId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "state")
    private Integer state;

    @Column(name = "result")
    private String result;

    private static final long serialVersionUID = 1L;

    /**
     * @return transregional_id
     */
    public Integer getTransregionalId() {
        return transregionalId;
    }

    /**
     * @param transregionalId
     */
    public void setTransregionalId(Integer transregionalId) {
        this.transregionalId = transregionalId;
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
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}