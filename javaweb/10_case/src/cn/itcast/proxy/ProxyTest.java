package cn.itcast.proxy;

/**
 * @author Gakki
 * @date 2018/11/23 - 15:11
 */
public class ProxyTest  {
    public static void main(String[] args){
        //创建正式对象
        Lenovo lenovo = new Lenovo();

        String computer = lenovo.saleComputer(8000);
        System.out.println(computer);
    }
}
