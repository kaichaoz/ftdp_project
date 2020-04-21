package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ApiModel(value = "TemplateContentModel:TemplateContentModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContentRequest {
    @ApiModelProperty(value = "模板内容id")
    private String id;
    @ApiModelProperty(value = "模板id")
    private String templateId;
    @ApiModelProperty(value = "组件id")
    private String componentId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "提示字段")
    private String promptField;
    @ApiModelProperty(value = "组内字段排序")
    private String fieldSequence;
    @ApiModelProperty(value = "分组排序")
    private String groupSequence;
}
