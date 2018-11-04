package springMvc.DispatcherServletConfig;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 *
 *     配置 DispatcherServlet
 *     继承  AbstractAnnotationConfigDispatcherServletInitializer
 */

//@ContextConfiguration(classes = Config.class)
public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *
     * getRootConfigClasses()用来创建ContextLoaderListener创建的应用上下文的bean,
     * 主要是加载其他的bean(中间层,数据层)
     *
     *
     * @return
     */

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     *  getServletConfigClasses配置定义DispatcherServlet应用上下文的bean
     *  (控制器,视图解析器,处理器映射等等)
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     *   配置前端控制器的映射,相当于web.xml中的：
     *      <servlet-mapping>
     *              <servlet-name>springmvc</servlet-name>
     *              <url-pattern>/</url-pattern>
     *      </servlet-mapping>
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }




}
