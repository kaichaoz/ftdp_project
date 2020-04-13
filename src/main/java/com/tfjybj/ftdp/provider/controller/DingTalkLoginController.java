package com.tfjybj.ftdp.provider.controller;

import com.alibaba.fastjson.JSON;
import com.tfjybj.ftdp.model.AccessTokenModel;
import com.tfjybj.ftdp.model.UserDingModel;
import com.tfjybj.ftdp.model.UserModel;
import com.tfjybj.ftdp.provider.service.UserService;
import com.tfjybj.ftdp.utils.DingTalkEnumUtils;
import com.tfjybj.ftdp.utils.HTTPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.util.parsing.combinator.testing.Str;

import javax.annotation.Resource;


/**
 * @author 张凯超
 */
@Api(tags = {"钉钉免登录接口"})
@RequestMapping(value = "/dingTalkLoginController")
@RestController
public class DingTalkLoginController {
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
    private UserService userService ;

    /**
     * 钉钉免密登录
     * @param code 钉钉临时授权码
     * @return access_token 钉钉Token
     */
    @ApiOperation("获取钉钉token")
    @GetMapping(value = "/loginByCode/{code}")
    public UserModel getDingToken(@ApiParam(value = "免密登录临时授权码", required = true) @PathVariable String code) {
        // 由AppKey与AppSceret组合临时请求参数
        String param = "corpid=" + corpid + "&corpsecret=" + corpsecret;
        // 请求获取AccessToken,将返回数据实体接收
        AccessTokenModel accessTokenModel = JSON.parseObject(HTTPUtils.sendGetHttp(DingTalkEnumUtils.DING_TALK_ENUM_UNTIL_GETTOKEN.getMessage(), param), AccessTokenModel.class);
        // 拼接 获取DingId的参数
        String UserInfo = "access_token=" + accessTokenModel.getAccess_token() + "&code=" + code;
        // 请求获取 钉钉用户数据，实体接收。
        UserDingModel userDingModel = JSON.parseObject(HTTPUtils.sendGetHttp(DingTalkEnumUtils.DING_TALK_ENUM_UNTIL_GETUSERID.getMessage(), UserInfo), UserDingModel.class);
        //
        UserModel userModel = userService.login(userDingModel.getUserid());
        if (userModel == null){
            return null;
        }
        return userModel;
    }
}
