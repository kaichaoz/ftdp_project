package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;

@Data
@ApiModel(value = "TemplateContentModel:TemplateContentModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContentModel2 {
    @ApiModelProperty(value = "模板id")
    private String id;
    @ApiModelProperty(value = "标题")
    private String title ;
    @ApiModelProperty(value = "组内字段排序")
    private String fieldSequence;
    @ApiModelProperty(value = "是否可用")
    private String isUsable ;
    @ApiModelProperty(value = "分组排序")
    private String groupSequence;
    @ApiModelProperty(value = "组件id")
    private String componentId;
}
