import cn.hutool.http.HttpUtil;

/**
 * @author Daniel Liu 2020/2/27 6:57
 */
public class HttpTest {
    public static void main(String[] args) {
        String url = "http://apis.juhe.cn/simpleWeather/query?city=%E8%8B%8F%E5%B7%9E&key=d9e6ef85f87d7ec04935fbde38b7dc44";
//        //链式构建请求
//        String result2 = HttpRequest.get(url)
//                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
////                .form(paramMap)//表单内容
//                .timeout(20000)//超时，毫秒
//                .execute().body();
//        Console.log(result2);
        String content = HttpUtil.get(url);
        System.out.println("content = " + content);
    }
}