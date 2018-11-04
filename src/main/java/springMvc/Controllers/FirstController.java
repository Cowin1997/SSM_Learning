package springMvc.Controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *      通过实现Controller接口 (原始实现)
 *
 */
public class FirstController implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 向模型数据添加数据
        modelAndView.addObject("msg","SpringMvc");
        // 设置逻辑视图名
        modelAndView.setViewName("inde.jsp");
        return modelAndView;
    }
}
