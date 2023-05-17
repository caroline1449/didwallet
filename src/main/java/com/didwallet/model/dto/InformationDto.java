package com.didwallet.model.dto;

import com.didwallet.model.po.Information;
import lombok.Data;
import lombok.ToString;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  16:40
 */
@Data
@ToString
public class InformationDto extends Information {
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
}
