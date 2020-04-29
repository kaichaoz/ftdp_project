package com.tfjybj.ftdp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class TemplateRuleRecordUpdateModel {
    @Id
    @Column(name = "id")
    private String  id;
    @Column(name = "templateId")
    private String  templateId;
    @Column(name = "templateContentId")
    private String  templateContentId;

    @Column(name = "title")
    private String title ;//组件标题名称

    @Column(name = "grade")
    private String grade;
    @Column(name = "sex")
    private int sex;
    @Column(name = "startRange")
    private String startRange;
    @Column(name = "endRange")
    private String endRange;
    @Column(name = "originalScore")
    private String originalScore;
    @Column(name = "weight")
    private String weight;
    @Column(name = "level")
    private String level;
    @Column(name = "modifier")
    private String modifier;
    @Column(name = "modifyTime")
    private Date modifyTime;
    @Column(name = "isUsable")
    private int isUsable;
}
