package web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        System.out.println("WebConfig.addResourceHandlers");
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:C:/Users/codemaster/Documents/workspace/springboot2/src/main/resources/static/upload/");
    }
}
