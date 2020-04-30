package com.tfjybj.ftdp.model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;

/**
 * @author 陈海明
 * @Classname TemplateRuleRecordDeleteModel
 * @Date 2020年4月1日19:26:15
 * @Created by 陈海明
 */
@Data
@ApiModel(value = "TemplateRuleRecordDeleteModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)

public class TemplateRuleRecordDeleteModel {
    private String  id;
    private int isDelete;
}
