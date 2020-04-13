package com.tfjybj.ftdp.provider.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 张凯超
 * @Classname UserDao
 * @Date 2020/1/19 10:12
 */
@Repository("userDao")
public interface UserDao extends BaseMapper<UserModel> {

    UserModel selectById(Integer id);

    UserModel login(String userid);
    boolean insertUser(UserModel userModel, String name);
}