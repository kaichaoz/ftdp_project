package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordIdModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordUpdateModel;
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
     * @Description: 初始化模板规则页面
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplaterulerecordEntity> queryTemplateRuleRecord(String  templateId);

    /**
     * @Description: 初始化模板页面一条规则
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleRecordIdModel> queryTemplateRuleRecordId(String Id);

    /**
     * @Description: 添加模板规则
     * @Param 模板id: templateId, 组件id: componentId,年级：grade,性别：sex,开始范围： startRange,结束范围：endRange,原始得分：originalScore,权重： weight,评级：level,创建者： creater
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/

   // boolean addTemplateRuleRecord(String  templateId, String  componentId, String grade, int sex, String startRange, String endRange, String originalScore, String weight, String level, String creater);
    boolean addTemplateRuleRecord(TemplateRuleRecordModel templateRuleRecordModel ,String Id);

    /**
     * @Description: 更新模板规则
     * @Param 模板id: templateId, 组件id: componentId,年级：grade,性别：sex,开始范围： startRange,结束范围：endRange,原始得分：originalScore,权重： weight,评级：level,创建者： creater
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    boolean updateTemplateRuleRecord(TemplateRuleRecordUpdateModel templateRuleRecordUpdateModel );
    /**
     * @Description:  添加组件规则
     * @Param:  模板id: templateId, 组件id: componentId,年级：grade,性别：sex,开始范围： startRange,结束范围：endRange,原始得分：originalScore,权重： weight,评级：level,创建者： creater
     * @Return:  true  false
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 10:02
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    boolean addComponentIdRuleRecord(TemplateRuleRecordModel templateRuleRecordModel ,String Id);

//    boolean addComponentIdRuleRecord(String  templateId, String  componentId, String grade, int sex, String startRange, String endRange, String originalScore, String weight, String level, String creater,String Id);

    /**
     * @Description: 初始化模板规则的组件名称页面
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:34
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleAndConponentNameModel> queryTemplateComponentNameRuleRecord(String  templateId);

}
