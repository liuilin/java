import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/10 - 15:03
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
//        * 步骤：
//        1. 导入jar包
//        2. 获取Document对象
//        3. 获取对应的标签Element对象
//        4. 获取数据

        //2.获取document对象，根据xml文档获得
        //2.1获取student.xml的path
        String path = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //3.1获取第一个name的Element对象
        System.out.println(elements.get(0));
        //3.2获取数据
        System.out.println(elements.text());
    }
}
