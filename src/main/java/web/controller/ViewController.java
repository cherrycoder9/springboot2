// src\main\java\web\contoller\ViewController.java

package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // ResponseBody없이 순수 컨트롤러만 사용
public class ViewController {
    // AJAX 통신용이 아닌 순수 템플릿 반환하는 컨트롤러
    // index page return (HTML)
    @GetMapping("/") // 페이지 요청은 HTTP의 GET 방식을 주로 사용한다.
    public String index() {
        System.out.println("ViewController.index");
        return "/index"; // 템플릿 폴더내 반환할 경로와 파일명
    }

    // ========== 2 - 회원 관련 ==============
    // 회원가입 page return (HTML)
    @GetMapping("/member/signup")
    public String mSignup() {
        System.out.println("ViewController.mSignup");
        return "/member/signup"; // 템플릿 폴더내 반환할 경로와 파일명
    }

    // 로그인 page return (HTML)
    @GetMapping("/member/login")
    public String mLogin() {
        System.out.println("ViewController.mLogin");
        return "/member/login"; // 템플릿 폴더내 반환할 경로와 파일명
    }

    // 아이디 찾기 page return (HTML)
    @GetMapping("/member/findid")
    public String mFindid() {
        System.out.println("ViewController.mFindid");
        return "member/findid";
    }

    // 비밀번호 찾기 page return (HTML)
    @GetMapping("/member/findpw")
    public String mFindpw() {
        System.out.println("ViewController.mFindpw");
        return "member/findpw";
    }

    // 내정보 page return (HTML)
    @GetMapping("/member/mypage")
    public String mMypage() {
        System.out.println("ViewController.mMypage");
        return "member/mypage";
    }

    // 내정보 수정 page return (HTML)
    @GetMapping("/member/modify")
    public String mModify() {
        System.out.println("ViewController.mModify");
        // 새로운 정보로 수정할 수 있는 페이지로 이동
        return "member/modify";
    }

    // 회원탈퇴 page return (HTML)
    @GetMapping("/member/withdraw")
    public String mWithdraw() {
        System.out.println("ViewController.mWithdraw");
        // 회원 탈퇴 페이지로 이동
        return "member/withdraw";
    }

    // 전체 출력 페이지 return html
    @GetMapping("/board/allpage")
    public String bAllpage() {
        return "/board/allpage";
    }

    // 글쓰기 페이지 return html
    @GetMapping("/board/write")
    public String bWrite() {
        return "/board/write";
    }

    // 글 상세페이지 출력 return html
    @GetMapping("/board/detailpage")
    public String bDetail() {
        return "/board/detailpage";
    }

    // 글 수정 페이지 return html
    @GetMapping("/board/update")
    public String bUpdate() {
        return "/board/update";
    }

}