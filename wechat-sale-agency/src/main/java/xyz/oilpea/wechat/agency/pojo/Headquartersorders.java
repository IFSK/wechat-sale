package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "headquartersOrders")
public class Headquartersorders implements Serializable {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "createtime")
    private Date createtime;

    @Column(name = "order_state")
    private Integer orderState;

    @Column(name = "receive_id")
    private Integer receiveId;

    @Column(name = "receive_address")
    private String receiveAddress;

    @Column(name = "receive_phone")
    private String receivePhone;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "send_address")
    private String sendAddress;

    @Column(name = "sned_phone")
    private String snedPhone;

    @Column(name = "state")
    private Integer state;

    @Column(name = "remarks")
    private String remarks;

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
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return order_state
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * @param orderState
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * @return receive_id
     */
    public Integer getReceiveId() {
        return receiveId;
    }

    /**
     * @param receiveId
     */
    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * @return receive_address
     */
    public String getReceiveAddress() {
        return receiveAddress;
    }

    /**
     * @param receiveAddress
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    /**
     * @return receive_phone
     */
    public String getReceivePhone() {
        return receivePhone;
    }

    /**
     * @param receivePhone
     */
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    /**
     * @return money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * @return send_address
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * @param sendAddress
     */
    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress == null ? null : sendAddress.trim();
    }

    /**
     * @return sned_phone
     */
    public String getSnedPhone() {
        return snedPhone;
    }

    /**
     * @param snedPhone
     */
    public void setSnedPhone(String snedPhone) {
        this.snedPhone = snedPhone == null ? null : snedPhone.trim();
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
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}