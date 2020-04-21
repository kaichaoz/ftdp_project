package com.tfjybj.ftdp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class TempByIsUsableDataModel {
    @Id
    private String templateId;
    private String templateGroupName;
    private String tempalteName;
    private String templateGroupId;
}
