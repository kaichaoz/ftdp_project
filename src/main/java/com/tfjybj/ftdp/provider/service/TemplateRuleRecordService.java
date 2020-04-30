package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordIdModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TemplateGroupService
 * @Description TODO
 * @Date 2020/4/1 18:50
 * @Author by 陈海明
 * @Version 1.0
 */
@Service
public interface TemplateRuleRecordService {

    /**
     * @Description: 根据templateId查模板规则页面的规则
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplaterulerecordEntity> queryTemplateRuleRecord(String  templateId);

    /**
     * @Description: 根据id查一条规则的具体内容
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleRecordIdModel> queryTemplateRuleRecordId(String Id);

    /**
     * @Description: 添加模板规则设置
     * @Param id
     * * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    String addTemplateRuleRecord(TemplateRuleRecordModel templateRuleRecordModel);


    /**
     * @Description: 根据templateId查规则页面的组件名称
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleAndConponentNameModel> queryTemplateComponentNameRuleRecord(String  templateId);

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
    Boolean deleteTemplateRuleRecord(String id);

}
