package com.springboot.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * Mybatis-Plus 自动生成代码类
 */
public class Generator {
    public static void main(String[] args) {
        // 获取当前文件夹
        String currentFile = System.getProperty("user.dir");
        // 包名
        String packageName = "com.db";

        // 生成
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dbdemo","root","123456")
                .globalConfig(builder ->
                        builder.author("xxx")
                            // 开启swagger
                            .enableSwagger()
                            // 覆盖已生成的文件
                            .fileOverride()
                            // 禁止打开输出目录，默认值为：true
                            .disableOpenDir()
                            // 默认值：DateType.TIME_PACK
                            .dateType(DateType.TIME_PACK)
                            .outputDir(currentFile + "/src/test/java"))
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent(packageName)
                            // 设置父包模块名
                            .moduleName("dbdemo")
                            // Entity
                            .entity("entity")
                            // 设置dto包名
                            .other("dto")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service/serviceImpl")
                            .controller("controller")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,currentFile + "/src/test/resources/" + packageName));
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,currentFile + "/src/test/java/" + packageName + "/gsdb/mapper/mapping"));
                })
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("student")
                            // 设置过滤表前缀
                            .addTablePrefix("t_","c_")
                            // Entity策略配置
                            .entityBuilder()
                            // 开启Lombok
                            .enableLombok()
                            // 开启生成实体时生成字段注释
                            .enableTableFieldAnnotation()
                            // Mapper策略配置
                            .mapperBuilder()
                            // 开启@Mapper注解
                            .enableMapperAnnotation()
                            // 启用BaseColumnList
                            //.enableBaseColumnList()
                            // 启用BaseResultMap生成
                            //.enableBaseResultMap()
                            .serviceBuilder()
                            // "%sService" 去掉Service接口的首字母I
                            .formatServiceFileName("%sService")
                            // controller策略配置
                            .controllerBuilder()
                            // 开启生成@RestController控制器
                            .enableRestStyle()
                            .enableHyphenStyle();
                })
                // 使用Freemarker引擎模块，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
