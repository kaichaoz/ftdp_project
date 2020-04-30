package com.tfjybj.ftdp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 公共实体类，封装了每个实体的公共字段-包括:operator,isDelete,remark,createTime,updateTime
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public abstract class BaseEntity implements Serializable {
    /**
     * 操作人
     */
    @Column(name = "operator")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;
    /**
     * 删除标记
     */
    @TableLogic
    @Column(name = "is_delete")
    private int isDelete = 0;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 创建日期
     */
//    @JsonFormat(
//            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8"
//    )
    @TableField(fill = FieldFill.INSERT)
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新日期
     */
//    @JsonFormat(
//            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8"
//    )
    @Column(name = "update_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    public BaseEntity() {
    }

    /**
     * get-操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * set-操作人
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * get-是否删除
     */
    public int getIsDelete() {
        return isDelete;
    }

    /**
     * set-是否删除
     */
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * get-备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set-备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * get-创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set-创建日期
     */
    public void setCreateTime(Date createTime) {
        if (createTime == null || "".equals(createTime)){
            this.createTime = createTime;
        }
    }

    /**
     * get-更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set-更新日期
     */
    public void setUpdateTime(Date updateTime) {
        if (createTime == null || "".equals(createTime)){
            this.updateTime = updateTime;
        }
    }

}
