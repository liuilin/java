package com.liumulin.upload;

import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 文件上传接口
 *
 * @author liuqiang
 * @since 2022-05-12
 */
public interface FileUpload {
//    /**
//     * 文件上传
//     *
//     * @param buffers 文件字节数组
//     * @param extName 后缀名
//     * @return
//     */
//    String upload(byte[] buffers, String extName);

    String upload(MultipartFile file) throws Exception;

//    String upload(File file);
//
//    /**
//     * 删除文件
//     *
//     * @param fileName 文件名
//     */
//    void delete(String fileName);
}
