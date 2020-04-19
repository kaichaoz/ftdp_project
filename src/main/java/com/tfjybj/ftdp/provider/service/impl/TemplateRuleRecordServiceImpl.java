package com.tfjybj.ftdp.provider.service.impl;


import com.tfjybj.ftdp.entity.TemplateEntity;
import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import com.tfjybj.ftdp.provider.dao.TemplateRuleRecordDao;
import com.tfjybj.ftdp.provider.service.TemplateRuleRecordService;
import com.tfjybj.ftdp.utils.PatterUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname TemlateRuleRecordServiceImpl
 * @Description TODO
 * @Date 2020/4/1 19:02
 * @Author by 陈海明
 * @Version 1.0
 */
@Service("temlateRuleRecordService")
public  class TemplateRuleRecordServiceImpl implements TemplateRuleRecordService{

    @Resource
    private TemplateRuleRecordDao templaterulerecordDao;

    /**
     * @Description: 初始化模板规则页面
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:35
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/

    @Override
    public List<TemplaterulerecordEntity> queryTemplateRuleRecord(String templateId) {
        List<TemplaterulerecordEntity> templaterulerecordEntityList=templaterulerecordDao.queryTemplateRuleRecord(templateId);
        return  templaterulerecordEntityList;
    }


    /**
     * @Description:  v添加模板规则
     * @Param:  groupName:模板分组名称   groupSequence:模板分组顺序
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
  //  @Override
 //   public boolean addTemplateRuleRecord(String templateId, String componentId, String grade, int sex, String startRange, String endRange, String originalScore, String weight, String level, String creater) {
  //      Boolean flag= templaterulerecordDao.addTemplateRuleRecord(templateId,componentId,grade,sex,startRange,endRange,originalScore,weight,level,creater);
  //      return flag;
  //  }
    public boolean addTemplateRuleRecord(TemplateRuleRecordModel templateRuleRecordModel, String Id) {
        boolean flag = templaterulerecordDao.addComponentIdRuleRecord(templateRuleRecordModel,Id);
        return flag;
    }


    /**
     * @Description: 添加组件规则
     * @Param:
     * @Return:
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 10:03
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @Override
    public boolean addComponentIdRuleRecord(TemplateRuleRecordModel templateRuleRecordModel, String Id) {
        boolean flag = templaterulerecordDao.addComponentIdRuleRecord(templateRuleRecordModel,Id);
        return flag;
    }

    /**
     * @Description: 初始化规则页面的组件名称
     * @Param:
     * @Return:
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 10:03
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/

    @Override
    public List<TemplateRuleAndConponentNameModel> queryTemplateComponentNameRuleRecord(String templateId) {
        List<TemplateRuleAndConponentNameModel> TemplateRuleAndConponentNameModelList=templaterulerecordDao.queryTemplateComponentNameRuleRecord(templateId);
        return  TemplateRuleAndConponentNameModelList;
    }

    /**
     * @Description: 添加组件规则
     * @Param:
     * @Return:
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 10:03
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
//    @Override
//    public boolean addComponentIdRuleRecord(String templateId, String componentId, String grade, int sex, String startRange, String endRange, String originalScore, String weight, String level, String creater,String Id) {
//        String str = PatterUtils.getNumberPattern(Id);
//        Boolean flag= templaterulerecordDao.addComponentIdRuleRecord(templateId,componentId,grade,sex,startRange,endRange,originalScore,weight,level,creater,str);
//        return flag;
//    }
}
