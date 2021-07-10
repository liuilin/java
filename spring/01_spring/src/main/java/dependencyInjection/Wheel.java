package dependencyInjection;

/**
 * @author Daniel Liu 2020/2/16 9:54
 */
public class Wheel {
    private Integer size;

    public Wheel(Integer size) {
        this.size = size;
        System.out.println("卧槽我是构造出的" + size);
    }

    public Wheel() {
        this.size = 30300;
        System.out.println("...." + size);
    }
}