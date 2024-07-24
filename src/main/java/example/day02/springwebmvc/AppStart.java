package example.day02.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트 애플리케이션의 시작점을 정의하는 클래스
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기 및 생성 자동 설정을 활성화
public class AppStart {
    public static void main(String[] args) {
        // 스프링 부트 애플리케이션을 시작하는 메소드
        SpringApplication.run(AppStart.class, args);
    }
}
