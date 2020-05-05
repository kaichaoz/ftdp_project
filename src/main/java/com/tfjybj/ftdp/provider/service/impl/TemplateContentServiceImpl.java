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
    public boolean addTemplateContent(List<TemplateContentModel> templateContentModel) {
        String id,newid = null;
        for (TemplateContentModel teml :templateContentModel){
            templateContentDao.templateContentDelete(teml.getTemplateId());
        }//在更新前将模板Id下的模板内容置为不可用
        for (TemplateContentModel temmodel :templateContentModel){
            //外层解析数据
            List<TemplateContentModel2> templateContentModel2=temmodel.getTemplateContentData();
            for (TemplateContentModel2 tempModel2:templateContentModel2){
                //内层解析数据
                id= tempModel2.getId();
                if("".equals(id)){
                    //id判空并生成UUID，如果Id为空则插入一条数据
                    newid = PatterUtils.getNumberPattern();//UUID生成调用
                    templateContentDao.addTemplateContent(newid,
                            temmodel.getTemplateId(),
                            temmodel.getComponentId(),
                            tempModel2.getTitle(),
                            tempModel2.getPromptField(),
                            tempModel2.getFieldSequence(),
                            temmodel.getGroupSequence(),
                            tempModel2.getIsUsable());
                }else{//否则根据更新该条数据
                 templateContentDao.addTemplateContent(id,
                            temmodel.getTemplateId(),
                            temmodel.getComponentId(),
                            tempModel2.getTitle(),
                            tempModel2.getPromptField(),
                            tempModel2.getFieldSequence(),
                            temmodel.getGroupSequence(),
                            tempModel2.getIsUsable());
                }
            }
        }
        return true ;
    }

    /**
     * 编辑模板内容
     * 目前添加和编辑合并为一个接口
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
     * @return templateId
     */
    @Override
    public String templateInsert(TemplateModel templateModel){
        templateContentDao.templateInsert(templateModel.getId(),
                                                templateModel.getTemplateGroupID(),
                                                templateModel.getTemplateName(),
                                                templateModel.getGroupSequence(),
                                                templateModel.getIsFinish(),
                                                templateModel.getPostscript(),
                                                templateModel.getIsUsable(),
                                                templateModel.getStaffID());
        return templateModel.getId();
        //返回模板id
    }

    /**
     * 编辑模板
     * @param templateModel
     * 目前添加和编辑合并为一个接口
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
        List<TempByIsUsableModel> dataAll = templateContentDao.queryTempByIsUsable();
        //查询可用模板
        for (TempByIsUsableModel tempByIsUsableModel : dataAll){
            //将模板分组下模板isUsable为1的分组名称遍历出来
            List<TempByIsUsableData> tempByIsUsableDataList = tempByIsUsableModel.getTempByIsUsableData();
            Iterator<TempByIsUsableData> tempByIsUsableDataIterator = tempByIsUsableDataList.iterator();
            while (tempByIsUsableDataIterator.hasNext()){
                TempByIsUsableData tempByIsUsableData = tempByIsUsableDataIterator.next();
                if ("1".equals(tempByIsUsableData.getIsUsable()) || "".equals(tempByIsUsableData.getTemplateName()) ){
                    tempByIsUsableDataIterator.remove();
                }
            }

        }
        return dataAll;
    }

    /**
     * 删除模板（修改tin_complate表isUsable字段为1）
     * @param id
     * @return
     */
    @Override
    public boolean templateDelete(String id) {
        return templateContentDao.templateDelete(id);
    }
    /**
     * 删除模板内容（修改tin_complateContent表isUsable字段为1）
     * @param templateId
     * @return
     */

    @Override
    public boolean templateContentDelete(String templateId) {
       return templateContentDao.templateContentDelete(templateId);
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
