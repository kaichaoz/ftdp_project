package com.tfjybj.ftdp.provider.service.impl;

import com.tfjybj.ftdp.model.TemplateContent;
import com.tfjybj.ftdp.model.*;
import com.tfjybj.ftdp.utils.PatterUtils;
import org.springframework.stereotype.Service;
import com.tfjybj.ftdp.provider.service.TemplateContentService;
import com.tfjybj.ftdp.provider.dao.TemplateContentDao;
import javax.annotation.Resource;
import java.util.*;


/**
 * @Classname templateService
 * @Date 2020年4月2日09:04:11
 * @Created by 车龙梁
 */
@Service("templateContentService")
public class TemplateContentServiceImpl implements TemplateContentService {

    @Resource
    private TemplateContentDao templateContentDao;

    /**
     * 添加模板内容
     * @param templateContentModel
     * @return
     */
    @Override
    public boolean addTemplateContent(TemplateContentModel templateContentModel) {
        //解析前端传入数据
        List<TemplateContentModel2> templateContentModel2=templateContentModel.getTemplateContentData();
        TemplateContentModel2 tem =templateContentModel2.get(0);
        String templateId =templateContentModel.getTemplateId();
        String componentId=templateContentModel .getComponentId();
        String groupSequence=templateContentModel.getGroupSequence();
        String id = PatterUtils.getNumberPattern();
        String title=tem.getTitle();
        String promptField=tem.getPromptField();
        String fieldSequence=tem.getFieldSequence();
        return templateContentDao.addTemplateContent(id,
                                                    templateId,
                                                    componentId,
                                                    title,
                                                    promptField,
                                                    fieldSequence,
                                                    groupSequence);
    }

    /**
     * 编辑模板内容
     * @param templateContentRequest
     * @return
     */
    @Override
    public boolean updateTemplateContent(TemplateContentRequest templateContentRequest){
        return templateContentDao.updateTemplateContent(templateContentRequest.getId(),
                                                        templateContentRequest.getTemplateId(),
                                                        templateContentRequest.getComponentId(),
                                                        templateContentRequest.getTitle(),
                                                        templateContentRequest.getPromptField(),
                                                        templateContentRequest.getFieldSequence(),
                                                        templateContentRequest.getGroupSequence());
    }

    /**
     * 添加模板
     * @param templateModel
     * @return
     */
    @Override
    public boolean templateInsert(TemplateModel templateModel){
        return templateContentDao.templateInsert(templateModel.getId(),
                                                templateModel.getTemplateGroupID(),
                                                templateModel.getTemplateName(),
                                                templateModel.getGroupSequence(),
                                                templateModel.getIsFinish(),
                                                templateModel.getPostscript(),
                                                templateModel.getIsUsable(),
                                                templateModel.getStaffID());
    }

    /**
     * 编辑模板
     * @param templateModel
     * @return
     */
    @Override
    public boolean updateTemplate(TemplateModel templateModel){
        return templateContentDao.updateTemplate(templateModel.getId(),
                                                templateModel.getTemplateGroupID(),
                                                templateModel.getTemplateName(),
                                                templateModel.getGroupSequence(),
                                                templateModel.getIsFinish(),
                                                templateModel.getPostscript(),
                                                templateModel.getIsUsable(),
                                                templateModel.getStaffID());
    }

    /**
     * 初始化全部模板
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
