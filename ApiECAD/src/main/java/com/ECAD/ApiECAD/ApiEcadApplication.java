package com.ECAD.ApiECAD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan
@SpringBootApplication
public class ApiEcadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEcadApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        String origins = "/**";
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/filesInfo").allowedOrigins(origins);
                registry.addMapping("/filesInfo/nomes").allowedOrigins(origins);
                registry.addMapping("/filesInfo/bancos").allowedOrigins(origins);
            }
        };
    }
}
