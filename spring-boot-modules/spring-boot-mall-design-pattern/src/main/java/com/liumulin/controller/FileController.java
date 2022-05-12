package com.liumulin.controller;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    public static final String ENDPOINT = "http://127.0.0.1:9000";
    public static final String BUCKET = "bucket1";
    @Resource
    private MinioClient minioClient;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("shit3");
        // 上传
        String path = UUID.randomUUID().toString(); // 文件名，使用 UUID 随机
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(BUCKET) // 存储桶
                .object(path) // 文件名
                .stream(file.getInputStream(), file.getSize(), -1) // 文件内容
                .contentType(file.getContentType()) // 文件类型
                .build());
        // 拼接路径
        return String.format("%s/%s/%s", ENDPOINT, BUCKET, path);
    }

    /**
     * 删除文件
     */
    @DeleteMapping("/delete")
    public void delete(@RequestParam("path") String path) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(BUCKET) // 存储桶
                .object(path) // 文件名
                .build());
    }

}
