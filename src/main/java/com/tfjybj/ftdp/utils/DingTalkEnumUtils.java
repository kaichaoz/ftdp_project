package com.tfjybj.ftdp.utils;

import lombok.Getter;

/**
 * @Classname DingTalkUtils
 * @Description TODO
 * @Date 2020/4/8 9:13
 * @Author by 张凯超
 * @Version 1.0
 */
@Getter
public enum DingTalkEnumUtils {
    DING_TALK_ENUM_UNTIL_GETUSERID("DingUserID","https://oapi.dingtalk.com/user/getuserinfo"),
    DING_TALK_ENUM_UNTIL_GETTOKEN("DingGetToken","https://oapi.dingtalk.com/gettoken")
    ;
    private  String DingName;
    private  String message;

    DingTalkEnumUtils(String DingName , String message){
        this.DingName = DingName ;
        this.message = message;
    }
}
