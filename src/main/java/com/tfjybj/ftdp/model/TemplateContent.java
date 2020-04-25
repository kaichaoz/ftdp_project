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

//    @ApiModelProperty(value = "组件内容")
//    private List<TemplateContentModel> templateContentData;

    @ApiModelProperty(value = "模板id")
    private String templateId;
    @ApiModelProperty(value = "组件id")
    private String componentId;
    @Column(name = "分组排序")
    private String groupSequence;
    @ApiModelProperty(value = "模板")
    private List<TemplateContentModel> templateContentData;
}
