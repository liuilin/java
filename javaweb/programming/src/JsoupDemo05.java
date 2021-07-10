import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/10 - 15:03
 */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
//        * 步骤：
//        1. 导入jar包
//        2. 获取Document对象
//        3. 获取对应的标签Element对象
//        4. 获取数据

        //2.获取document对象，根据xml文档获得
        //2.1获取student.xml的path
        String path = JsoupDemo05.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        System.out.println(document.select("name"));
        System.out.println("----------");
        //4.查询id值为itcast的元素
        System.out.println(document.select("#itcast"));
        System.out.println("----------");
        //5.1.获取student标签并且number属性值为heima_0001
        System.out.println(document.select("student[number=\"heima_0001\"]"));
        System.out.println("----------");
        //5.2获取student标签并且number属性值为heima_0001的age子标签
        System.out.println(document.select("student[number='heima_0001'] > age"));
    }

}