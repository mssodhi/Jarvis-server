package app.web.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"app.web"}, excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
@WebListener
@PropertySources(value = {  @PropertySource( value = "classpath:/app.${spring.profiles.active}.properties", ignoreResourceNotFound = true)})
public class WebConfig extends WebMvcConfigurerAdapter implements WebApplicationInitializer {


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        // need to to wire up @value
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void onStartup(ServletContext container) throws ServletException {
//        container.addListener(RequestContextListener.class);
//        ServletRegistration.Dynamic h2Servlet = container.addServlet("h2console", new org.h2.server.web.WebServlet());
//        h2Servlet.setInitParameter("webAllowOthers", "true");
//        h2Servlet.setLoadOnStartup(1);
//        h2Servlet.addMapping("/h2/*");
    }
}
