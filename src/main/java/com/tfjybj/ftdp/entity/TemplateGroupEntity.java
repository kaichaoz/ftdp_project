package com.tfjybj.ftdp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tin_templategroup")
@Data
public class TemplateGroupEntity implements Serializable{



	@Column(name = "id")
	private String id;
	@Column(name = "tempalteGroupName")
	private String tempalteGroupName;
	@Column(name = "isUsable")
	private Integer isUsable;
	@Column(name = "groupSequence")
	private String groupSequence; 
}
