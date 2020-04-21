package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    @Column(name = "componentId")
    @ApiModelProperty(value = "模板id")
    private String templateId ;//模板id
    private String componentId;
    @Column(name = "templateContentData2")
    private TemplateContentModel2 templateContentData2;
    @Column(name = "templateContentTitleModel")
    private List<TemplateContentTitleModel> templateContentTitleModel;
}
