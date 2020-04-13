package com.tfjybj.ftdp.entity;

import lombok.Data;

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
@Table(name="tin_template")
@Data
public class TemplateEntity implements Serializable{

	@Id
	private Integer id;  
	private String tempalteName;
	private String templateGroupID;
	private String staffID;  
	private String postscript;  
	private Integer isUsable;  
	private String groupSequence;  
	private Integer isFinish;  
}
