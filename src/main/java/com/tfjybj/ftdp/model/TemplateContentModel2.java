package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
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
    @Column(name = "id")
    private String id;
    @Column(name = "title ")
    private String title ;
    @Column(name = "fieldSequence")
    private String fieldSequence;
    @Column(name = "isUsable ")
    private String isUsable ;
    @Column(name = "groupSequence")
    private String groupSequence;


}
