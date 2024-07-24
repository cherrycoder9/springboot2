package example.day06.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HttpTestStart {
    public static void main(String[] args) {
        SpringApplication.run(HttpTestStart.class);
    }
}
