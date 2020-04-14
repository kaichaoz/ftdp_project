package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.model.TemplateGroupModel;
import com.tfjybj.ftdp.provider.service.TemplateGroupService;
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
 * @Classname TemplateGroupController
 * @Description TODO
 * @Date 2020/4/1 15:58
 * @Author by 张凯超
 * @Version 1.0
 */
@Api(tags = {"分组页面"})
@RequestMapping(value = "/TemplateGroup")
@RestController
public class TemplateGroupController {


    @Resource
    private TemplateGroupService templateGroupService;

    /**
    * @Description:  初始化模板分组页面
    * @Return: com.tfjybj.ftdp.utils.ResultUtils
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:23
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @ApiOperation(value = "初始化模板分组页面")
    @GetMapping(value = "/queryTemplateGroup")
    public ResultUtils queryTemplateGroup(){
        List<TemplateGroupModel> templateGroupModels = templateGroupService.queryTemplateGroup();
        if (templateGroupModels.size() == 0 ){
            return ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),templateGroupModels);
    }

    /**
    * @Description: 添加模板分组
    * @Param: @ApiParam(value = "模板分组名称") @PathVariable String groupName
              @ApiParam(value = "模板分组顺序") @PathVariable String groupSequence
    * @Return: ResultUtils
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:29
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @ApiOperation(value = "添加模板分组")
    @PostMapping(value = "/addTemplateGroup/{groupName}/{groupSequence}")
    public ResultUtils addTemplateGroup(@ApiParam(value = "模板分组名称") @PathVariable String groupName ,
                                        @ApiParam(value = "模板分组顺序") @PathVariable String groupSequence){
        boolean flag = templateGroupService.addTemplateGroup(PatterUtils.getNumberPattern(),groupName,groupSequence);
        if (flag){
            return  ResultUtils.build(CodeEnumUtils.INSERT_SUCCESS.getCode(),CodeEnumUtils.INSERT_SUCCESS.getMessage(), flag);
        }
        return ResultUtils.build(CodeEnumUtils.INSERT_FALL.getCode(),CodeEnumUtils.INSERT_FALL.getMessage());
    }

    /**
    * @Description: 修改isUsable状态做到删除模板分组
    * @Param:  
    * @Return:  
    * @Author: 张凯超
    * @Data: 2020/4/2 
    * @Time: 10:12
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/

    @ApiOperation(value = "修改isUsable状态做到删除模板分组")
    @PostMapping(value = "/updateTemplateGroup/{id}")
    public ResultUtils updateTemplateGroup(@ApiParam(value = "id") @PathVariable String id ){
        boolean flag= templateGroupService.updateTemplateGroup(id);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.DELETE_SUCCESS.getCode(),CodeEnumUtils.DELETE_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.DELETE_FALL.getCode(),CodeEnumUtils.DELETE_FALL.getMessage());

    }
    /**
    * @Description:  更新模板分组位置
    * @Param:  @ApiParam(value = "id") @PathVariable String id ,
     *         @ApiParam(value = "模板分组顺序") @PathVariable String groupSequence
    * @Return:  flag true:成功 false:失败
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 10:01
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @ApiOperation(value = "更新模板分组位置")
    @PostMapping(value = "/updateTemplateGroupPlace/{id}/{groupSequence}")
    public ResultUtils updateTemplateGroupPlace(@ApiParam(value = "id") @PathVariable String id ,
                                                @ApiParam(value = "模板分组顺序") @PathVariable String groupSequence){
        boolean flag = templateGroupService.updateTemplateGroupPlace(id,groupSequence);
        if (flag){
            return ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage());
        }
        return ResultUtils.build(CodeEnumUtils.MODIFY_FALL.getCode(),CodeEnumUtils.MODIFY_FALL.getMessage());
    }



    /**
    * @Description: 修改模板分组 无则插入  有则修改
    * @Param: templateGroupModelList  模板数据集合
    * @Return:
    * @Author: 张凯超
    * @Data: 2020/4/13
    * @Time: 10:25
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @ApiOperation(value = "修改模板分组")
    @PostMapping(value = "/modifyTemplateGroup")
    public ResultUtils modifyTemplateGroup(@RequestBody List<TemplateGroupModel> templateGroupModelList) throws Exception {
        boolean flag = templateGroupService.modifyTemplateGroup(templateGroupModelList);
        return ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage(),flag);
    }
}
