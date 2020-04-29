package com.tfjybj.ftdp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  模板规则表
 * </p>
 *
 */
@Entity
@Table(name="tin_templaterulerecord")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TemplaterulerecordEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * id
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
	 * 年级
	 */
	private String grade;

	/**
	 * 性别（0男，1女）
	 */
	private Integer sex;

	/**
	 * 开始范围
	 */
	@TableField("startRange")
	private String startRange;

	/**
	 * 结束范围
	 */
	@TableField("endRange")
	private String endRange;

	/**
	 * 原始得分
	 */
	@TableField("originalScore")
	private String originalScore;

	/**
	 * 权重
	 */
	private String weight;

	/**
	 * 评级
	 */
	private String level;

	/**
	 * 创建人
	 */
	private String creater;
	/**
	 * 修改人
	 */
	private String modifier;

	/**
	 * 修改时间
	 */
	@TableField("modifyTime")
	private LocalDateTime modifyTime;

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
