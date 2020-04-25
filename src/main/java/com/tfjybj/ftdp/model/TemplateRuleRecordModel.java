package com.tfjybj.ftdp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tin_templaterulerecord")
@Data
public class TemplateRuleRecordModel implements Serializable{

    @Id
    @Column(name = "id")
    private String  id;
    @Column(name = "templateId")
    private String  templateId;
    @Column(name = "templateContentId")
    private String  templateContentId;
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
    @Column(name = "creater")
    private String creater;
    @Column(name = "creatTime")
    private Date creatTime;
    @Column(name = "modifier")
    private String modifier;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String  getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String  templateId) {
        this.templateId = templateId;
    }

    public String  getTemplateContentId() {
        return templateContentId;
    }

    public void setTemplateContentId(String  templateContentId) {
        this.templateContentId = templateContentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getStartRange() {
        return startRange;
    }

    public void setStartRange(String startRange) {
        this.startRange = startRange;
    }

    public String getEndRange() {
        return endRange;
    }

    public void setEndRange(String endRange) {
        this.endRange = endRange;
    }

    public String getOriginalScore() {
        return originalScore;
    }

    public void setOriginalScore(String originalScore) {
        this.originalScore = originalScore;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Column(name = "modifyTime")
    private Date modifyTime;
}
