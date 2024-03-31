package dev.dinizrodrigues.firstminiproject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    // configurando localizacao de conteudo estatico
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    // configurando para que ao acessar localhost:port redirecione para localhost:port/my-app-name
    // https://stackoverflow.com/questions/56188883/auto-redirect-root-path-to-spring-boot-context-path 
    

    // bom, não deu muito certo... 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        if (!contextPath.isEmpty()) {
            registry.addRedirectViewController("/", contextPath);
        }
    }

}