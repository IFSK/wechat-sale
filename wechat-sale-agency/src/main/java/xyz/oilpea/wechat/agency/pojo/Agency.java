package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "agency")
public class Agency implements Serializable {
    @Id
    @Column(name = "agency_id")
    private Integer agencyId;

    @Column(name = "superior_id")
    private Integer superiorId;

    @Column(name = "level")
    private Integer level;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "invitation_code")
    private String invitationCode;

    @Column(name = "createtime")
    private Date createtime;

    @Column(name = "address")
    private String address;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "wechat_id")
    private String wechatId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "realname")
    private String realname;

    @Column(name = "head_img")
    private String headImg;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;

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
     * @return superior_id
     */
    public Integer getSuperiorId() {
        return superiorId;
    }

    /**
     * @param superiorId
     */
    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return invitation_code
     */
    public String getInvitationCode() {
        return invitationCode;
    }

    /**
     * @param invitationCode
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return bank_account
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * @param bankAccount
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * @return wechat_id
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * @param wechatId
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * @return head_img
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * @param headImg
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}