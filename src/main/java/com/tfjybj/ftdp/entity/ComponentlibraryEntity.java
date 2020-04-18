package com.tfjybj.ftdp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.websocket.OnClose;

/**
 * @Classname ComponentlibraryEntity
 * @Date 2020年4月2日08点16分
 * created by 曹轩
 */
@ApiModel(value = "组件库表")
@Data
//为类提供一个无参的构造方法
@NoArgsConstructor
@Entity
@TableName(value = "tin_componentlibrary")
public class ComponentlibraryEntity {

    @Id
    @ApiModelProperty(value = "id",required = true)
    @Column(name="id")
    private char id;

    @ApiModelProperty(value="分组名称",required = true)
    @Column(name="groupName")
    private String groupName;

    @ApiModelProperty(value = "分组id",required = true)
    @Column(name="groupId")
    private char groupId;

    @ApiModelProperty(value = "组件id",required = true)
    @Column(name="componentId")
    private char componentId;

    @ApiModelProperty(value="分组排序",required = true)
    @Column(name="groupSequence")
    private char groupSequence;

    @ApiModelProperty(value="是否可用",required = true)
    @Column(name="isUsable")
    private int isUsable;

    @ApiModelProperty(value="组件类型",required = true)
    @Column(name="componentType")
    private char componentType;
}
