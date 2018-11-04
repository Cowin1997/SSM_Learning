package springMvc.DispatcherServletConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import spring.Aop.Config;

@EnableWebMvc   //启用springMVC
@Configuration
@ComponentScan(basePackages = {"springMvc"})

public class WebConfig extends WebMvcConfigurerAdapter {
    // 配置JSP视图解析器


    @Bean    //默认name 与方法名相同
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new
                InternalResourceViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     *   静态资源的处理
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }
}
