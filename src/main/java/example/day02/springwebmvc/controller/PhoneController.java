package example.day02.springwebmvc.controller;

import example.day02.springwebmvc.model.dao.PhoneDao;
import example.day02.springwebmvc.model.dto.PhoneDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// 웹/인터넷 이용한 통신 환경 구축 (JS랑 통신하기 위해서)
@RestController // 해당 클래스는 Spring MVC 컨트롤러 역할을 함
public class PhoneController {

    // 아래 코드는 싱글톤 패턴을 사용하여 객체를 관리하는 예시 (현재는 사용하지 않음)
    // 스프링에서는 자체적으로 객체를 관리하는 기능을 제공함 (RestController 어노테이션을 사용)
    // private static final PhoneController phoneController = new PhoneController();
    //
    // private PhoneController() {
    // }
    //
    // public static PhoneController getInstance() {
    //     return phoneController;
    // }

    // 새로운 전화번호 정보를 생성하는 엔드포인트
    @PostMapping("/phone/create") // HTTP 메소드: POST, URL: http://localhost:8080/phone/create
    public boolean postPhone(@RequestBody PhoneDto phoneDto) {
        System.out.println("----------- postPhone 컨트롤 통신 -----------");
        System.out.println("phoneDto = " + phoneDto);
        return PhoneDao.getInstance().postPhone(phoneDto);
    }

    // 저장된 전화번호 정보를 읽어오는 엔드포인트
    @GetMapping("/phone/read") // HTTP 메소드: GET, URL: http://localhost:8080/phone/read
    public ArrayList<PhoneDto> getPhone() {
        System.out.println("----------- getPhone 컨트롤 통신 -----------");
        return PhoneDao.getInstance().getPhone();
    }
}
