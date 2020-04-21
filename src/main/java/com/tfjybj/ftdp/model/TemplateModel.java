package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;

/**
 * @author 车龙梁
 * @Classname TemplateModel
 * @Date 2020年4月1日19:26:15
 * @Created by 车龙梁
 */
@Data
@ApiModel(value = "TemplateModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateModel {

    private String id;//模板ID
    @Column(name = "templateName")
    private String templateName;//模板名称
    @Column(name = "templateGroupingID")
    private String templateGroupID;//模板分组ID
    @Column(name = "staffID")
    private String staffID;//人员ID
    @Column(name = "postscript")
    private String postscript;//备注
    @Column(name = "isUsable")
    private int isUsable;//是否可用（0可用，1不可用）
    @Column(name = "groupSequence")
    private String groupSequence;//分组排序
    @Column(name = "isFinish")
    private int isFinish;//是否编辑完成（0完成，1未完成）

}
