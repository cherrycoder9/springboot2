package example.day07.restcontroller;

// including RESTful: HTTP 기반의 자원을 제공하는 인터페이스 구축(CRUD)
// SPRING WEB 아닌 환경 = servlet 클래스 직접 구현, servlet 클래스를 controller
// SPRING WEB 환경 = MVC2 3티어 제공해 controller 자동으로 서블릿 등록

// 해당 클래스가 스프링 mvc에서 컨트롤러 역할 클래스임을 등록, 스프링 컨테이너(저장소) 빈(객체)등록
// 제어 역전(IOC): 객체 관리를 개발자가 아닌 스프링이 해준다.
// 왜? 여러 개발자가 공통으로 사용할 객체는 1명이 관리하면 좋은데 그 1명이 관리를 스프링이 대신 해주겠다.

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class RestController1 {
    // @RequestMapping(value = "해당 메소드가 매핑할 HTTP 주소", method = RequestMethod.HTTP메소드)
    // value: ip와port는 생략함 -> "/example/rest1"
    // - 서버 내 동일한 url 정의할 수 없다. 하지만 http메소드가 다를 경우 동일한 주소를 정의 가능하다
    // method: RequestMethod.HTTP메소드명 : GET, POST, PUT, DELETE

    // [1] HTTP GET
    @RequestMapping(value = "/example/rest1", method = RequestMethod.GET)
    public void getRest1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.getRest1");
        // 데이터 요청
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        // 데이터 응답
        resp.getWriter().print("[GET]hi hi!!");
    }

    // [2] HTTP POST
    @RequestMapping(value = "/example/rest1", method = RequestMethod.POST)
    public void postRest1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.postRest1");
        // 데이터 요청
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        // 데이터 응답
        resp.getWriter().print("[GET]hi hi!!");
    }

    // [3] HTTP PUT
    @RequestMapping(value = "example/rest1", method = RequestMethod.PUT)
    public void putRest1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.putRest1");
        // 데이터 요청
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        // 데이터 응답
        resp.getWriter().print("[GET]hi hi!!");
    }

    // [4] HTTP DELETE
    @RequestMapping(value = "example/rest1", method = RequestMethod.DELETE)
    public void deleteRest1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RestController1.deleteRest1");
        // 데이터 요청
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        // 데이터 응답
        resp.getWriter().print("[GET]hi hi!!");
    }
}
