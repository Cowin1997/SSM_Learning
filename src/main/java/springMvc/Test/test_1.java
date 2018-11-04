package springMvc.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import springMvc.Controllers.HomeController;
import springMvc.DispatcherServletConfig.MyDispatcherServlet;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
@ContextConfiguration(classes = MyDispatcherServlet.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test_1 {
    @Test
    public  void test() throws Exception{
        MyDispatcherServlet servlet = new MyDispatcherServlet();
        HomeController controller = new HomeController();
        assertEquals("inde",controller.home());
        MockMvc mockMvc = standaloneSetup(controller).build();
        /**
         *          如果你的view name和你的path是相同的字符串，根据Spring的转发规则，
         *          就等于让自己转发给自己，会陷入死循环。
         *          所以Spring会检查到这种情况，于是抛出Circular view path异常。
         *          所以 /index 请求后
         */
        mockMvc.perform(get("/")).andExpect(view().name("inde"));
    }
}
