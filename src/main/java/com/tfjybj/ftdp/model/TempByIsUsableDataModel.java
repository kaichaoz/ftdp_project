package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class TempByIsUsableDataModel {
    @Id
    @ApiModelProperty(value = "模板id")
    private String templateId;
    @ApiModelProperty(value = "模板分组名称")
    private String templateGroupName;
    @ApiModelProperty(value = "模板名称")
    private String templateName;
    @ApiModelProperty(value = "模板分组Id")
    private String templateGroupId;
}
