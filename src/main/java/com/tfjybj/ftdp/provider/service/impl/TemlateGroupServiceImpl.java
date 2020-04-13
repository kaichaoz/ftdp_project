package com.tfjybj.ftdp.provider.service.impl;

import com.tfjybj.ftdp.entity.TemplateEntity;
import com.tfjybj.ftdp.model.TemplateGroupModel;
import com.tfjybj.ftdp.provider.dao.TemplateGroupDao;
import com.tfjybj.ftdp.provider.service.TemplateGroupService;
import com.tfjybj.ftdp.utils.PatterUtils;
import com.tfjybj.ftdp.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.PatternUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Classname TemlateGroupServiceImpl
 * @Description TODO
 * @Date 2020/4/1 19:02
 * @Author by 张凯超
 * @Version 1.0
 */
@Service("temlateGroupService")
public class TemlateGroupServiceImpl implements TemplateGroupService {

    @Resource
    private TemplateGroupDao templateGroupDao;

    /**
    * @Description: 初始化模板分组页面
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:35
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @Override
    public List<TemplateGroupModel> queryTemplateGroup() {
        List<TemplateGroupModel> templateEntityList = templateGroupDao.queryTemplateGroup();
        return templateEntityList;
    }

    /**
    * @Description:  v添加模板分组
    * @Param:  groupName:模板分组名称   groupSequence:模板分组顺序
    * @Return:  ResultUtils
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 8:36
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @Override
    public boolean addTemplateGroup( String Id ,String  groupName, String groupSequence) {
        return templateGroupDao.addTemplateGroup(Id,groupName,groupSequence);
    }

    /**
    * @Description: 更新模板分组位置
    * @Param:
    * @Return:
    * @Author: 张凯超
    * @Data: 2020/4/2
    * @Time: 10:03
    * @Version: V1.0.0
    * @Modified by :
    * @Modification Time:
    **/
    @Override
    public boolean updateTemplateGroupPlace(String id, String groupSequence) {
        return templateGroupDao.updateTemplateGroupPlace(id,groupSequence);
    }


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
    @Override
    public boolean updateTemplateGroup(String id) {
        return templateGroupDao.updateTemplateGroup(id);
    }

}
