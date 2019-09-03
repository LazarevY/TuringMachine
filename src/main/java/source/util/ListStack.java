package source.util;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

public class ListStack<E> extends Vector<E> {
    public ListStack(){}

    public synchronized E peek(){
        int len = size();
        if(len <= 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public E push(E item){
        addElement(item);
        return item;
    }

    public E pop(){
        int len = size();
        if(len == 0)
            throw new EmptyStackException();
        E obj = peek();
        removeElementAt(len - 1);
        return obj;
    }

    public boolean empty(){
        return  size() == 0;
    }
}
