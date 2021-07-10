package dependencyInjection;

/**
 * @author Daniel Liu 2020/2/16 9:55
 */
public class TestDI {
    public static void main(String[] args) {
//        Integer size=0;
        Wheel wheel = new Wheel();
        Bottom bottom = new Bottom(wheel);
        FrameWork frameWork = new FrameWork(bottom);
        Luggage luggage = new Luggage(frameWork);
        luggage.move();
    }
}