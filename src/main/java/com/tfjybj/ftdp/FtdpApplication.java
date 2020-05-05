package com.tfjybj.ftdp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"com.tfjybj.ftdp.provider.dao"})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
//@ImportResource({"classpath*:spring-shiro.xml"})
@EnableScheduling
@EnableCaching
public class FtdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtdpApplication.class, args);
    }

}
