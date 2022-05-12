package com.liumulin.upload;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component(value = "minioFileUpload")
//@Component("minio")
public class MinioFileUpload implements FileUpload {

    @Value("${minio.endpoint}")
    public String endpoint;
    @Value("${minio.bucket}")
    public String bucket;
    @Resource
    private MinioClient minioClient;

//    /**
//     * 上传文件
//     */
//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
//        // 上传
//        String path = UUID.randomUUID().toString(); // 文件名，使用 UUID 随机
//        minioClient.putObject(PutObjectArgs.builder()
//                .bucket(bucket) // 存储桶
//                .object(path) // 文件名
//                .stream(file.getInputStream(), file.getSize(), -1) // 文件内容
//                .contentType(file.getContentType()) // 文件类型
//                .build());
//        // 拼接路径
//        return String.format("%s/%s/%s", endpoint, bucket, path);
//    }
//
//    /**
//     * 删除文件
//     */
//    @DeleteMapping("/delete")
//    public void delete(@RequestParam("name") String name) throws Exception {
//        minioClient.removeObject(RemoveObjectArgs.builder()
//                .bucket(bucket) // 存储桶
//                .object(name) // 文件名
//                .build());
//    }

    @Override
    public String upload(MultipartFile file) throws Exception{
        // 上传
        String path = UUID.randomUUID().toString(); // 文件名，使用 UUID 随机
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucket) // 存储桶
                .object(path) // 文件名
                .stream(file.getInputStream(), file.getSize(), -1) // 文件内容
                .contentType(file.getContentType()) // 文件类型
                .build());
        // 拼接路径
        return String.format("%s/%s/%s", endpoint, bucket, path);
    }
}
