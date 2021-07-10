package JsoupDemo.src.main.java.com.jsoup.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlSpider {

    public static void main(String[] args) throws Exception {
        /*String keywords = "微软电脑";
        String searchUrl = "https://search.jd.com/Search?keyword=" + keywords + "&enc=utf-8&wq=" + keywords + "&pvid=84dfd7e3177149fb9af368d78dda403b";*/
        String keywords = "微软电脑";
        String searchUrl = "https://search.jd.com/Search?keyword=" + keywords + "&enc=utf-8&wq=" + keywords + "&pvid=84dfd7e3177149fb9af368d78dda403b";
        Document  doc = Jsoup.connect(searchUrl).get();
        Elements elements =  doc.select("#J_goodsList ul li");
        List<String> urlQueue = new ArrayList();
        for (int i = 0; i < elements.size(); i++) {
            Element aEle = elements.get(i).select(".p-img a").get(0);
            String itemUrl = aEle.attr("href");
            urlQueue.add(itemUrl);
        }
        for (int i = 0; i < urlQueue.size(); i++) {
            htmlSpider(urlQueue.get(i));
        }
    }

    /**
     * 根据url抓取网络内容
     * @param url
     * @throws Exception
     */
    public  static void htmlSpider(String url) throws Exception{

        //创建Document对象，这个doc对象就代表当前网页的源码
        Document doc = Jsoup.connect("http:"+url).get();
        // System.out.println(doc.html());打印源码
        //创建选择器
//       Elements eles =  doc.select("#InitCartUrl");
//       String str = eles.get(0).html();
//       System.out.println(str);
        Map<String,String> map = new HashMap<String,String>();
        Elements elements = doc.select("#detail .parameter2.p-parameter-list li");
        for (int i = 0; i < elements.size(); i++) {
            String str  =  elements.get(i).text();
            String[] strs = str.split("：");
            map.put(strs[0],strs[1]);
        }
        System.out.println(map);
    }
}
