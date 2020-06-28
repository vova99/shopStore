package com.favoris.shopStore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;


@Configuration
public class ThymeleafConfig {

//    @Bean
//    public ViewResolver viewResolver(List<AbstractDialect> dialects, SpringTemplateEngine templateEngine) {
//        templateEngine.setDialects(new HashSet<>(dialects));
//
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine);
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
