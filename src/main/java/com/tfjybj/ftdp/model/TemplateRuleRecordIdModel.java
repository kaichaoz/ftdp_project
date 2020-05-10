package com.tfjybj.ftdp.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@ApiModel(value = "TemplateRuleRecordIdModel")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateRuleRecordIdModel {
    @Id
    @Column(name = "id")//tin_templaterulerecord的id
    private String  id;
    @Column(name = "模板id")
    private String  templateId;//模板id
    @Column(name = "模板内容id")
    private String  templateContentId;

    @Column(name = "标题")
    private String title ;//组件标题名称

    @Column(name = "grade")
    private String grade;
    @Column(name = " 性别（0男，1女）")
    private int sex;
    @Column(name = "开始范围")
    private String startRange;
    @Column(name = " 结束范围")
    private String endRange;
    @Column(name = " 原始得分")
    private String originalScore;
    @Column(name = "权重")
    private String weight;
    @Column(name = "评级")
    private String level;
    @Column(name = "操作人")
    private String operator;

    @Column(name = " 创建日期")
    private Date creatTime;



    @Column(name = "是否删除")
    private int isDelete;
}
