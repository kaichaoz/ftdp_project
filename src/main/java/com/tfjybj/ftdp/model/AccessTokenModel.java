package com.tfjybj.ftdp.model;

import lombok.Data;

@Data
public class AccessTokenModel {

    private String expires_in;
    private String errmsg;
    private String access_token;
    private String errcode;
    private String  id;
    private String  userCode;
    private String  email;
    private String  userName;
    private String  companyId;
    private String  schoolNo;
    private String  token;
    private String  roleId;
    private String  qqOpenId;
    private String  weChatOpenId;
    private String  wxPlantForm;

}