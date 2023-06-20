package com.didwallet.model.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("other")
public class Other implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    @TableId(type = IdType.AUTO)
    private Long id;

    private String text;

    private String data;
}
