package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.model.QueryTemplateModel;
import com.tfjybj.ftdp.model.TemplateContent;
import com.tfjybj.ftdp.model.TempByIsUsableModel;
import com.tfjybj.ftdp.provider.service.TemplateContentService;
import com.tfjybj.ftdp.utils.CodeEnumUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = {"模板接口"})
@RequestMapping(value = "/templateDesign")
@RestController
/**
 * @Classname templateDesignController
 * @Date 2020年4月2日09:03:07
 * @Created by 车龙梁
 */
public class TemplateDesignController {

    @Resource
    private TemplateContentService templateContentService;

    /**
     *初始化全部模板列表
     * @return
     */
    @ApiOperation("初始化全部模板列表")
    @RequestMapping(value = "/queryTemplateContent",method = RequestMethod.GET)
    public ResultUtils queryTemplateContent(String templateId){
        // TODO 对应接口文档修改接收参数model
        //List<TemplateContent> templateContentList
        List<TemplateContent> templateContentMap = templateContentService.queryTemplateContent(templateId);
        if (templateContentMap ==null){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }else {
            //String json = JSON.toJSONString(templateContentMap);
            return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(), CodeEnumUtils.SELECT_SUCCESS.getMessage(), templateContentMap);
        }
    }

    /**
     * 根据isUsable查询
     * @param isUsable
     * @return
     */
    @ApiOperation("根据isUsable查询模板")
    @GetMapping(value = "/queryTempByIsUsable/{isUsable}")
    public ResultUtils queryTempByIsUsable(@ApiParam(value = "是否可用",required = true)@PathVariable("isUsable") int isUsable){
        // TODO 对应接口文档修改接收参数model
        List<TempByIsUsableModel> templateModels = templateContentService.queryTempByIsUsable(isUsable);
        if (templateModels.size()==0){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return  ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),templateModels);
    }

    /**
     * 添加模板内容
     * @param id 组件id
     * @param templateId 模板id
     * @param componentId 组件id
     * @param title 提示字段
     * @param promptField 分组排序
     * @param groupSequence 标题
     * @return
     */
    @ApiOperation("添加模板内容")
    @RequestMapping(value = "/insertTemplateContent/{id}/{templateId}/{componentId}/{title}/{promptField}/{groupSequence}",method = RequestMethod.POST)
    public ResultUtils insertTemplateContent(@ApiParam(value = "模板内容id",required = true) @PathVariable String id ,
                                          @ApiParam(value = "模板id",required = true) @PathVariable String templateId ,
                                          @ApiParam(value = "组件id",required = true) @PathVariable String componentId ,
                                          @ApiParam(value = "提示字段",required = true) @PathVariable String title ,
                                          @ApiParam(value = "分组排序",required = true) @PathVariable String promptField ,
                                          @ApiParam(value = "标题",required = true) @PathVariable String groupSequence
                                          ){
        boolean flag = templateContentService.addTemplateContent(id,templateId,componentId,title,promptField,groupSequence);
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
        }
        return new ResultUtils(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }

    @ApiOperation("添加模板")
    @PostMapping(value = "/insertTemplate/{id}/{templateName}/{templateGroupID}/{staffID}/{postscript}/{isUsable}/{groupSequence}/{isFinish}")
    public ResultUtils insertTemplate(@ApiParam(value = "模板id",required = true) @PathVariable String id ,
                                      @ApiParam(value = "模板名称",required = true) @PathVariable String templateName ,
                                      @ApiParam(value = "模板分组id",required = true) @PathVariable String templateGroupID ,
                                      @ApiParam(value = "人员id",required = true) @PathVariable String staffID ,
                                      @ApiParam(value = "备注",required = true) @PathVariable String postscript ,
                                      @ApiParam(value = "是否可用（0可用1不可用）",required = true) @PathVariable String isUsable,
                                      @ApiParam(value = "分组排序",required = true) @PathVariable String groupSequence ,
                                      @ApiParam(value = "是否编辑完成（0完成，1未完成）",required = true) @PathVariable String isFinish
                                    ){
        boolean flag = templateContentService.templateInsert(id,templateName,templateGroupID,staffID,postscript,isUsable,groupSequence,isFinish);

        if (flag){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
        }
        return new ResultUtils(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());

    }

    /**
     * 删除模板（修改tin_complateContent表isUsable字段为1）
     * @param id
     * @return
     */
    @ApiOperation("删除模板")
    @RequestMapping(value = "/deleteTemplate/{id}",method = RequestMethod.POST)
    public ResultUtils deleteTemplate(@ApiParam(value = "id",required = true)@PathVariable String id){
        boolean flag = templateContentService.templateDelete(id);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.DELETE_SUCCESS.getCode(),CodeEnumUtils.DELETE_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.DELETE_FALL.getCode(),CodeEnumUtils.DELETE_FALL.getMessage());
    }
    /**
     * 模板编辑界面加载
     * @param id
     * @return
     */
    @ApiOperation("模板编辑界面加载")
    @RequestMapping(value = "/queryTemplate/{id}",method = RequestMethod.GET)
    public ResultUtils queryTemplate (@ApiParam (value="id",required = true)@PathVariable String id){
        QueryTemplateModel queryTemplateModels=templateContentService.queryTemplate(id);
        if (queryTemplateModels == null){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return  ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),queryTemplateModels);

    }
    
}
