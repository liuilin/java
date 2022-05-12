package com.liumulin.controller;

import com.liumulin.upload.FileUploadProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileUploadProxy fileUploadProxy;

    /***
     * 文件上传
     */
    @PostMapping(value = "/upload")
    public String upload(MultipartFile file) throws Exception {
        return fileUploadProxy.upload(file);
    }

}
