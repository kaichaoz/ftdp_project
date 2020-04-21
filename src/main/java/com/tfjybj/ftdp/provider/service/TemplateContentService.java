package com.tfjybj.ftdp.provider.service;

import com.tfjybj.ftdp.model.*;
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
     * @param templateContentRequest
     * @return
     */
    boolean addTemplateContent(TemplateContentRequest templateContentRequest);

    /**
     * 添加模板
     * @param templateModel
     * @return
     */
    boolean templateInsert(TemplateModel templateModel);

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
     * 删除模板（修改tin_complate表isUsable字段为1）
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
