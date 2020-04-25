package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.entity.TemplateEntity;
import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
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
import java.util.UUID;

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
    @ApiOperation(value = "初始化模板规则页面")
    @GetMapping(value = "/queryTemplateRuleRecord/{templateId}")
    public ResultUtils queryTemplateRuleRecord(@ApiParam(value = "模板id",required=true)@RequestParam  String  templateId){
        List<TemplaterulerecordEntity> TemplateRuleRecordModels = templateRuleRecordService.queryTemplateRuleRecord(templateId);
        if (TemplateRuleRecordModels .size() == 0 ){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),TemplateRuleRecordModels );
    }



    @ApiOperation(value = "初始化规则页面的组件名称")
    @GetMapping(value = "/queryTemplateComponentNameRuleRecord/{templateId}")
    public ResultUtils queryTemplateComponentNameRuleRecord(@ApiParam(value = "模板id",required=true)@RequestParam  String  templateId){
        List<TemplateRuleAndConponentNameModel> TemplateRuleAndConponentNameModels = templateRuleRecordService.queryTemplateComponentNameRuleRecord(templateId);
        if (TemplateRuleAndConponentNameModels .size() == 0 ){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),TemplateRuleAndConponentNameModels );
    }



    /**
     * @Description: 添加组件规则
     * @Param: @ApiParam(value = "组件规则") @PathVariable String templateId
     @ApiParam(value = "组件规则") @PathVariable String groupSequence
      * @Return: ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:29
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
//    @ApiOperation(value = "添加组件规则")
////    @PostMapping(value = "/addComponentIdRuleRecord/{templateId}/{componentId}/{grade}/{sex}")
//    @PostMapping(value = "/addComponentIdRuleRecord/{templateRuleRecordModel}")
/*    public ResultUtils addComponentIdRuleRecord(@ApiParam(value = "模板id",required=true) @PathVariable   String  templateId ,
                                          @ApiParam(value = "组件id",required=true) @PathVariable String  componentId,
                                          @ApiParam(value = "年级",required=true) @PathVariable String grade,
                                          @ApiParam(value = "性别",required=true) @PathVariable int sex ,
                                          @ApiParam(value = "开始范围",required=true) @PathVariable String startRange ,
                                          @ApiParam(value = "结束范围",required=true) @PathVariable String endRange ,
                                          @ApiParam(value = "原始得分",required=true) @PathVariable String originalScore,
                                          @ApiParam(value = "权重",required=true) @PathVariable String weight,
                                          @ApiParam(value = "评级",required=true) @PathVariable String level,
                                          @ApiParam(value = "创建者",required=true) @PathVariable String creater){*/
//public ResultUtils addComponentIdRuleRecord(@RequestBody TemplateRuleRecordModel templateRuleRecordModel){
//        boolean flag = templateRuleRecordService.addComponentIdRuleRecord(templateRuleRecordModel,PatterUtils.getNumberPattern());
//        if (flag){
//            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
//        }
//        return ResultUtils.build(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
//    }

    /**
     * @Description: 添加模板规则
     * @Param: @ApiParam(value = "模板规则") @PathVariable String templateId
     @ApiParam(value = "模板规则") @PathVariable String groupSequence
      * @Return: ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:29
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @ApiOperation(value = "添加模板规则")
    @PostMapping(value = "/addTemplateRuleRecord/{templateRuleRecordModel}")
        public ResultUtils addTemplateRuleRecord(@RequestBody TemplateRuleRecordModel templateRuleRecordModel){
        boolean flag = templateRuleRecordService.addTemplateRuleRecord(templateRuleRecordModel, PatterUtils.getNumberPattern());
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
        }
        return ResultUtils.build(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }



}
