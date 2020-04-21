package com.tfjybj.ftdp.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;

@Data
@ApiModel(value = "ComponentlibraryModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class ComponentlibraryModel {
    @Column(name = "groupId")
    private String groupId;
    @Column(name = "groupSequence ")
    private String groupSequence ;

}



