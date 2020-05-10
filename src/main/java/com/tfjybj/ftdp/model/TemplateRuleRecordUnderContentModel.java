package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 商俊帅
 * @data 2020/5/7 9:59
 */
@Data
@ApiModel(value = "TemplateModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateRuleRecordUnderContentModel {

    private String Id;
    private String title;
    private String titleValue;
    private Integer isTrue;
    private int position;

}
