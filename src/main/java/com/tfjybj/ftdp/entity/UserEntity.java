package com.tfjybj.ftdp.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Zachary(ÕÅ¿­³¬)
 * @since 2020-04-29
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "tin_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户登录账户

     */
    private String uid;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;


}
