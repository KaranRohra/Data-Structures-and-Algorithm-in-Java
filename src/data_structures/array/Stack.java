package data_structures.array;

interface StackADT<T>{
    boolean push(T key);
    T pop();
    T peek();
    boolean isFull();
    boolean isEmpty();
    int size();
}
public final class Stack <T> implements StackADT<T>{
    private int top;
    private final T[] stackArray;
    private int size;
    private final int MAX=100;

    @SuppressWarnings("unchecked")
    public Stack(){
        top=-1;
        size=0;
        //creating generics array at runtime
        stackArray= (T[]) new Object[MAX];
    }

    @Override
    public boolean push(T key){
        if(top==MAX-1) {
            System.out.println("Stack is Full");
            return false;
        }
        top++;
        stackArray[top]=key;
        size++;
        return true;
    }

    @Override
    public T pop(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return null;
        }
        T key=stackArray[top];
        top--;
        size--;
        return key;
    }

    @Override
    public T peek() {
        if(top==-1) {
            System.out.println("Stack is Empty");
            return null;
        }
        return stackArray[top];
    }

    @Override
    public boolean isFull() {
        return size==MAX;
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
