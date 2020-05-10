package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordContentModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordIdModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import com.tfjybj.ftdp.provider.service.TemplateRuleRecordService;
import com.tfjybj.ftdp.utils.CodeEnumUtils;
import com.tfjybj.ftdp.utils.PatterUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname TemplateRuleRecordController
 * @Description TODO
 * @Date 2020/4/1 15:5
 * @Author by 陈海明
 * @Version 1.0
 */
@Api(tags = {"模板规则接口"})
@RequestMapping(value = "/templateRuleRecord")
@RestController
public class TemplateRuleRecordController {

    @Resource
    private TemplateRuleRecordService templateRuleRecordService;
    /**
     * @Description:  初始化模板规则
     * @Return: com.tfjybj.ftdp.utils.ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:23
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @ApiOperation(value = "根据templateId查模板规则页面的规则")
    @GetMapping(value = "/queryTemplateRuleRecord/{templateId}")
    public ResultUtils queryTemplateRuleRecord(@ApiParam(value = "模板id",required=true)@RequestParam  String  templateId){
        List<TemplaterulerecordEntity> TemplateRuleRecordModels = templateRuleRecordService.queryTemplateRuleRecord(templateId);
        if (TemplateRuleRecordModels .size() == 0 ){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),TemplateRuleRecordModels );
    }

    /**
     * @Author: 商俊帅
     * @Date : 2020/5/9 11:08
     * @Param templaterecordId, templateId
     * @Return : ResultUtils
     **/
    @ApiOperation(value="根据templaterulerecordId拿到上面两者")
    @GetMapping(value = "queryTemplateRecordContent/{templaterulerecordId}/{templateId}")
    public ResultUtils queryTemplateRecordContent(@PathVariable("templaterulerecordId") String templaterulerecordId, @PathVariable String templateId){
        TemplateRuleRecordContentModel templateRuleRecordContentModelList = templateRuleRecordService.queryTemplateRecordContent(templaterulerecordId,templateId);
        return ResultUtils.build("","",templateRuleRecordContentModelList);
    }


    /**
     * @Description: 添加模板规则设置
     * @Param: @ApiParam(value = "模板规则")
     @ApiParam(value = "模板规则")
      * @Return: ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:29
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @ApiOperation(value = "添加模板规则设置")
    @PostMapping(value = "/addTemplateRuleRecord")
    public ResultUtils addTemplateRuleRecord(@RequestBody TemplateRuleRecordModel templateRuleRecordModel){
        String  Id = templateRuleRecordModel.getId();
        if("".equals(Id)) {//比较字符串中所包含的内容是否相同
            templateRuleRecordModel.setId(PatterUtils.getNumberPattern());
        }
        String flag = templateRuleRecordService.addTemplateRuleRecord(templateRuleRecordModel);
        if (!flag.isEmpty()){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), templateRuleRecordModel.getId());
        }
        return ResultUtils.build(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }

    /**
     * @Description: 删除规则
     * @Param: @ApiParam(value = "模板规则")
     @ApiParam(value = "模板规则")
      * @Return: ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:29
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @ApiOperation(value = "删除规则")
    @PostMapping(value = "/deleteTemplateRuleRecord/{id}")
    public ResultUtils deleteTemplateRuleRecord(@ApiParam(value = "id",required = true)@PathVariable String id)
    {
        boolean flag = templateRuleRecordService.deleteTemplateRuleRecord(id);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.DELETE_SUCCESS.getCode(),CodeEnumUtils.DELETE_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.DELETE_FALL.getCode(),CodeEnumUtils.DELETE_FALL.getMessage());
    }

    /**
     * @Description:  根据id查一条规则的具体内容
     * @Return: com.tfjybj.ftdp.utils.ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:23
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
//    @ApiOperation(value = "根据id查一条规则的具体内容")
//    @GetMapping(value = "/queryTemplateRuleRecordId/{Id}")
//    public ResultUtils queryTemplateRuleRecordId(@ApiParam(value = "规则id",required=true)@RequestParam  String   Id){
//        List<TemplateRuleRecordIdModel> TemplateRuleRecordIdModels = templateRuleRecordService.queryTemplateRuleRecordId( Id);
//        if (TemplateRuleRecordIdModels .size() == 0 ){
//            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
//        }
//        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),TemplateRuleRecordIdModels );
//    }


    /**
     * @Description:  根据templateId查规则页面的组件名称
     * @Return: com.tfjybj.ftdp.utils.ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:23
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
//    @ApiOperation(value = "根据templateId查规则页面的组件名称")
//    @GetMapping(value = "/queryTemplateComponentNameRuleRecord/{templateId}")
//    public ResultUtils queryTemplateComponentNameRuleRecord(@ApiParam(value = "模板id",required=true)@RequestParam  String  templateId){
//        List<TemplateRuleAndConponentNameModel> TemplateRuleAndConponentNameModels = templateRuleRecordService.queryTemplateComponentNameRuleRecord(templateId);
//        if (TemplateRuleAndConponentNameModels .size() == 0 ){
//            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
//        }
//        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),TemplateRuleAndConponentNameModels );
//    }



}
