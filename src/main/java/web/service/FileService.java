// src\main\java\web\service\FileService.java

package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    // 1. 파일 업로드
    public String fileUpload(final MultipartFile multipartFile) throws IOException {
        // 첨부 파일의 실제 파일 이름 추출
        final String fileName = multipartFile.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        /*// 저장할 경로 만들기
        C:\Users\codemaster\Documents\workspace\springboot2\src\main\resources\static\ upload*/
        final String uploadPath = "C:\\Users\\codemaster\\Documents\\workspace\\springboot2\\src\\main\\resources\\static\\upload\\";
        // 저장할 경로와 파일명 합치기
        final String filePath = uploadPath + fileName;
        // 해당 경로로 설정한 파일 객체, transferTo(파일객체)
        final File file = new File(filePath);
        // 일반예외 무조건 발생함
        multipartFile.transferTo(file);

        return filePath;
    }
}
