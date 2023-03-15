package com.example.poetry.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (PUser)实体类
 *
 * @author fauchard
 * @since 2023-01-12 16:41:51
 */
@Data
@Getter
@Setter
public class PUser implements Serializable {
    private static final long serialVersionUID = 175950405382793769L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态
     */
    private String status;


}

