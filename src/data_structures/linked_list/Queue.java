package data_structures.linked_list;

interface QueueADT<T>{
    void add(T data);
    T remove();
    T getFirst();
    T getLast();
    boolean isEmpty();
    int size();

    void addLast(T data);
    T removeFirst();
}
public class Queue<T> implements QueueADT<T>{
    private Node<T> front;
    private Node<T> rear;
    private int size;

    @Override
    public void add(T data){
        Node<T> toInsert=new Node<>(data);
        if(front==null)
            front=toInsert;
        else
            rear.next=toInsert;
        size++;
        rear=toInsert;
    }

    @Override
    public T remove(){
        if(front==null)
            return null;
        Node<T> toDelete=front;
        front=front.next;
        if(front==null)
            rear=null;

        toDelete.next=null;
        size--;
        return toDelete.data;
    }

    @Override
    public T getFirst() {
        return front.data;
    }

    @Override
    public T getLast() {
        return rear.data;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addLast(T data){
        add(data);
    }

    @Override
    public T removeFirst() {
        return remove();
    }
}
