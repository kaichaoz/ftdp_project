package com.tfjybj.ftdp.provider.controller;

import com.tfjybj.ftdp.entity.ComponentlibraryEntity;
import com.tfjybj.ftdp.model.ComponentModel;
import com.tfjybj.ftdp.provider.service.ComponentlibraryService;
import com.tfjybj.ftdp.utils.CodeEnumUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Classname ComponentlibraryController
 * @Description TODO
 * @Date 2020年4月2日 08点52分
 * @Author by 曹轩
 * @Version 1.0
 */
@Api(tags="组件接口")
@RequestMapping(value ="Componentlibrary")
@RestController
public class ComponentlibraryController {

    @Resource
    private ComponentlibraryService componentlibraryService;

    @ApiOperation(value="初始化组件库页面")
    @GetMapping(value = "queryComponent")
    public ResultUtils queryComponent(){
        List<ComponentModel>componentModels= componentlibraryService.queryComponent();
        return ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),componentModels);
    }


    @ApiOperation(value="更新组件可分组移动位置")
    @PostMapping(value = "updateComponentGroupPlace")
    public ResultUtils updateComponentGroupPlace(@ApiParam(value = "分组id",required = true)@RequestParam String groupId,
                                                 @ApiParam(value = "分组位置",required = true)@RequestParam String groupSequence){
        componentlibraryService.updateComponentGroupPlace(groupId,groupSequence);
        return ResultUtils.build(CodeEnumUtils.MODIFY_FINISH.getCode(),CodeEnumUtils.MODIFY_FINISH.getMessage());
    }

    @ApiOperation(value = "启用组件")
    @PostMapping(value = "updateComponentIsUsable")
    public ResultUtils updateComponentIsUsableOpen(@ApiParam(value = "组件id",required=true)@RequestParam String id){
        componentlibraryService.updateComponentIsUsableOpen(id);
        return ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage());
    }

    @ApiOperation(value="停用组件")
    @PostMapping(value = "updateComponentIsUsableOff")
    public ResultUtils updateComponentIsUsableOff(@ApiParam(value = "组件id",required=true)@RequestParam String id){
        componentlibraryService.updateComponentIsUsableOff(id);
        return ResultUtils.build(CodeEnumUtils.MODIFY_SUCCESS.getCode(),CodeEnumUtils.MODIFY_SUCCESS.getMessage());
    }
}


