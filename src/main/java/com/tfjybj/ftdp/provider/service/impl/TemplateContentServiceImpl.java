package com.tfjybj.ftdp.provider.service.impl;

import com.tfjybj.ftdp.model.TemplateContent;
import com.tfjybj.ftdp.model.*;
import com.tfjybj.ftdp.provider.dao.TemplateGroupDao;
import com.tfjybj.ftdp.utils.PatterUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.tfjybj.ftdp.provider.service.TemplateContentService;
import com.tfjybj.ftdp.provider.dao.TemplateContentDao;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname templateService
 * @Date 2020年4月2日09:04:11
 * @Created by 车龙梁
 */
@Service("templateContentService")
public class TemplateContentServiceImpl implements TemplateContentService {

    @Resource
    private TemplateContentDao templateContentDao;
    @Resource
    private TemplateGroupDao templateGroupDao;
    @Autowired
    private  RedisTemplate redisTemplate;

    /**
     * 添加模板内容
     * @param id
     * @param templateId
     * @param componentId
     * @param title
     * @param promptField
     * @param groupSequence
     * @return
     */
    @Override
    public boolean addTemplateContent(String id,
                                      String templateId,
                                      String componentId,
                                      String title,
                                      String promptField,
                                      String groupSequence) {
        return templateContentDao.addTemplateContent(id,templateId, componentId, title,promptField, groupSequence);
    }

    /**
     * 添加模板
     * @param id
     * @param templateName
     * @param templateGroupId
     * @param staffID
     * @param postscript
     * @param isUsable
     * @param groupSequence
     * @param isFinish
     * @return
     */
    @Override
    public boolean templateInsert(String id,
                                  String templateName,
                                  String templateGroupId,
                                  String staffID,
                                  String postscript,
                                  String isUsable,
                                  String groupSequence,
                                  String isFinish){

        return templateContentDao.templateInsert(PatterUtils.getNumberPattern(),templateName,templateGroupId,staffID,postscript,isUsable,groupSequence,isFinish);
    }

    /**
     * 初始化全部模板列表
     * @return
     */
    @Override
    public List<TemplateContent> queryTemplateContent(String templateId) {
        List<TemplateContent> templateContents = templateContentDao.queryTemplateContent(templateId);
            return templateContents;
    }

    /**
     * 根据isUsable查询可用模板
     * @return
     */
    @Override
    public List<TempByIsUsableModel> queryTempByIsUsable() {
/*Redis缓存技术引入
        //先从缓存中查询当前对象
        List<TempByIsUsableModel> tempByIsUsableModels= redisTemplate.opsForValue().get("template_"+templateId);
        if (tempByIsUsableModels==null){
            //如果缓存中没有则查库
            tempByIsUsableModels =  templateContentDao.queryTempByIsUsable(isUsable);//将要返回的参数查出
            //set到Redis中
            redisTemplate.opsForValue().set("template_"+templateId,tempByIsUsableModels);
        }
        return tempByIsUsableModels;
*/
        List<TempByIsUsableModel> dataAll = templateContentDao.queryTempByIsUsable();//将要返回的参数查出
        return dataAll;
    }



    /**
     * 删除模板（修改tin_complateContent表isUsable字段为1）
     * @param id
     * @return
     */
    @Override
    public boolean templateDelete(String id) {
        return templateContentDao.templateDelete(id);
    }

    /**
     * 模板编辑界面加载
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "queryTemplate",key="#id")
    public QueryTemplateModel queryTemplate(String id) {

        QueryTemplateModel queryTemplateModels = templateContentDao.queryTemplate(id);
        List<TemplateGroupModel> templateEntityList = templateGroupDao.queryTemplateGroup();
        queryTemplateModels.setTemplateData(templateEntityList);
        return queryTemplateModels;
    }

    /**
     *侧边栏加载
     *
     * @return
     */
    @Override
    public List<ComponentlibraryModel> queryComponentlibrary() {
        List<ComponentlibraryModel> componentlibraryList = templateContentDao.queryComponentlibrary();//将要返回的参数查出
        return componentlibraryList;
    }
}
