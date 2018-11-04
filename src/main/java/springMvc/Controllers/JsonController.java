package springMvc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springMvc.enity.MyJson;

import java.util.Date;


@Controller
@RequestMapping("/json")
public class JsonController {
    @Autowired
    private MyJson myJson;

    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public @ResponseBody MyJson getJson (@PathVariable String name)  {
      //  LoginUser loginUser = MyBatisTest.get();
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println("-----Json------");
        myJson.setName("xubingtao");
        String [] list = new String[]{"one","two"};
        myJson.setList(list);
        return myJson;
    }
}
