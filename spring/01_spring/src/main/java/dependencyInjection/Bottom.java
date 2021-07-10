package dependencyInjection;

/**
 * @author Daniel Liu 2020/2/16 9:52
 */
public class Bottom {
    private Wheel wheel;

    public Bottom(Wheel wheel) {
        this.wheel = wheel;
    }
}