package com.tfjybj.ftdp.model;

import lombok.Data;

import java.util.List;

/**
 * @author 商俊帅
 * @data 2020/5/7 14:46
 */
@Data
public class TemplateRuleRecordContentModel {

    private  List<TemplateRuleRecordUnderContentModel> trrucm;

    private List<TemplateTitlesModel> titlesModelList;

}
