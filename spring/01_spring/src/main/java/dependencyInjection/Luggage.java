package dependencyInjection;

/**
 * @author Daniel Liu 2020/2/16 9:50
 */
public class Luggage {
    private FrameWork frameWork;

    public Luggage(FrameWork frameWork) {
        this.frameWork = frameWork;
    }

    public void move() {
        System.out.println("move " + frameWork);
    }
}