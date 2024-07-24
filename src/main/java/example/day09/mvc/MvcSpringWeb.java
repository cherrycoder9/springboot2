package example.day09.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MvcSpringWeb {
    public static void main(final String[] args) {
        SpringApplication.run(MvcSpringWeb.class, args);

    }
}

// view : resources 폴더 안에 있는 html, css, js 등

@RestController
class MvcSpringWebController {
    @Autowired
    MvcSpringWebService serv;

}

@Service
class MvcSpringWebService {
    @Autowired
    MvcSpringWebDao dao;

}

@Component
class MvcSpringWebDao {

}