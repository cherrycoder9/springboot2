package example.day04.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    // JSP 방식 =======================
    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        return "JSP in Gradle";
    }

    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "test2";
    }

    // 타임리프 방식 =======================
    @RequestMapping("test3")
    public String test3() {
        return "test1.html";
    }
}
