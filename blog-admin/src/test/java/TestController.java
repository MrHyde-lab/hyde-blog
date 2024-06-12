import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hyde.BlogApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

@SpringBootTest(classes = BlogApplication.class)
public class TestController {
    @Test
    public void test() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root", "120507")
                .globalConfig(builder -> builder
                        .author("hyde")
                        .enableSwagger()
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )

                .packageConfig(builder -> {
                    builder.parent("com.hyde")
                            .entity("entity")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper");
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .enableLombok()
                            .idType(IdType.ASSIGN_UUID)
                            .formatFileName("%s")             // 格式化实体名称，%s取消首字母I
                            .enableFileOverride()             // 覆盖已生成文件

                            .controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle()                // @RestController
                            .enableFileOverride()             // 覆盖已生成文件

                            .serviceBuilder()
                            .enableFileOverride()             // 覆盖已生成文件

                            .formatServiceImplFileName("%sServiceImpl") // 格式化实体名称，%s取消首字母I
                            .enableFileOverride()             // 覆盖已生成文件

                            .mapperBuilder()
                            .enableMapperAnnotation()         // @Mapper
                            .formatMapperFileName("%sMapper") // 格式化实体名称，%s取消首字母I
                            .enableFileOverride();            // 覆盖已生成文件;
                })
//                .templateEngine(new FreemarkerTemplateEngine())     // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}


