import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static JsoupDemo.src.main.java.com.jsoup.spider.HtmlSpider.htmlSpider;

/**
 * @author Gakki
 * @date 2018/11/10 - 22:57
 */
public class HtmlSpider {
    public static void main(String[] args) throws IOException {
//        思路：
//        1)	获得网页源码
//        2)	网页源代码字符串，解析字符串，然后就开始截取

        String keywords = "微软电脑";
        String searchUrl = "https://search.jd.com/Search?keyword=" + keywords + "&enc=utf-8&wq=" + keywords + "&pvid=84dfd7e3177149fb9af368d78dda403b";
        Document document = Jsoup.connect(searchUrl).get();
//        Document document = Jsoup.parse(new File(searchUrl), "utf-8");

        Elements elements = document.select("#J_goodsList ul li");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i).select(".p-img a").get(0);
            String href = element.attr("href");
            list.add(href);
        }

        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            htmlSpider(list.get(i));
        }

    }

    public  static void htmlSpider(String url) throws IOException {
        Document document = Jsoup.connect("http:" + url).get();
        Elements elements = document.select("#detail .parameter2.p-parameter-list li");
        /*Map<String, String> map = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            String s = elements.get(i).text();
            String[] strings = s.split("：");
            map.put(strings[0], strings[1]);
        }*/
        ArrayList<String> list = new ArrayList<>();
        String s = elements.text();
        list.add(s);
        System.out.println(list);
//        System.out.println(map);
    }
}
