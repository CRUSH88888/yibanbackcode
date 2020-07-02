package edu.scau.common.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/25 12:10
 **/

@Configuration
public class CommonConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize(1024 * 1024);
        // 限制上传文件大小
        // 单个数据大小
        factory.setMaxFileSize("102400MB"); // KB,MB
        // 总上传数据大小
        factory.setMaxRequestSize("1024000MB");

        return factory.createMultipartConfig();
    }


        /**
         * 驼峰命名方式
         */
//        @Bean
//        public ConfigurationCustomizer configurationCustomizer(){
//
//            return new ConfigurationCustomizer() {
//                @Override
//                public void customize(org.apache.ibatis.session.Configuration configuration) {
//                    configuration.setMapUnderscoreToCamelCase(true);
//                }
//            };
//        }

}

