package com.tfjybj.ftdp.utils;

import lombok.Getter;

/**
 * @Classname CodeEnum
 * @Description TODO
 * @Date 2020/4/1 9:49
 * @Author by 张凯超
 * @Version 1.0
 */
@Getter
public enum CodeEnumUtils {
    DELETE_SUCCESS("0000","删除成功！"),
    INSERT_SUCCESS("0000","添加成功！"),
    SELECT_SUCCESS("0000","查询成功！"),
    MODIFY_SUCCESS("0000","修改成功！"),
    SELECT_FAIL("1111","查询失败！"),
    DELETE_FALL("1111","删除失败！"),
    MODIFY_FALL("1111","修改失败！"),
    INSERT_FALL("1111","添加失败！"),
    SELECT_FINISH("2222","暂无数据！"),
    MODIFY_FINISH("5555","更新完成！");
    private  String code;
    private  String message;

    CodeEnumUtils(String code ,String message){
        this.code = code ;
        this.message = message;
    }
}
