package basic01.test;

/**
 * @author Mugen 2019/3/29
 */
public class Singleton {

    //懒汉式
    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) instance = new Singleton();
            }
        }
        return instance;
    }




    /*//饿汉式
    private Singleton(){}

    private static final Singleton SINGLETON = new Singleton();

    public static Singleton getInstance() {
        return SINGLETON;
    }*/
}