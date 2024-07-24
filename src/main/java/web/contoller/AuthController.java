package web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService = new AuthService();

    // 인증번호 생성 요청 controller
    @GetMapping("code")
    public boolean generateCode(final String email) {
        System.out.println("AuthController.generateCode");
        System.out.println("Controller email = " + email);
        return authService.generateCode(email);
    }

    // 인증번호 입력값 검증 controller
    @PostMapping("check")
    public boolean checkCode(final String authCodeInput) {
        System.out.println("AuthController.checkCode");
        return authService.checkCode(authCodeInput);
    }
}
