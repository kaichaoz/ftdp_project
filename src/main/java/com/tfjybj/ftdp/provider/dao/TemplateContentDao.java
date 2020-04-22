package com.tfjybj.ftdp.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfjybj.ftdp.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Classname templateDao
 * @Date 2020年4月2日09:04:11
 * @Created by 车龙梁
 */
@Repository("templateDao")
public interface TemplateContentDao extends BaseMapper<TemplateModel> {

    /**
     * 添加模板内容（templateContent表）
     *
     * @param fieldSequence
     * @param id
     * @param templateId
     * @param componentId
     * @param title
     * @param promptField
     * @param groupSequence
     * @return
     */
    boolean addTemplateContent(String fieldSequence , String id, String templateId, String componentId, String title, String promptField, String groupSequence);

    /**
     * 初始化全部模板
     * @return
     */
    List<TemplateContent> queryTemplateContent(String templateId);

    /**
     * 查询可用模板
     * @return
     */
    List<TempByIsUsableModel> queryTempByIsUsable();

//    /**
//     *编辑模板
//     * @param id
//     * @return
//     */
//    boolean updateTemplateContent(@Param("id") String id,@RequestBody TemplateContentModel templateContentModel);

    /**
     * 删除模板（通过修改isUsable字段实现假删除）
     * @param id
     * @return
     */
    boolean templateDelete(String id);

    /**
     * 添加模板（插入template表）
     * @param id  模板id
     * @param templateName 模板名称
     * @param templateGroupId 模板分组id
     * @param staffID 人员id
     * @param postscript 备注
     * @param isUsable 是否可用（0可用1不可用）
     * @param groupSequence 分组排序
     * @param isFinish 是否编辑完成（0完成，1未完成）
     * @return
     */
    boolean templateInsert(String id,String templateGroupId,String templateName,String groupSequence,int isFinish,String postscript,int isUsable,String staffID);

    /**
     * 模板编辑界面加载
     * @param id
     * @return
     */
    QueryTemplateModel queryTemplate (String id);

    /**
     * 侧边栏加载
     * @return
     */
    List<ComponentlibraryModel> queryComponentlibrary();
}
