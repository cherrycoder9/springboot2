package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller + @ResponseBody : 해당 클래스의 메소드들은 모두 @ResponseBody 적용된다.
@RequestMapping(value = "/example") // 컨트롤러 클래스 매핑: 해당 클래스의 메소드들의 공통 URL 정의한다
public class RestController3 {
    // 1 - HTTP GET
    // @RequestMapping(value = "/example/rest3", method = RequestMethod.GET)
    @GetMapping("/rest3")
    public String getRest3(HttpServletRequest req) {
        System.out.println("RestController3.getRest3");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        String str = "GET - Client hi";
        return str;
    }

    // 2 - HTTP POST
    @PostMapping("/rest3")
    public RestDto postRest3(HttpServletRequest req) {
        System.out.println("RestController3.postRest3");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        RestDto restDto = new RestDto("post", "client hi");
        return restDto;
    }

    // 3 - HTTP PUT
    @PutMapping("/rest3")
    public int putRest3(HttpServletRequest req) {
        System.out.println("RestController3.putRest3");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        return 10 + 10;
    }

    // 4 - HTTP DELETE
    @DeleteMapping("/rest3")
    public boolean deleteRest3(HttpServletRequest req) {
        System.out.println("RestController3.deleteRest3");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        return true;
    }
}
