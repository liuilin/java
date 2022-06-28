package com.liumulin.upload;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云文件上传
 *
 * @author liuqiang
 * @since 2022-05-12
 */
@Component(value = "aliyunOSSFileUpload")
//@Component(value = "aliyun")
public class AliyunOSSFileUpload implements FileUpload {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKey}")
    private String accessKey;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.key}")
    private String key;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.url}")
    private String url;

    /****
     * 文件上传
     *  文件类型如果是图片，则上传到本地FastDFS
     *  文件类型如果是视频，则上传到aliyun OSS
     */
    @Override
    public String upload(MultipartFile file) {

        String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fullName = UUID.randomUUID() + "." + extName;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, accessKeySecret);
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key + fullName, new ByteArrayInputStream(file.));
        // 上传字符串。
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        String fileExtension = Files.getFileExtension(fullName);
//        objectMetadata.setContentType(file.getContentType("." + extName));
//        putObjectRequest.setMetadata(objectMetadata);
//        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return url + fullName;
    }
}

