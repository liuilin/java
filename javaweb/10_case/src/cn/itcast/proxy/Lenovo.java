package cn.itcast.proxy;

/**
 * @author Gakki
 * @date 2018/11/23 - 15:07
 */
public class Lenovo implements SaleComputer {
    @Override
    public String saleComputer(double money) {
        System.out.println("花了" + money + "买了电脑");
        return "联想电脑";
    }

    @Override
    public void show() {

    }
}
