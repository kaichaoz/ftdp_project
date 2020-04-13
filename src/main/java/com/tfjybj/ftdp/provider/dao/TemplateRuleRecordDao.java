package com.tfjybj.ftdp.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.entity.TemplaterulerecordEntity;
import com.tfjybj.ftdp.model.TemplateRuleRecordModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("templateRuleRecordDao")
public interface TemplateRuleRecordDao extends BaseMapper<TemplaterulerecordEntity> {
    /**
     * @Description:  初始化模板页面
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
     * @Description:  添加组件规则
     * @Param:  groupName:模板分组名称   groupSequence:模板分组顺序
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    Boolean addComponentIdRuleRecord(@Param("templateRuleRecordModel") TemplateRuleRecordModel templateRuleRecordModel, @Param("Id") String Id) ;

    /**
     * @Description:  添加模板规则
     * @Param:  groupName:模板分组名称   groupSequence:模板分组顺序
     * @Return:  ResultUtils
     * @Author: 陈海明
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    Boolean addTemplateRuleRecord(@Param("templateRuleRecordModel") TemplateRuleRecordModel templateRuleRecordModel, @Param("Id") String Id) ;
    //Boolean addTemplateRuleRecord(String templateId, String componentId,String grade,int sex,String startRange,String endRange,String originalScore,String weight,String level,String creater ) ;


}
