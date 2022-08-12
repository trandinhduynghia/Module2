package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> stack;

    public Stack(){
        stack = new LinkedList<>();
    }
    public void push(T element){
        stack.addFirst(element);
    }

    public T pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public boolean isEmty(){
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}
