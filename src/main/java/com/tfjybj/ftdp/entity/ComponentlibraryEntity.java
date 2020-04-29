package com.tfjybj.ftdp.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 组件库表
 * </p>
 *
 * @author Zachary(ÕÅ¿­³¬)
 * @since 2020-04-29
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "tin_componentlibrary")
public class ComponentlibraryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 分组名称
     */
    @TableField("groupName")
    private String groupName;

    /**
     * 分组id
     */
    @TableField("groupId")
    private String groupId;

    /**
     * 组件id
     */
    @TableField("componentId")
    private String componentId;

    /**
     * 分组排序
     */
    @TableField("groupSequence")
    private String groupSequence;

    /**
     * 是否可用
     */
    @TableField("isUsable")
    private Integer isUsable;

    /**
     * 组件类型
     */
    @TableField("componentType")
    private String componentType;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 是否删除（0未删除 1 已删除）
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    private LocalDateTime creatTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;


}
