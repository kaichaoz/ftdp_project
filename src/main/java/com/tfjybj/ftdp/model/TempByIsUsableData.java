package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@ApiModel(value = "TempByIsUsableData:TempByIsUsableData")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TempByIsUsableData {
    @Id
    @ApiModelProperty(value = "模板id")
    private String templateId;
    @ApiModelProperty(value = "模板名称")
    private String templateName;
    @ApiModelProperty(value = "备注")
    private String postscript;

}
