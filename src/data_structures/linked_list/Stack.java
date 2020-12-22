package data_structures.linked_list;

interface StackADT<T>{
    boolean push(T key);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
public final class Stack <T> implements StackADT<T> {
    private Node<T> top;
    private int size;

    public Stack(){
        top=null;
        size=0;
    }

    @Override
    public boolean push(T key){
        Node<T> toPush=new Node<>(key);
        toPush.next=top;
        top=toPush;
        size++;
        return true;
    }

    @Override
    public T pop(){
        if(top==null){
            System.out.println("Stack is Empty");
            return null;
        }
        T key=top.data;
        top=top.next;
        size--;
        return key;
    }

    @Override
    public T peek() {
        if(top==null) {
            System.out.println("Stack is Empty");
            return null;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
