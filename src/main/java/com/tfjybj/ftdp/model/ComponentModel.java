package com.tfjybj.ftdp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @author 曹轩
 * @Classname ComponentModel
 * @Date 2020年4月1日
 */


@Table(name="tin_component")
@Data
public class ComponentModel implements Serializable {

    @Column(name="groupName")
    private String groupName;

    @Column(name="groupId")
    private String groupld;

    @Column(name="componentId")
    private String componentId;

    @Column(name="groupSequence")
    private String groupSequence;

    @Column(name="isUsable")
    private String isUsable;


//    @Column(name="id")
//    List<ComponentIdModel> data;
}
