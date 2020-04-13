package com.tfjybj.ftdp.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.entity.ComponentlibraryEntity;
import com.tfjybj.ftdp.model.ComponentModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname ComponentlibraryDao
 * @Description TODO
 * @Date 2020年4月2日 09点52分
 * @Author by 曹轩
 * @Version 1.0
 */

@Repository("ComponentDao")
public interface ComponentlibraryDao extends BaseMapper<ComponentModel>{
    //初始化组件库
    List<ComponentModel> queryComponent ();

    //更新组件
    void updateComponentGroupPlace(String groupId,String groupSequence);

    //启用组件
    void updateComponentIsUsableOpen(String id);

    //停用组件
    void updateComponentIsUsableOff(String id);
}
