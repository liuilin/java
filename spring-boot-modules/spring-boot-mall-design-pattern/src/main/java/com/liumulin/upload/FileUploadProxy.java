package com.liumulin.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 文件上传代理类
 *
 * @author liuqiang
 * @since 2022-05-12
 */
@Component(value = "fileUploadProxy")
@ConfigurationProperties(prefix = "upload") // 对应 yml 里面的 map 配置
public class FileUploadProxy {

    @Autowired
    private ApplicationContext cxt;

    private Map<String, List<String>> filemap;

    //依赖注入
    public void setFileMap(Map<String, List<String>> fileMap) {
        this.filemap = fileMap;
    }

    /****
     * 文件上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file) throws Exception {
//        // 1.文件的字节数组
//        byte[] buffers = file.getBytes();

        // 2.文件的扩展名   1.jpg
        String fileName = file.getOriginalFilename();
        String extName = StringUtils.getFilenameExtension(fileName);    //jpg|mp4|png

        // 3.1 aliyunOSSFileUpload -----> mp4,avi
        // 3.2 MinIO -----> png,jpg,gif
        for (Map.Entry<String, List<String>> entry : filemap.entrySet()) {
            //获取后缀集合
            for (String suffix : entry.getValue()) {
                //循环迭代匹配后缀
                if (suffix.equalsIgnoreCase(extName)) {
                    return cxt.getBean(entry.getKey(), FileUpload.class).upload(file);
                }
            }
        }
        return null;
    }

}


