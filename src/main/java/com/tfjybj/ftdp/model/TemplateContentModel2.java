package com.tfjybj.ftdp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.util.List;

@Data
@ApiModel(value = "TemplateContentModel:TemplateContentMode2")
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class TemplateContentModel2 {
    @Column(name = "组件内容id")
    private String id;
    @ApiModelProperty(name = "标题 ")
    private String title ;
    @ApiModelProperty(name = "组内字段排序")
    private String fieldSequence;
    @ApiModelProperty(name = "提示字段")
    private String promptField;
    @Column(name = "是否可用 ")
    private String isUsable ;

}
