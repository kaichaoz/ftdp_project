package com.tfjybj.ftdp.provider.service.impl;

import com.tfjybj.ftdp.entity.TemplateGroupEntity;
import com.tfjybj.ftdp.entity.TemplatecontentEntity;
import com.tfjybj.ftdp.model.QueryTemplateModel;
import com.tfjybj.ftdp.model.TemplateContentModel;
import com.tfjybj.ftdp.model.TemplateGroupModel;
import com.tfjybj.ftdp.provider.dao.TemplateGroupDao;
import com.tfjybj.ftdp.utils.PatterUtils;
import org.springframework.stereotype.Service;
import com.tfjybj.ftdp.provider.service.TemplateContentService;
import com.tfjybj.ftdp.provider.dao.TemplateContentDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Classname templateService
 * @Date 2020年4月2日09:04:11
 * @Created by 车龙梁
 */
@Service("templateContentService")
public class templateContentServiceImpl implements TemplateContentService {

    @Resource
    private TemplateContentDao templateContentDao;
    @Resource
    private TemplateGroupDao templateGroupDao;

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
    public List<TemplatecontentEntity> queryTemplateContent() {
        return templateContentDao.queryTemplateContent();
    }

    /**
     * 根据isUsable查询可用模板
     * @param isUsable 是否可用
     * @return
     */
    @Override
    public List<TemplateGroupEntity> queryTempByIsUsable(int isUsable) {
        return templateContentDao.queryTempByIsUsable(isUsable);
    }

//    /**
//     * 根据template id修改模板内容
//     * @param id id
//     * @param templateContentModel
//     * @return
//     */
//    @Override
//    public boolean updateTemplateContent(String id, TemplateContentModel templateContentModel) {
//        return templateContentDao.updateTemplateContent(id,templateContentModel);
//    }

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
    public QueryTemplateModel queryTemplate(String id) {

        QueryTemplateModel queryTemplateModels = templateContentDao.queryTemplate(id);
        List<TemplateGroupModel> templateEntityList = templateGroupDao.queryTemplateGroup();
        queryTemplateModels.setTemplateData(templateEntityList);
        return queryTemplateModels;
    }
}
