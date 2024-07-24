package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class RestController4 {
    ////////////// 쿼리스트링의 매개변수들을 매핑하는 방법

    // 1 - HTTP Get
    @GetMapping("/test1")
    public String test1(HttpServletRequest req) {
        System.out.println("RestController4.test1");
        String key1 = req.getParameter("key1");
        System.out.println("key1 = " + key1);
        String key2 = req.getParameter("key2");
        System.out.println("key1 = " + key2);
        return key1 + key2;
    }

    // 2 - HTTP Get
    @GetMapping("/test2") // 전제 조건: 쿼리스트링의 key 이름과 메소드의 매개변수명이 동일해야 한다.
    public String test2(String key1, int key2) {
        System.out.println("RestController4.test2");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return "test2 fsdafds";
    }

    // 3 - HTTP Get
    @GetMapping("/test3") // 전제 조건: 쿼리스트링의 key 이름과 메소드의 매개변수명이 동일해야 한다.
    // 쿼리스트링의 key 이름과 메소드의 매개변수명이 동일하지 않기 때문에 오류, 해결방안은 @RequestParam 타입 매개변수명
    public String test3(@RequestParam("key1") String name, @RequestParam("key2") int age) {
        System.out.println("RestController4.test3");
        System.out.println("name = " + name + ", age = " + age);
        String str = "name = " + name + ", age = " + age;
        return str;
    }

    // 4 - HTTP Get
    @GetMapping("/test4")
    public String test4(RestDto restDto) { // 전제조건: 쿼리스트링의 key 이름과 멤버변수의 이름과 동일해야 한다.
        System.out.println("RestController4.test4");
        System.out.println("restDto = " + restDto);
        return restDto.toString();
    }
}
