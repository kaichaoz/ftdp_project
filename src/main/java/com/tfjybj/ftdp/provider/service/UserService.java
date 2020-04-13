package com.tfjybj.ftdp.provider.service;


import com.tfjybj.ftdp.model.UserDingModel;
import com.tfjybj.ftdp.model.UserModel;
import org.springframework.stereotype.Service;
import scala.util.parsing.combinator.testing.Str;

/**
 * @Classname UserService
 * @Date 2020/1/19 10:10
 * @Created by 张凯超
 */
@Service
public interface UserService {
    UserModel queryUserById(Integer id);

    UserModel login(String userid);

    boolean insertUser(UserModel userModel, String name);
}
