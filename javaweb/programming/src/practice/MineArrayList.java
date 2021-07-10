package practice;

/**
 * @author Gakki
 * @date 2018/10/25 - 22:56
 */
public class MineArrayList<E> {
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

    public int size() {
        return size;
    }

    public MineArrayList() {
        obj = new Object[10];
    }


    public E set(int index, E e) {
//        E oldValue = (E) obj[index];
        Object oldValue = obj[index];
        obj[index] = e;
        return (E) oldValue;
    }


    public boolean add(E e) {
        checkRange();
        obj[size++] = e;
        return true;
    }

    private void checkRange() {
        //obj.length数组长度
        //size已有元素个数
        if (size + 1 > obj.length) {
            Object[] newArr = new Object[size + 10];
            System.arraycopy(obj, 0, newArr, 0, obj.length);
            obj = newArr;
        }
    }




    /*public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    private E remove(int index) {
        E old = (E) obj[index];

        for (int i = index; i < size - 1; i++) {
            obj[i] = obj[i + 1];
        }
        obj[size - 1] = null;
        size--;
        return old;
    }*/


    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E remove(int index) {
        E oldValue = (E) obj[index];
        for (int i = index; i < size - 1; i++) {
            obj[i] = obj[i + 1];
        }
        obj[size - 1] = null;
        size--;
        return oldValue;
    }

    private int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


//    E remove(int index)


    public E get(int i) {
        return (E) obj[i];
    }


}
