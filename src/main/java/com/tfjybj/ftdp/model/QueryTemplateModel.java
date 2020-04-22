package com.tfjybj.ftdp.model;

import com.tfjybj.ftdp.entity.TemplateEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "UserModel:user")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)

public class QueryTemplateModel implements Serializable {
    @Column(name = "id")
    private String id;
    @Column(name = "templateName")
    private String templateName;
    @Column(name = "templateGroupId")
    private String templateGroupId;
    @Column(name = "staffId")
    private String staffId;
    @Column(name = "postscript")
    private String postscript;
    @Column(name = "isUsable ")
    private String isUsable ;
    @Column(name = "groupSequence ")
    private String groupSequence ;
    @Column(name = "isFinish ")
    private String isFinish;

    @Column(name = "TemplateGroupModel ")
    private List<TemplateGroupModel> templateData;

}


