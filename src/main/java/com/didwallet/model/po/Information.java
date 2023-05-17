package com.didwallet.model.po;

import java.time.Year;
import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 俞静雯
 */
@Data
@TableName("information")
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 邮箱
     */
    private String email;

    private String password;

    /**
     * 姓名，中文、字母、空格
     */
    private String name;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 国家，字母、空格
     */
    private String country;

    /**
     * 地区
     */
    private String area;

    /**
     * 专业
     */
    private String speciality;

    /**
     * 学校
     */
    private String university;

    /**
     * 入学年份
     */
    private String enrollmentYear;

    /**
     * 接种疫苗
     */
    private String vaccinum;

    /**
     * 接种日期
     */
    private LocalDate vaccinationDate;

    /**
     * 接种地址
     */
    private String location;

    /**
     *  公司
     */
    private String company;

    /**
     *  职位
     */
    private String position;

    /**
     *  入职日期
     */
    private LocalDate joinedDate;

    private String did;


}
