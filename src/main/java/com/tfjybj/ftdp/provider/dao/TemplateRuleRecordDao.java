package com.tfjybj.ftdp.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleAndConponentNameModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordDeleteModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordIdModel;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("templateRuleRecordDao")
public interface TemplateRuleRecordDao extends BaseMapper<TemplaterulerecordEntity> {
    /**
     * @Description:  根据templateId查模板规则页面的规则
     * @Return:  List<TemplaterulerecordEntity>
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:37
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplaterulerecordEntity> queryTemplateRuleRecord(String templateId);

    /**
     * @Description:  根据id查一条规则的具体内容
     * @Return:  List
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:37
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleRecordIdModel> queryTemplateRuleRecordId(String Id);

    /**
     * @Description:  根据templateId查规则页面的组件名称
     * @Return:  List
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:37
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    List<TemplateRuleAndConponentNameModel> queryTemplateComponentNameRuleRecord(String templateId);

    /**
     * @Description:  添加模板规则设置
     * @Param:  templateRuleRecordModel, id
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    Boolean addTemplateRuleRecord(@Param("templateRuleRecordModel") TemplateRuleRecordModel templateRuleRecordModel) ;

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
    Boolean  deleteTemplateRuleRecord (String id);


}
