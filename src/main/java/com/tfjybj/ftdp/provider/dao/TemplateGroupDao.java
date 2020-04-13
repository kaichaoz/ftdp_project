package com.tfjybj.ftdp.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.entity.TemplateEntity;
import com.tfjybj.ftdp.model.TemplateGroupModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname TemplateGroupDao
 * @Description TODO
 * @Date 2020/4/1 19:04
 * @Author by 张凯超
 * @Version 1.0
 */
@Repository("templateGroupDao")
public interface TemplateGroupDao extends BaseMapper<TemplateEntity> {

    /**
    * @Description:  初始化模板页面
    * @Return:  List<TemplateEntity>
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:37
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    List<TemplateGroupModel> queryTemplateGroup();

    /**
    * @Description:  添加模板分组
    * @Param:  groupName:模板分组名称   groupSequence:模板分组顺序
    * @Return:  ResultUtils
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:36
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    Boolean addTemplateGroup (@Param("Id") String Id , @Param("groupName") String groupName,@Param("groupSequence") String groupSequence);

    /**
    * @Description: 更新模板分组位置
    * @Param:  
    * @Return:  
    * @Author: 张凯超
    * @Data: 2020/4/2 
    * @Time: 10:04
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    boolean updateTemplateGroupPlace(@Param("id") String id,@Param("groupSequence") String groupSequence);

    /**
    * @Description: 删除模板分组
    * @Param:
    * @Return:
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 10:13
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    boolean updateTemplateGroup(@Param("id") String id);
}
