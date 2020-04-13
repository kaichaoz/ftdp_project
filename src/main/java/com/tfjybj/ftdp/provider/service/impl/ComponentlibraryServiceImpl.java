package com.tfjybj.ftdp.provider.service.impl;


import com.tfjybj.ftdp.entity.ComponentlibraryEntity;
import com.tfjybj.ftdp.model.ComponentModel;
import com.tfjybj.ftdp.provider.dao.ComponentlibraryDao;
import com.tfjybj.ftdp.provider.service.ComponentlibraryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname ComponentlibraryServiceImpl
 * @Description TODO
 * @Date 2020年4月2日 09点02分
 * @Author by 曹轩
 * @Version 1.0
 */

@Service("ComponentlibraryService")
public class ComponentlibraryServiceImpl implements ComponentlibraryService {

    @Resource
    private ComponentlibraryDao componentlibraryDao;

    @Override
    public List<ComponentModel> queryComponent(){
        List<ComponentModel>componentModels= componentlibraryDao.queryComponent();
        return componentModels;
    }

    @Override
    public void updateComponentGroupPlace(String groupId,String groupSequence){
        componentlibraryDao.updateComponentGroupPlace(groupId,groupSequence);
    }

    @Override
    //重写启用按钮方法
    public void updateComponentIsUsableOpen(String id){
            componentlibraryDao.updateComponentIsUsableOpen(id);
    }

    @Override
    //重写停用按钮方法
    public void updateComponentIsUsableOff(String id){
        componentlibraryDao.updateComponentIsUsableOff(id);
    }
}
