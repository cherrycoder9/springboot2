package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@ResponseBody // 응답할 데이터의 타입 자동 설정(java)String -> (HTTP)
public class RestController2 {
    // [1] HTTP GET
    @RequestMapping(value = "/example/rest2", method = RequestMethod.GET)
    public String getRest2(HttpServletRequest req) {
        System.out.println("RestController2.getRest2");
        // 1. 요청
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        String str = "[GET]ClientHi";
        // 2. 응답
        // 2-1 메소드의 반환타입을 정의한다.
        return str;
    }

    @RequestMapping(value = "/example/rest2", method = RequestMethod.POST)
    public ArrayList<RestDto> getPost2(HttpServletRequest req) {
        System.out.println("RestController2.getPost2");
        String key = req.getParameter("key");
        System.out.println("key = " + key);

        // 데이터 구성
        // 1 - 배열 타입
        // String[] strArray = new String[2];
        // strArray[0] = "[POST]";
        // strArray[1] = "Client hi";

        // 2 - 리스트 타입
        // ArrayList<String> strArray = new ArrayList<>();
        // strArray.add("[post]");
        // strArray.add("hi hi");

        // 3 - 객체 DTO 타입
        // RestDto strArray = new RestDto("[POST]", "hi hi");

        // 4 - 리스트 안에 DTO 타입
        ArrayList<RestDto> strArray = new ArrayList<>();
        strArray.add(new RestDto("[post1]", "hi hi!!"));
        strArray.add(new RestDto("[post2]", "hi hi!!"));

        return strArray;
    }

    // [3] HTTP PUT
    @RequestMapping(value = "/example/rest2", method = RequestMethod.PUT)
    public int putRest2(HttpServletRequest req) {
        System.out.println("RestController2.putRest2");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        return 10 + 10;
    }

    // [4] HTTP delete
    @RequestMapping(value = "/example/rest2", method = RequestMethod.DELETE)
    public boolean deleteRest2(HttpServletRequest req) {
        System.out.println("RestController2.deleteRest2");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        return true;
    }
}
