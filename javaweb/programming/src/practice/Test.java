package practice;

import java.util.ArrayList;

/**
 * @author Gakki
 * @date 2018/10/25 - 23:09
 */
public class Test {
    public static void main(String[] args){
//        ArrayList<Object> list = new ArrayList<>();
//        practice.MyArrayList<Object> list = new practice.MyArrayList<>();
        MineArrayList<Object> list = new MineArrayList<>();
        list.add("a");
        list.add("b");
        list.add(1);
        list.add("c");
        list.add("d");

        System.out.println(list.set(0, 1));
        System.out.println(list.remove("a"));

        System.out.println(list.remove(3));

//        System.out.println(list);
//        System.out.println(list.get(0));
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/



    }
}
