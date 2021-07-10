package cn.itcast.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Daniel Liu 2020/1/17 8:00
 */
@WebServlet( "/download" )
public class DownloadExercise extends HttpServlet {
    private final int ARBITARY_SIZE = 1024;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String filename = req.getParameter("filename");
        resp.setHeader("Content-disposition", "attachment; filename=" + filename);
        ServletContext servletContext = req.getServletContext();
        resp.setHeader("content-type", servletContext.getMimeType(filename));
        InputStream is = servletContext.getResourceAsStream("/img/" + filename);
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\" + filename));
        int len;
        byte[] buff = new byte[ARBITARY_SIZE];
        while ((len = is.read(buff)) != -1) {
            resp.getOutputStream().write(len);
//            bos.write(len);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}