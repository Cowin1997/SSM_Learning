package springMvc.Controllers;


import mybatis.myDao.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springMvc.enity.UserInfo;
import springMvc.enity.UserLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/MyController")
@Controller


//@SessionAttributes(value = "user",types = String.class)
public class MyController {
    private static String SUCCESS = "success";



    @ModelAttribute
    public void getUser(@RequestParam(value = "userName",required = false) String username,Map<String,Object>map){

        if(username.equals("admin")){
            UserLogin user = new UserLogin("admin","123",new UserInfo("厦门","男"));
            System.out.println("模拟数据库获取："+user);

            map.put("userLogin",user);
        }

    }






    // REST 风格的, 不是真正意义的请求参数
    @RequestMapping(value = "/{Variable}",method = RequestMethod.GET)
    public String testPathVariable(@PathVariable String Variable ){
        System.out.println("TestPathVariable"+":"+Variable);
        return SUCCESS;
    }

    /**
     *  通过@RequestParam 获取参数,默认是必须带着个参数,不带参数会报错,required默认为true
     *  可以通过@RequestParam(value = "username",required = false) 不是必须的
     *
     *  如果请求参数是int类型,例如@RequestParam(value = "id",required = false) int id
     *  int要改为Integer,或者@RequestParam(value = "id",required = false，defaultValue="0")

     * @return
     */
    @RequestMapping(value = "/TestRequestParam")
    public String testRequestParam(@RequestParam(value = "username",required = false)String username,
       @RequestParam(value = "password")String password ){
        System.out.println(username+":"+password);
        return SUCCESS;
    }

    /**
     *
     * @CookieValue 获取cookie值,属性和@RequestParam 一样有 required,defaultValue
     *
     * @param sessionId
     * @return
     */


    @RequestMapping(value = "/testCookieValue",method = RequestMethod.GET)
    public String testCookieValue(@CookieValue("JSESSIONID")String sessionId){
        System.out.println("JSESSIONID="+sessionId);
        return SUCCESS;
    }


    /**
     *
     *  测试通过将参数封装到pojo,可以使用级联属性,通过表单提交
     *
     *
     * @return
     */
    @RequestMapping(value = "/testPojo",method = RequestMethod.POST)
    public String testPojo(UserLogin userLogin){
        System.out.println("testPoJo:"+userLogin);
        System.out.println("Address:"+userLogin.getUserInfo().getAddress());
        System.out.println("Gender:"+userLogin.getUserInfo().getSex());
        return SUCCESS;
    }

    /**
     *
     *  测试原生的ServletApi,可以使用原生的Api作为目标方法的参数,具体支持以下类型
     *      HttpServletRequest
     *      HttpServletResponse
     *      Writer
     *      Reader
     *      Local InputStream
     *      HttpSession
     *      java.security.Principal
     *      等类型
     * @param request
     * @param response
     * @param out
     * @throws IOException
     */

    @RequestMapping(value = "/testServletApi",method = RequestMethod.GET)
    public void testServletApi(HttpServletRequest request, HttpServletResponse response,Writer out) throws IOException {
        System.out.println("testServletApi:"+request+";"+response);
        out.write("hello,springmvc!");
    }

    /**
     *  可以返回ModelAndView类型,包含视图名和模型数据信息
     *  SpringMVC会把ModelAndView的model中的数据放到request域对象中
     * @return
     */
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewname = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewname);
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    /**
     *
     *
     *  还可以在参数中使用Map,Model,ModelMap类型来封装数据返回
     *  实际到最后以上的类型都会被转化为BindingAwareModelAndMap类型
     * @param map
     * @return
     */

    @RequestMapping(value = "testMap")
    public String testMap(Map<String,Object> map){
        map.put("names",Arrays.asList("Tom","Jerry","Mike"));
        return SUCCESS;
    }


    /**
     *
     *@SessionAttributes(value = "user",types = String.class)
     * 可以指定key为user的value放入Session域中,还可以指定将String类型的Value放入Session中,
     * 这样底层是将key,value放入request域的同时也将其放入session域中,
     *
     * 注意 @SessionAttributes注释的类级别的,不能放在方法上
     *
     *
     * @return
     */


    @RequestMapping(value = "/testSessionAttributes")
    public ModelAndView testSessionAttributes(){
        String viewname = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewname);
        UserLogin userLogin = new UserLogin("小菲","123");
        modelAndView.addObject("user",userLogin);
        modelAndView.addObject("session","StringTypeSession");
        return modelAndView;
    }









    /**
     *
     *  如果数据更新,但是指定只能更新某些属性,例如修改个人信息,但是不允许修改密码和用户名,如下操作会
     *  修改:UserLogin{userName='null', passWord='null', userInfo=UserInfo{address='北京', sex='女'}}
     *  password字段变为null,这样更新错误！
     *
     *   应该从数据库查询后返回一个user,再修改指定允许修改的属性,这样password就不会为null,且保持与数据库一致没有被改变
     *
     *
     *   可以配合@ModelAttributrz注解方法来实现
     *
     *
     * @param user
     * @return
     */

   @RequestMapping(value = "/testModelAttribute",method = RequestMethod.POST)
    public String testModelAttribute(UserLogin user){
        System.out.println("修改:"+user);
        return SUCCESS;
//修改:UserLogin{userName='null', passWord='null', userInfo=UserInfo{address='北京', sex='女'}}
    }




}
