package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.entity.TemplateEntity;
import com.tfjybj.ftdp.model.TemplateGroupModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TemplateGroupService
 * @Description TODO
 * @Date 2020/4/1 18:50
 * @Author by 张凯超
 * @Version 1.0
 */
@Service
public interface TemplateGroupService {

    /**
    * @Description: 初始化模板分组页面
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:34
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    List<TemplateGroupModel> queryTemplateGroup();

    /**
    * @Description: 添加模板分组
    * @Param groupName:模板分组名称   groupSequence:模板分组顺序
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:34
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    boolean addTemplateGroup(String Id ,String groupName, String groupSequence);


    /**
    * @Description:  更新模板分组位置
    * @Param:  id groupSequence
    * @Return:  true  false
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 10:02
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    boolean updateTemplateGroupPlace(String id, String groupSequence);

    /**
    * @Description: 修改isUsable状态做到删除模板分组
    * @Param:  
    * @Return:  
    * @Author: 张凯超
    * @Data: 2020/4/2 
    * @Time: 10:12
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    boolean updateTemplateGroup(String id);
}
