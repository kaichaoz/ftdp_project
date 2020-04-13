package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.entity.ComponentlibraryEntity;
import com.tfjybj.ftdp.model.ComponentModel;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ComponentlibraryService
 * @Description TODO
 * @Date 2020年4月2日 08点59分
 * @Author by 曹轩
 * @Version 1.0
 */
@Service
public interface ComponentlibraryService {

    //传参
    List<ComponentModel> queryComponent();

    //传参，无返回值
    void updateComponentGroupPlace(String groupId,String groupSequence);

    //传参
    void updateComponentIsUsableOpen(String id);

    void updateComponentIsUsableOff(String id);
}

