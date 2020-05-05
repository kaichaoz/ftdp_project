package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.model.*;
import com.tfjybj.ftdp.provider.service.TemplateContentService;
import com.tfjybj.ftdp.utils.CodeEnumUtils;
import com.tfjybj.ftdp.utils.PatterUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import com.tfjybj.ftdp.model.ComponentlibraryModel;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory;
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
    private TemplateContentService templateContentService;//默认按name注入，可以通过name和type属性进行选择性注入

    /**
     *初始化模板
     * @return templateContentMap
     */
    @ApiOperation("初始化模板")
    @GetMapping(value = "/queryTemplateContent")
    public ResultUtils queryTemplateContent(String templateId){
        List<TemplateContent> templateContentMap = templateContentService.queryTemplateContent(templateId);//调用初始化查询接口
        if (templateContentMap !=null){
            return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(), CodeEnumUtils.SELECT_SUCCESS.getMessage(), templateContentMap);
        }else {
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
    }

    /**
     * 根据isUsable查询
     * @return templateModels
     */
    @ApiOperation("根据isUsable查询模板")
    @GetMapping(value = "/queryTempByIsUsable")
    public ResultUtils queryTempByIsUsable(){
        List<TempByIsUsableModel> templateModels = templateContentService.queryTempByIsUsable();//两表联查查询可用模板
        if (templateModels!=null){
            return  ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),templateModels);
        }
        return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
    }

    /**
     * 添加模板内容
     * @param templateContentModel
     * @return flag
     */
    @ApiOperation("添加模板内容")
    @PostMapping(value = "/insertTemplateContent")
    public ResultUtils insertTemplateContent(@RequestBody List<TemplateContentModel> templateContentModel ){

        boolean flag = templateContentService.addTemplateContent(templateContentModel);
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
        }
        return new ResultUtils(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }

    /**
     * 编辑模板内容
     * @param templateContentRequest
     * @return
     */
    @ApiIgnore
    @ApiOperation("编辑模板内容")
    @PostMapping(value = "/updateTemplateContent")
    public ResultUtils updateTemplateContent(@RequestBody TemplateContentRequest templateContentRequest ){
        boolean flag = templateContentService.updateTemplateContent(templateContentRequest);
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage(), flag);
        }
        return new ResultUtils(CodeEnumUtils.MODIFY_FALL.getCode(),CodeEnumUtils.MODIFY_FALL.getMessage());
    }

    /**
     *添加模板
     * @param templateModel
     * @return flag
     */
    @ApiOperation("添加模板")
    @PostMapping(value = "/insertTemplate")
    public ResultUtils insertTemplate(@RequestBody TemplateModel templateModel){
        String Id = templateModel.getId();
        if ("".equals(Id)){
            templateModel.setId(PatterUtils.getNumberPattern());
        }
        String flag = templateContentService.templateInsert(templateModel);
        if (!flag.isEmpty()){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(),templateModel.getId() );
        }
        return new ResultUtils(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }

    /**
     * 编辑模板
     * @param templateModel
     * @return
     */
    @ApiIgnore
    @ApiOperation("编辑模板")
    @PostMapping(value = "/updateTemplate")
    public ResultUtils updateTemplate(@RequestBody TemplateModel templateModel){
        boolean flag =templateContentService.updateTemplate(templateModel);
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage(), flag);
        }
        return new ResultUtils(CodeEnumUtils.MODIFY_FALL.getCode(),CodeEnumUtils.MODIFY_FALL.getMessage());
    }

    /**
     * 删除模板（修改tin_complate表isUsable字段为1）
     * @param id
     * @return
     */
    @ApiOperation("删除模板")
    @PostMapping(value = "/deleteTemplate/{id}")
    public ResultUtils deleteTemplate(@ApiParam(value = "id",required = true)@PathVariable String id){
        boolean flag = templateContentService.templateDelete(id);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.DELETE_SUCCESS.getCode(),CodeEnumUtils.DELETE_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.DELETE_FALL.getCode(),CodeEnumUtils.DELETE_FALL.getMessage());
    }
    /**
     * 删除模板内容（修改tin_complateContent表isUsable字段为1）
     * @param id
     * @return
     */
    @ApiOperation("删除模板内容")
    @PostMapping(value = "/deleteTemplateContent/{templateId}")
    public ResultUtils deleteTemplateContent(@ApiParam(value = "templateId",required = true)@PathVariable String templateId){
        boolean flag = templateContentService.templateContentDelete(templateId);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.DELETE_SUCCESS.getCode(),CodeEnumUtils.DELETE_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.DELETE_FALL.getCode(),CodeEnumUtils.DELETE_FALL.getMessage());
    }

    /**
     *侧边栏加载
     * @return queryComponentlibrary
     */
    @ApiOperation("侧边栏加载")
    @GetMapping(value = "/queryComponentlibrary")
    public ResultUtils queryComponentlibrary(){
        // TODO 对应接口文档修改接收参数model
        List<ComponentlibraryModel> queryComponentlibrary = templateContentService.queryComponentlibrary();
        if (queryComponentlibrary.size()==0){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return  ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),queryComponentlibrary);
    }

}
