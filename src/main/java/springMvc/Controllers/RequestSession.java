package springMvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(value = "name")
@RequestMapping("/session")
public class RequestSession {

    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public String setSession(Model model, HttpSession httpSession,@PathVariable String name){
        //httpSession.setAttribute("name","xubingtao");
        model.addAttribute("name",name);
        return "redirect:getsession";
   }
    @RequestMapping(value = "/getsession",method = RequestMethod.GET)
    public String getSession(Model model){

        System.out.println("***********");
        return "session";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpSession session){
        System.out.println(session.getAttribute("name"));
        return "session";
    }
}
