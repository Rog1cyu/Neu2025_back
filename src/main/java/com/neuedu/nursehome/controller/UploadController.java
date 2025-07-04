package com.neuedu.nursehome.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Value("${upload.meal.path}")
    private String uploadPath;

    @Value("${upload.meal.urlPrefix}")
    private String urlPrefix;

    @PostMapping("/meal")
    public ResponseEntity<String> uploadMealImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("文件为空");
        }

        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        File dest = new File(uploadPath + filename);

        // 创建父级目录
        dest.getParentFile().mkdirs();

        try {
            file.transferTo(dest);
            return ResponseEntity.ok(urlPrefix + filename);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("上传失败: " + e.getMessage());
        }
    }
}
