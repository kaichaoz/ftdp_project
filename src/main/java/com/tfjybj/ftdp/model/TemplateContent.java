package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "tin_templatecontent")
@ApiModel(value = "TemplateContent:TemplateContent")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContent implements Serializable {
    @ApiModelProperty(value = "模板id")
    private String templateId ;//模板id
    @ApiModelProperty(value = "组件内容")
    private TemplateContentModel templateContentData;
}
