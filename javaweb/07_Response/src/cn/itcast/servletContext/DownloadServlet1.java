package cn.itcast.servletContext;


import cn.itcast.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gakki
 * @date 2018/11/16 - 15:01
 */
@WebServlet("/downloadServlet1")
public class DownloadServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** 文件下载需求：
         1. 页面显示超链接
         2. 点击超链接后弹出下载提示框
         3. 完成图片文件下载*/

        /*//设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        ServletContext servletContext = this.getServletContext();
        //2.1找到文件服务器路径
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes,0,len);
        }

        fis.close();*/


//        1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
//        2. 定义Servlet
//        1. 获取文件名称
        String filename = request.getParameter("filename");
//        2. 使用字节输入流加载文件进内存
        ServletContext servletContext = this.getServletContext();
//        String realPath = servletContext.getRealPath("img/"+filename);
//        FileInputStream fis = new FileInputStream(realPath);
        InputStream is = servletContext.getResourceAsStream("/img/" + filename);

//
//       3. 指定response的响应头： content-disposition:attachment;filename=xxx
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);

        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);


        response.setHeader("content-disposition", "attachment;filename=" + filename);


//        4. 将数据写出到response输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = is.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        is.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
