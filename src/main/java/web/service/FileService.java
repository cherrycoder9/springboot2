// src\main\java\web\service\FileService.java

package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {
    private static final String UPLOAD_DIR = "C:\\Users\\codemaster\\Documents\\workspace\\springboot2\\src\\main\\resources\\static\\upload\\";

    public String fileUpload(final MultipartFile multipartFile) throws IOException {
        System.out.println("FileService.fileUpload");

        final String uuid = UUID.randomUUID().toString();
        final String originalFileName = multipartFile.getOriginalFilename();
        final String fileName = uuid + "_" + (originalFileName != null ? originalFileName.replaceAll("_", "-") : "unknown");

        System.out.println("생성된 파일명: " + fileName);

        final File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            final boolean dirCreated = uploadDir.mkdirs();
            if (dirCreated) {
                System.out.println("업로드 디렉토리 생성 성공: " + uploadDir.getAbsolutePath());
            } else {
                System.out.println("업로드 디렉토리 생성 실패: " + uploadDir.getAbsolutePath());
                throw new IOException("업로드 디렉토리를 생성할 수 없습니다.");
            }
        }

        final File destFile = new File(uploadDir, fileName);
        multipartFile.transferTo(destFile);

        System.out.println("파일 업로드 성공: " + destFile.getAbsolutePath());

        return fileName;
    }
}