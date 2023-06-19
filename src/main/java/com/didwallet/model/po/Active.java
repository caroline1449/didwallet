package com.didwallet.model.po;

import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author itcast
 */
@Data
@TableName("active")
public class Active implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证授权状态，1为授权，0为不授权
     */
    private Integer idActive;

    /**
     * 学籍授权状态
     */
    private Integer stActive;

    /**
     * 公司授权状态
     */
    private Integer cpActive;

    /**
     * 疫苗授权状态
     */
    private Integer vcActive;

    /**
     * 发票授权状态
     */
    private Integer ivActive;

    /**
     * 收据授权状态
     */
    private Integer reActive;

    /**
     * 会议授权状态
     */
    private Integer mtActive;

    /**
     * 门票授权状态
     */
    private Integer tkActive;

    public Active(String email, Integer idActive, Integer stActive, Integer cpActive, Integer vcActive, Integer ivActive,Integer reActive,
                  Integer mtActive,Integer tkActive) {
        this.email = email;
        this.idActive = idActive;
        this.stActive = stActive;
        this.cpActive = cpActive;
        this.vcActive = vcActive;
        this.ivActive = ivActive;
        this.reActive = reActive;
        this.mtActive = mtActive;
        this.tkActive = tkActive;

    }
}
