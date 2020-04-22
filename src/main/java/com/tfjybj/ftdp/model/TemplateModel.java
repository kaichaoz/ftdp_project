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

    private String templateName;//模板名称

    private String templateGroupID;//模板分组ID

    private String staffID;//人员ID

    private String postscript;//备注

    private int isUsable;//是否可用（0可用，1不可用）

    private String groupSequence;//分组排序

    private int isFinish;//是否编辑完成（0完成，1未完成）

}
