package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
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
    private String templateId;
    private Integer isUsable;
    private String tempalteName;
}
