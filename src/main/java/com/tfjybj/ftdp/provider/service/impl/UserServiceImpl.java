package com.tfjybj.ftdp.provider.service.impl;


import com.tfjybj.ftdp.model.TemplateContentModel;
import com.tfjybj.ftdp.model.TemplateModel;
import com.tfjybj.ftdp.model.UserDingModel;
import com.tfjybj.ftdp.model.UserModel;
import com.tfjybj.ftdp.provider.dao.UserDao;
import com.tfjybj.ftdp.provider.service.UserService;
import org.springframework.stereotype.Service;
import scala.util.parsing.combinator.testing.Str;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Date 2020/1/19 10:11
 * @Created by 张凯超
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public UserModel queryUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public UserModel login(String userid) {
        if (userid.isEmpty()){
            return null;
        }
        UserModel userModel = userDao.login(userid);
        return userModel ;
    }

    @Override
    public boolean insertUser(UserModel userModel ,String name) {
       boolean flag =  userDao.insertUser(userModel,name);
        return flag;
    }


}
