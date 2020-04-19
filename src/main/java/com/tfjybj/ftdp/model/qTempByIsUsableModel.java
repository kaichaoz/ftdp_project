package com.tfjybj.ftdp.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class qTempByIsUsableModel {
    @Id
    @Column(name = "id")
    private String templateId;
    @Column(name = "tempalteGroupName")
    private String templateGroupName;
    @Column(name = "isUsable")
    private Integer isUsable;
    private String tempalteName;
    private String templateGroupId;



}
