package example.day06.servlet;
/*
 * 서블릿: 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램
 *   - 웹 서버의 성능을 향상하기 위해 사용되는 일종의 클래스
 *   - 즉) 자바 회사에서 웹 개발을 이용한 클래스 제공한다
 *   - 서블릿 사용하는 방법
 *      1. 해당 클래스에 HttpServlet 상속받는다
 *      2. 외부로부터 해당 클래스를 연결/매핑 할 수 있도록 HTTP url 정의하기
 *      - 해당 클래스에 @(어노테이션)WebServlet("/URL")
 * */

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day06/servlet")
public class ServletController extends HttpServlet {
    // extends: 상속 ( 해당 클래스에 특정 클래스로부터 상속받으면 해당 클래스는 특정클래스로부터 모든 필드/메소드 를 사용할 수 있다.)
    // @Override: 오버라이딩, 상속받는 클래스의 메서드를 재정의

    // 0. init()
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("ServletController.init");
        System.out.println(">> 해당 클래스의 서블릿 객체가 생성됨");
        super.init(config);
    }

    // 0. service()
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.service");
        System.out.println(">> 해당 클래스의 서블릿 객체 서비스가 실행됨");
        super.service(req, resp);
    }

    // 0. destroy
    @Override
    public void destroy() {
        System.out.println("ServletController.destroy");
        System.out.println(">> 해당 클래스의 서블릿 객체 서비스가 초기화 됨");
        super.destroy();


    }

    // 1. doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doGet");
        System.out.println("HTTP의 doGet 메서드 방식으로 요청이 들어왔습니다.");
        // super.doGet(req, resp); // 부모 클래스의 doGet 메서드 호출
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("request Data = " + req.getParameter("data"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        resp.getWriter().print("response Data: [get] client Hi");
    }

    // 2. doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPost");
        System.out.println("HTTP의 doPost 메서드 방식으로 요청이 들어왔습니다.");
        // super.doPost(req, resp);
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("request Data = " + req.getParameter("data"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        resp.getWriter().print("response Data: [post] client Hi");
    }


    // 3. doPut
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPut");
        System.out.println("HTTP의 doPut 메서드 방식으로 요청이 들어왔습니다.");
        // super.doPut(req, resp);
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("request Data = " + req.getParameter("data"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        resp.getWriter().print("response Data: [put] client Hi");
    }

    // 4. doDelete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doDelete");
        System.out.println("HTTP의 doDelete 메서드 방식으로 요청이 들어왔습니다.");
        // super.doDelete(req, resp);
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("request Data = " + req.getParameter("data"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        resp.getWriter().print("response Data: [delete] client Hi");
    }
}
