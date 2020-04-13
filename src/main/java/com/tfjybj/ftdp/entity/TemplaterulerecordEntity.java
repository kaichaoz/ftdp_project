package com.tfjybj.ftdp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tin_templaterulerecord")
@Data
public class TemplaterulerecordEntity implements Serializable{

	@Id
	@Column(name = "id")
	private String  id;
	@Column(name = "templateId")
	private String  templateId;
	@Column(name = "componentId")
	private String  componentId;
	@Column(name = "grade")
	private String grade;
	@Column(name = "sex")
	private int sex;
	@Column(name = "startRange")
	private String startRange;
	@Column(name = "endRange")
	private String endRange;
	@Column(name = "originalScore")
	private String originalScore;
	@Column(name = "weight")
	private String weight;
	@Column(name = "level")
	private String level;
	@Column(name = "creater")
	private String creater;
	@Column(name = "creatTime")
	private Date creatTime;
	@Column(name = "modifier")
	private String modifier;
	@Column(name = "modifyTime")
	private Date modifyTime;
}
