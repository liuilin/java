package cn.itcast.servletContext;

import cn.itcast.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gakki
 * @date 2018/11/17 - 8:28
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取请求参数的文件名
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        ServletContext servletContext = req.getServletContext();
//        String realPath = servletContext.getRealPath("/img/" + filename);
//        FileInputStream fis = new FileInputStream(realPath);
        InputStream is = servletContext.getResourceAsStream("/img/"+filename);
        //3.设置response响应头类型
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);

        //解决中文乱码
        String agent = req.getHeader("user-agent");
        //使用工具类方法编码文件名
        filename = DownLoadUtils.getFileName(agent, filename);

        resp.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = is.read(buff)) != -1) {
            sos.write(buff,0,len);
        }

        is.close();
        sos.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
