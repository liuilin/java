package cn.itcast.proxy;

/**
 * @author Gakki
 * @date 2018/11/23 - 15:04
 */
public interface SaleComputer {
    /**
     * 卖电脑
     * @param money
     * @return
     */
    String saleComputer(double money);

    /**
     * 展示电脑
     */
    void show();
}
