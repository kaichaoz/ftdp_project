package com.tfjybj.ftdp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Classname TemplateGroupModel
 * @Description TODO
 * @Date 2020/4/1 18:55
 * @Author by 张凯超
 * @Version 1.0
 */
@Data
public class TemplateGroupModel implements Serializable{
    @Column(name = "id")
    private String id;
    @Column(name = "tempalteName")
    private String tempalteName;
    @Column(name = "isUsable")
    private Integer isUsable;
    @Column(name = "groupSequence")
    private String groupSequence;
}
