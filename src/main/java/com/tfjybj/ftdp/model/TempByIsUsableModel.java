package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import java.util.List;

@Data
@ApiModel(value = "TempByIsUsableModel:TempByIsUsableModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TempByIsUsableModel {
    @ApiModelProperty(value = "分组id")
    private String templateGroupId;
    @Column(name = "tempalteGroupName")
    private String templateGroupName;
    @ApiModelProperty(value = "分组内容")
    private List<TempByIsUsableData> tempByIsUsableData;
}

