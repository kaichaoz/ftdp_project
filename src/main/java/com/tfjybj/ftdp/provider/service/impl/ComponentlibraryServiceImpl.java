package com.tfjybj.ftdp.provider.service.impl;


import com.tfjybj.ftdp.entity.ComponentlibraryEntity;
import com.tfjybj.ftdp.model.ComponentModel;
import com.tfjybj.ftdp.provider.dao.ComponentlibraryDao;
import com.tfjybj.ftdp.provider.service.ComponentlibraryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        //接收初始化返回的值
        List<ComponentModel>componentModels= componentlibraryDao.queryComponent();
        return componentModels;
    }

    @Override
    public int updateComponentGroupPlace(ComponentModel componentModels) {
        try {
            //如果接收到的IsUsable是0
            if (componentModels.getIsUsable().equals("1")) {
                //将启用变成停用
                componentlibraryDao.updateComponentIsUsableOpen(componentModels.getComponentId());
                //如果IsUsable是1
            } else if (componentModels.getIsUsable().equals("0")) {
                //将停用变成启用
                componentlibraryDao.updateComponentIsUsableOff(componentModels.getComponentId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //更新分组位置
            return componentlibraryDao.updateComponentGroupPlace(componentModels);
        }

    }



//    @Override
//    public List<ComponentModel> updateComponentGroupPlace(String groupId,String groupSequence){
//
//        //更新分组位置
//        List<ComponentModel> componentModels1= componentlibraryDao.updateComponentGroupPlace(groupId,groupSequence);
//        return componentModels1;
//
////        if(componentModels.getComponentId()==0){
////
////        }
//    }

//    @Override
//    //重写启用按钮方法
//    public void updateComponentIsUsableOpen(String id){
//            componentlibraryDao.updateComponentIsUsableOpen(id);
//    }
//
//    @Override
//    //重写停用按钮方法
//    public void updateComponentIsUsableOff(String id){
//        componentlibraryDao.updateComponentIsUsableOff(id);
//    }
}
