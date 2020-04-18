package com.tfjybj.ftdp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Classname UserIEntity
 * @Date 2020/1/18 16:26
 * @Created by 张凯超
 */
@ApiModel(value = "用户表")
@Data
@NoArgsConstructor
@Entity
@TableName(value = "tin_user")
public class UserEntity {
    @Id
    @ApiModelProperty(value = "用户Id" ,required = true)
    @Column(name = "uid")
    private String userId;

    @ApiModelProperty(value = "用户姓名" ,required = true)
    @Column(name = "name")
    private String userName;

    @ApiModelProperty(value = "用户密码" ,required = true)
    @Column(name = "password")
    private String passWord;


}
