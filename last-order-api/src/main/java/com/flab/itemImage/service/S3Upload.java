package com.flab.itemImage.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.flab.itemImage.domain.ItemImage;
import com.flab.itemImage.repository.ItemImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Upload {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    private final ItemImageRepository itemImageRepository;

    public String upload(MultipartFile multipartFile, Long itemId) throws IOException {
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        ItemImage itemImage = ItemImage.builder()
                .itemId(itemId)
                .uploadImageName(multipartFile.getOriginalFilename())
                .storeImageName(s3FileName).build();

        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentType(multipartFile.getContentType());
        objMeta.setContentLength(multipartFile.getInputStream().available());

        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);

        itemImageRepository.save(itemImage);

        return amazonS3.getUrl(bucket, s3FileName).toString();
    }
}
