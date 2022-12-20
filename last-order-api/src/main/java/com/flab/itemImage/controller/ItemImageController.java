package com.flab.itemImage.controller;

import com.flab.itemImage.domain.ItemImage;
import com.flab.itemImage.exception.ImageNotExistException;
import com.flab.itemImage.repository.ItemImageRepository;
import com.flab.itemImage.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ItemImageController {

    private final S3Upload s3Upload;

    private final ItemImageRepository itemImageRepository;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("images") MultipartFile multipartFile, @RequestParam Long itemId) throws IOException {
        return s3Upload.upload(multipartFile, itemId);
    }

    @GetMapping("/display/{id}")
    public String displayImage(@PathVariable Long id) {
        ItemImage itemImage = itemImageRepository.findById(id).orElseThrow(() -> new ImageNotExistException());
        return itemImage.getStoreImageName();
    }

}
