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
@Table(name="tin_templatecontent")
@Data
public class TemplatecontentEntity implements Serializable{

	@Id
	private Integer id;  
	private Integer templateId;
	private Integer componentId;  
	private String title;  
	private Double titleLength;  
	private String inputField;  
	private String promptField;  
	private Double promptFieldLength;  
	private String isUsable;  
	private String groupSequence;  
}
