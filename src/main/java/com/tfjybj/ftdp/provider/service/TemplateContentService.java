package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.model.QueryTemplateModel;
import com.tfjybj.ftdp.model.TemplateContent;
import com.tfjybj.ftdp.model.TempByIsUsableModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TemplateContentService
 * @Date 2020年4月5日08:47:12
 * @Author by 车龙梁
 * @Version 1.0
 */
@Service
public interface TemplateContentService {

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
    boolean addTemplateContent(String id, String templateId, String componentId, String title, String promptField, String groupSequence);

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
    boolean templateInsert(String id,
                           String templateName,
                           String templateGroupId,
                           String staffID,
                           String postscript,
                           String isUsable,
                           String groupSequence,
                           String isFinish);

    /**
     * 初始化全部模板列表
     * @return
     */
    List<TemplateContent> queryTemplateContent(String templateId);

    /**
     * 根据isUsable查询模板
     * @return
     */
    List<TempByIsUsableModel> queryTempByIsUsable();


    /**
     * 删除模板（修改tin_complateContent表isUsable字段为1）
     * @param id
     * @return
     */
    boolean templateDelete(String id);

    /**
     * 初始化模板编辑页面（查询tin_complate表和tin_complateGroup）
     * @param id
     * @return
     */
    QueryTemplateModel queryTemplate (String id);
}
