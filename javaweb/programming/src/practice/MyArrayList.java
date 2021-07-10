package practice;

/**
 * @author Gakki
 * @date 2018/10/25 - 21:59
 */

public class MyArrayList<E> {

    /*
       模拟ArrayList
           底层就是数组的实现

           boolean add(E e)
           boolean remove(E e)
           E remove(int index)
           E get(int index)
           E set(int index, E e)

           String toString()

           迭代器
    */
    private Object[] obj;

    private int size;

    public MyArrayList() {
        obj = new Object[10];
    }

    public int size() {
        return size;
    }

    public E set(int index, E e) {
        E old = (E) obj[index];
        obj[index] = e;
        return old;
    }

    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    // a b c d  null
    // a c d null  null

    // 获取指定元素第一次出现的索引
    private int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        // 从index开始，把后续的所有元素向前挪动一位
        E old = (E) obj[index];

        for (int i = index; i < size - 1; i++) {
            obj[i] = obj[i + 1];
        }

        obj[size - 1] = null;
        size--;

        return old;
    }


    public E get(int index) {
        return (E) obj[index];
    }

    public boolean add(E e) {
        checkRange();
        obj[size++] = e;
        return true;
    }

    private void checkRange() {
        // obj.length 容器现有容量
        // size已经有的元素个数
        //  size + 1 目前需要的容量 > 现有的容量 则扩大数组容量
        if (size + 1 > obj.length) {
            Object[] newArray = new Object[size + 10]; // 在现有容量的基础上*1.5
            System.arraycopy(obj, 0, newArray, 0, size);
            obj = newArray;
        }
    }

    @Override
    public String toString() {
        // [a, b, c]
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(obj[i]);
            } else {
                sb.append(obj[i]).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}

