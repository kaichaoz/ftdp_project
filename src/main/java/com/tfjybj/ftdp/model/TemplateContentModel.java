package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
@Data
@ApiModel(value = "UserModel:user")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContentModel {
    @Column(name = "id")
    private String id;
    @Column(name = "templateId")
    private String templateId;
    @Column(name = "componentId")
    private String componentId;
    @Column(name = "promptFleld")
    private String promptFleld;
    @Column(name = "groupSequence")
    private String groupSequence;
    @Column(name = "title ")
    private String title ;

}
