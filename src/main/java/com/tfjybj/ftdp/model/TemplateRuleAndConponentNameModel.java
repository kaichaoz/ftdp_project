package com.tfjybj.ftdp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


public class TemplateRuleAndConponentNameModel implements Serializable{


    private String Id;//模板内容表的ID

    private String templateId;//模板ID

    private String componentId;//组件id

    private String title ;//组件标题名称

    private String componentType;//组件类型

}
