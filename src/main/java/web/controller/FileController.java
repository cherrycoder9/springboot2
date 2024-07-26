// src\main\java\web\controller\FileController.java

package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {
    private static final String UPLOAD_DIR = "C:\\Users\\codemaster\\Documents\\workspace\\springboot2\\src\\main\\resources\\static\\upload\\";

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable final String filename) {
        try {
            final Path filePath = Paths.get(UPLOAD_DIR + filename);
            final Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                // 파일명을 안전하게 인코딩
                final String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
                final String contentDisposition = "attachment;filename=\"" + encodedFilename + "\"";

                final HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (final MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/{filename:.+}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> checkFileExists(@PathVariable final String filename) {
        System.out.println("FileController.checkFileExists");
        System.out.println("파일 존재 여부 확인: " + filename);
        final Path filePath = Paths.get(UPLOAD_DIR + filename);
        if (Files.exists(filePath) && Files.isReadable(filePath)) {
            System.out.println("파일 존재함: " + filePath.toAbsolutePath());
            return ResponseEntity.ok().build();
        } else {
            System.out.println("파일을 찾을 수 없습니다: " + filePath.toAbsolutePath());
            return ResponseEntity.notFound().build();
        }
    }
}