// src\main\java\web\service\FileService.java

package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    // 1. 파일 업로드
    public String fileUpload(final MultipartFile multipartFile) throws IOException {
        // 첨부 파일의 실제 파일 이름 추출
        // 클라이언트(유저)들이 서로 다른 파일내용의 같은 파일명으로 업로드 했을때 식별이 불가능
        // 해결방안 : 1. UUID, 2. 조합식별설계(주로 업로드 날짜/시간)
        final String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        final String originalFileName = multipartFile.getOriginalFilename();
        // UUID + 파일명 합치기, uuid와 파일명 구분하는 문자 조합, 파일명의 _(언더바)가 존재하면 안된다.
        // 추후에 _(언더바) 기준으로 분해하면 [0]UUID, [1]순수파일명임 
        // "문자열".replaceAll("기존문자", "새로운문자"): 만약에 문자열내 기존문자가 존재하면 새로운 문자로 치환해서 반환
        final String fileName = uuid + "_" + (originalFileName != null ? originalFileName.replaceAll("_", "-") : null); // '_'는 구분자로 사용하지 않음
        // 왜냐하면, uuid랑 파일명이랑 구분하기 위해서
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

        return fileName; // 파일명만 반환
    }
}
