package com.tfjybj.ftdp.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.tfjybj.ftdp.model.AccessTokenModel;
import com.tfjybj.ftdp.model.UserDingModel;
import com.tfjybj.ftdp.model.UserModel;
import com.tfjybj.ftdp.provider.service.UserService;
import com.tfjybj.ftdp.utils.CodeEnumUtils;
import com.tfjybj.ftdp.utils.DingTalkEnumUtils;
import com.tfjybj.ftdp.utils.HTTPUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import scala.util.parsing.combinator.testing.Str;

import javax.annotation.Resource;

/**
 * @author 张凯超
 * @Classname UserController
 * @Date 2020/1/18 16:25
 * @Created by 张凯超
 */
@Api(tags = {"用户接口"})
@RequestMapping(value = "/userPage")
@RestController
public class UserController {

    /**
     * moren H5微应用 AppKey
     */
    @Value("${ding_corpid}")
    private String corpid;

    /**
     * 默认 H5 微应用 AppCcorpsecret
     */
    @Value("${ding_corpsecret}")
    private String corpsecret;

    @Resource
    private UserService userService;


    @ApiOperation("根据用户Id查用户信息")
    @GetMapping(value = "/queryUserById")
    public ResultUtils queryUserById(Integer Id) {
        UserModel userModel = userService.queryUserById(Id);
        if (userModel == null ){
            return  ResultUtils.build(CodeEnumUtils.SELECT_FINISH.getCode(),CodeEnumUtils.SELECT_FINISH.getMessage(), (Object) null);
        }
        return  ResultUtils.build(CodeEnumUtils.SELECT_SUCCESS.getCode(),CodeEnumUtils.SELECT_SUCCESS.getMessage(),userModel);
    }

    /**
    * @Description:
    * @Param:
    * @Return:
    * @Author: 张凯超
    * @Data: 2020/4/8
    * @Time: 11:52
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @ApiOperation("插入用户")
    @PostMapping("/insertUser/{name}")
    public ResultUtils insertUser( @PathVariable String name){
        UserModel userModel = new UserModel();
        // 由AppKey与AppSceret组合临时请求参数
        String param = "corpid=" + corpid + "&corpsecret=" + corpsecret;
        // 请求获取AccessToken,将返回数据实体接收
       AccessTokenModel  accessTokenModel = JSON.parseObject(HTTPUtils.sendGetHttp(DingTalkEnumUtils.DING_TALK_ENUM_UNTIL_GETTOKEN.getMessage(), param),AccessTokenModel.class);
        userModel.setUserId(accessTokenModel.getId());
        userModel.setPassWord(accessTokenModel.getId());
        userModel.setName(name);
        boolean flag =  userService.insertUser(userModel,name);
       return ResultUtils.build("","",flag);
    }
}
