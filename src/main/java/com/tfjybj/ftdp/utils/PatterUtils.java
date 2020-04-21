package com.tfjybj.ftdp.utils;



import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname PatterUtils
 * @Description 根据正则截取纯数字字符
 * @Date 2020/4/7 9:54
 * @Author by 张凯超
 * @Version 1.0
 */
public class PatterUtils {

        /**
        * @Description: 使用UUID生产住建Id并使用前八位数字
        * @Author: 张凯超
        * @Data: 2020/4/12
        * @Time: 9:47
        * @Version: V1.0.0
        * @Modified by :
        * @Modification Time:
        **/
        public static String getNumberPattern() {
            //使用UUID生成ID，将“-”替换为“ ”；
            String Id = UUID.randomUUID().toString().replaceAll("-","");
            // 纯数字正则
            String regEX= "[^0-9]+";
            Pattern pattern = Pattern.compile(regEX);
            Matcher matcher = pattern.matcher(Id);
            String Ids = matcher.replaceAll("").trim();
            return Ids;
        }

}
