package com.tfjybj.ftdp.model;

import lombok.Data;
import javax.persistence.Column;
import java.io.Serializable;


/**
 * @author 张凯超
 * @Classname UserModel
 * @Date 2020/1/18 16:26
 * @Created by 张凯超
 */
@Data
public class UserModel implements Serializable {
    @Column(name = "uid")
    private String userId;
    @Column(name = "password")
    private String passWord;
    @Column(name = "name")
    private String name;
}
