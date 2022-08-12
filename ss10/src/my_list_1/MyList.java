package my_list_1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAUT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAUT_CAPACITY];
    }
    public MyList(int size){
        elements = new Object[size];
    }
    public void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E e, int index){
        if(index >= 0 && index <= size){
            size += 1;
            ensureCapa();
            for(int i = size - 2; i >= index; i--){
                elements[i + 1] = elements[i];
            }
            elements[index] =e;
            return true;
        }
        return false;
    }
    public boolean remove(int index){
        if(index >= 0 && index <= size){
            size += 1;
            ensureCapa();
            for(int i = index; i < size; i++){
                elements[i] = elements[i + 1];
            }
            size --;
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public MyList clone(){
        MyList<Object> clone = new MyList<>(elements.length);
        for(Object x : elements){
            clone.add(x);
        }
        return clone;
    }
    public boolean contains(E e){
        for(Object x : elements){
            if(e.equals(x)){
                return true;
            }
        }
        return false;
    }
    public int indexof(E e){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    public void add(E e){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) elements[index];
        }
        return null;
    }
    public void clear(){
        elements = new Object[DEFAUT_CAPACITY];
        size = 0;
    }
    public Object[] getData(){
        return this.elements;
    }

}
