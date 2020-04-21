package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
@ApiModel(value = "TemplateContentModel:TemplateContentModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContentModel {
    @ApiModelProperty(value = "组件id")
    private String componentId;
    @ApiModelProperty(value = "模板data")
    private TemplateContentModel2 templateContentData2;
    @ApiModelProperty(value = "模板title")
    private List<TemplateContentTitleModel> templateContentTitleModel;
}
