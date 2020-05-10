package com.tfjybj.ftdp.provider.service.impl;


import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.*;
import com.tfjybj.ftdp.provider.dao.TemplateRuleRecordDao;
import com.tfjybj.ftdp.provider.service.TemplateRuleRecordService;
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
     * @Description: 根据templateId查模板规则页面的规则
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

    public List<TemplateRuleRecordNameModel> queryTemplateRuleRecord1(String templateId) {
        List<TemplateRuleRecordNameModel> templaterulerecordEntityList=templaterulerecordDao.queryTemplateRuleRecord1(templateId);
        return  templaterulerecordEntityList;
    }


    /**
     * @Description:  添加模板规则设置
     * @Param:
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @Override
    public String addTemplateRuleRecord(TemplateRuleRecordModel templateRuleRecordModel) {
       templaterulerecordDao.addTemplateRuleRecord(templateRuleRecordModel);
        return templateRuleRecordModel.getId();
    }



    /**
     * @Description:  根据id删除一条规则
     * @Param:  templateRuleRecordDeleteModel
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @Override
    public  Boolean  deleteTemplateRuleRecord(String  id) {
        return templaterulerecordDao.deleteTemplateRuleRecord(id);
    }

    /**
     * @Author: 商俊帅
     * @Date : 2020/5/9 16:59
     * @Param templaterulerecordId，templateId
     * @Return : TemplateRuleRecordContentModel
     **/
    @Override
    public TemplateRuleRecordContentModel queryTemplateRecordContent(String templaterulerecordId,String templateId){

        //查询所有的titles
        List<TemplateTitlesModel> templateTitlesModelList = templaterulerecordDao.queryTemplateTitles(templateId);
        //查询当前页面内容
        List<TemplateRuleRecordUnderContentModel> templateRuleRecordContentModelList = templaterulerecordDao.queryTemplateRecordUnder(templaterulerecordId);

        //用set形式将上述两者赋值到model中
        TemplateRuleRecordContentModel trrcm = new TemplateRuleRecordContentModel();
        trrcm.setTitlesModelList(templateTitlesModelList);

        trrcm.setTrrucm(templateRuleRecordContentModelList);

        return trrcm;
    }



    /**
     * @Description: 根据templateId查规则页面的组件名称
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
//    public List<TemplateRuleAndConponentNameModel> queryTemplateComponentNameRuleRecord(String templateId) {
//        List<TemplateRuleAndConponentNameModel> TemplateRuleAndConponentNameModelList=templaterulerecordDao.queryTemplateComponentNameRuleRecord(templateId);
//        return  TemplateRuleAndConponentNameModelList;
//    }

    /**
     * @Description: 根据id查一条规则的具体内容
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:35
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    //@Override
//    public List<TemplateRuleRecordIdModel> queryTemplateRuleRecordId(String Id) {
//        List<TemplateRuleRecordIdModel> TemplateRuleRecordIdModelList=templaterulerecordDao.queryTemplateRuleRecordId(Id);
//        return  TemplateRuleRecordIdModelList;
//    }

}
