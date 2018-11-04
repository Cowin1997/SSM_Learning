package springMvc.enity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component("myJson")
public class MyJson {
    private String name;
    private String list[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }
}
