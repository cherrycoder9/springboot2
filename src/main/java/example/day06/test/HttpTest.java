package example.day06.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/day06/test")
public class HttpTest extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("해당 클래스의 서블릿 객체 생성");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("해당 클래스의 서블릿 객체 서비스 실행");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("입력받은 값: " + req.getParameter("value"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        int returnValue = Integer.parseInt(req.getParameter("value")) + 2;
        resp.getWriter().print(returnValue);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("입력받은 값: " + req.getParameter("value"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        int returnValue = Integer.parseInt(req.getParameter("value")) * 2;
        resp.getWriter().print(returnValue);
        //super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("입력받은 값: " + req.getParameter("value"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        int returnValue = Integer.parseInt(req.getParameter("value")) / 2;
        resp.getWriter().print(returnValue);
        //super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // - 요청데이터: 매개변수처럼 HTTP 요청시 들어오는 데이터, 쿼리스트링 형식
        System.out.println("입력받은 값: " + req.getParameter("value"));
        // - 응답데이터: 리턴값처럼 HTTP 응답시 반환하는 데이터
        int returnValue = Integer.parseInt(req.getParameter("value")) % 2;
        resp.getWriter().print(returnValue);
        //super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
