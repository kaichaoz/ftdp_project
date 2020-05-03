package com.tfjybj.ftdp.provider.service.impl;

import com.tfjybj.ftdp.model.TemplateContent;
import com.tfjybj.ftdp.model.TemplateGroupModel;
import com.tfjybj.ftdp.model.TemplateModel;
import com.tfjybj.ftdp.provider.dao.TemplateContentDao;
import com.tfjybj.ftdp.provider.dao.TemplateGroupDao;
import com.tfjybj.ftdp.provider.service.TemplateGroupService;
import com.tfjybj.ftdp.utils.PatterUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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

    @Resource
    private TemplateContentDao templateContentDao;
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
        List<TemplateGroupModel> templateEntityList ;
        templateEntityList = templateGroupDao.queryTemplateGroup();
        Iterator<TemplateGroupModel> templateGroupModelIterator = templateEntityList.iterator();
        while (templateGroupModelIterator.hasNext()){
            TemplateGroupModel templateGroupModel = templateGroupModelIterator.next();
            if ("".equals(templateGroupModel.getTemplateGroupName()) || templateGroupModel.getTemplateGroupName().isEmpty()){
                templateGroupModelIterator.remove();
            }
        }
//        if (redisUtil.hasKey(ftdpRedisKey.getTemplateGroup())){
//            redisUtil.del(ftdpRedisKey.getTemplateGroup());
//        }
//        //放入缓存中
//        redisUtil.llSetAll("FTDP:templateGroup",templatteEntityList);
        return templateEntityList;
    }

    /**
     * @Description: v添加模板分组
     * @Param: groupName:模板分组名称   groupSequence:模板分组顺序
     * @Return: ResultUtils
     * @Author: 张凯超
     * @Data: 2020/4/2
     * @Time: 8:36
     * @Version: V1.0.0
     * @Modified by :
     * @Modification Time:
     **/
    @Override
    public boolean addTemplateGroup(TemplateGroupModel templateGroupModel) {
        templateGroupModel.setId(PatterUtils.getNumberPattern());
        templateGroupModel.setIsUsable(0);
        templateContentDao.templateInsert(PatterUtils.getNumberPattern(),templateGroupModel.getId(),"","Don't Delete",0,"",1,"");
        return templateGroupDao.addTemplateGroup(templateGroupModel);
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
    public boolean updateTemplateGroup(TemplateGroupModel templateGroupModel) {
        List<TemplateModel> templateModels = templateGroupDao.queryTemplate(templateGroupModel.getId());
        if (templateModels.size() == 0 || templateGroupModel.getIsUsable() == 0 ){
          int num =   templateGroupDao.updateByModel(templateGroupModel);
          if (num > 0 ){
              return true ;
          }else{
              return false;
          }
        }
        return templateGroupDao.updateTemplateGroup(templateGroupModel);
    }

}