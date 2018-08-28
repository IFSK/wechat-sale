package xyz.oilpea.wechat.sale.core.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "app_api")
public class AppApi implements Serializable {
    @Column(name = "accessToken")
    private String accesstoken;

    private static final long serialVersionUID = 1L;

    /**
     * @return accessToken
     */
    public String getAccesstoken() {
        return accesstoken;
    }

    /**
     * @param accesstoken
     */
    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }
}