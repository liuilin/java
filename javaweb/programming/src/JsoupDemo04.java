import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/10 - 15:03
 */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
//        * 步骤：
//        1. 导入jar包
//        2. 获取Document对象
//        3. 获取对应的标签Element对象
//        4. 获取数据

        //2.获取document对象，根据xml文档获得
        //2.1获取student.xml的path
        String path = JsoupDemo04.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        /*Element：元素对象
        1. 获取子元素对象
                * getElementById​(String id)：根据id属性值获取唯一的element对象
                * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
                * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
                * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

        2. 获取属性值
                * String attr(String key)：根据属性名称获取属性值
        3. 获取文本内容
                * String text():获取所有字标签的纯文本内容
                * String html():获取标签体的所有内容(包括子标签的标签和文本内容)*/

        //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
        System.out.println(document.getElementsByTag("name"));
        System.out.println("----------");
        //通过Element对象获取子标签对象
        Element element = document.getElementsByTag("student").get(0);
        Elements elements = element.getElementsByTag("name");
        System.out.println(elements);
        System.out.println("----------");
        //获取student对象的属性值
        System.out.println(element.attr("id"));

        //获取文本内容
        System.out.println(element.html());
        System.out.println(element.text());
    }

}