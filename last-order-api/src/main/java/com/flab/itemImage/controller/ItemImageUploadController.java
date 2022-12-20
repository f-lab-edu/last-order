package com.flab.itemImage.controller;

import com.flab.itemImage.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ItemImageUploadController {

    private final S3Upload s3Upload;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("images") MultipartFile multipartFile, @RequestParam Long itemId) throws IOException {
        return s3Upload.upload(multipartFile, itemId);
    }
}
