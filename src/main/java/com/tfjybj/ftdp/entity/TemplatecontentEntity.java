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
 * 模板内容表
 * </p>
 *
 * @author Zachary(ÕÅ¿­³¬)
 * @since 2020-04-29
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "tin_templatecontent")
public class TemplatecontentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板内容id
     */
    private String id;

    /**
     * 模板id
     */
    @TableField("templateId")
    private String templateId;

    /**
     * 组件id
     */
    @TableField("componentId")
    private String componentId;

    /**
     * 标题
     */
    private String title;

    /**
     * 标题长度
     */
    @TableField("titleLength")
    private Double titleLength;

    /**
     * 输入字段长度
     */
    @TableField("inputField")
    private String inputField;

    /**
     * 提示字段
     */
    @TableField("promptField")
    private String promptField;

    /**
     * 提示字段长度
     */
    @TableField("promptFieldLength")
    private Double promptFieldLength;

    /**
     * 是否可用(0可用，1不可用)
     */
    @TableField("isUsable")
    private Integer isUsable;

    /**
     * 分组排序
     */
    @TableField("groupSequence")
    private String groupSequence;

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
