package xyz.oilpea.wechat.app.api.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "headquartersScoreOrders")
public class Headquartersscoreorders implements Serializable {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "item_id")
    private Integer itemId;

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

    @Column(name = "receive_name")
    private String receiveName;

    @Column(name = "score")
    private Integer score;

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
     * @return receive_name
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * @param receiveName
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
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