import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/10 - 15:03
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
//        * 步骤：
//        1. 导入jar包
//        2. 获取Document对象
//        3. 获取对应的标签Element对象
//        4. 获取数据

        //2.获取document对象，根据xml文档获得
        //2.1获取student.xml的path
        String path = JsoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象了。
        //3.1获取所有student对象
        System.out.println(document.getElementsByTag("student"));
        System.out.println("-------------");
        //3.2 获取属性名为id的元素对象们
        System.out.println(document.getElementsByAttribute("id"));
        System.out.println("-------------");
        //3.2获取 number属性值为heima_0001的元素对象
        System.out.println(document.getElementsByAttributeValue("number", "heima_0001"));
        System.out.println("-------------");
        //3.3获取id属性值的元素对象
        System.out.println(document.getElementById("heima_0002"));
    }
}
