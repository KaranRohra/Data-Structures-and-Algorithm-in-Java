package data_structures.linked_list;

interface LinkedListADT<T>{
    void add(T data);
    void add(int index,T data);
    T remove();
    T remove(int index);
    boolean isEmpty();
    int size();

}
public class LinkedList<T> implements LinkedListADT<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T data){
        Node<T> toInsert=new Node<>(data);
        if(head==null)
            head=toInsert;
        else {
            tail.next=toInsert;
            toInsert.prev=tail;
        }
        tail=toInsert;
        size++;
    }

    @Override
    public void add(int index,T data){
        Node<T> toInsert=new Node<>(data);

        Node<T> p=head,prev=null;
        int i;
        for(i=0;i<size && i<index;i++){
            prev=p;
            p=p.next;
        }
        if(p==null && i<index || index<0){
            throw new ArrayIndexOutOfBoundsException("Index ".concat(String.valueOf(index)).concat(" out of bounds for length ").concat(String.valueOf(size)));
        }
        toInsert.next=p;
        toInsert.prev=prev;

        if(prev!=null)
            prev.next=toInsert;
        else {
            if(head!=null)
                head.prev=toInsert;
            head = toInsert;
        }

        if(p!=null)
            p.prev=toInsert;
        else{
            if (tail!=null)
                tail.next=toInsert;
            tail=toInsert;
        }
        size++;
    }

    @Override
    public T remove() {
        if(head==null) {
            System.out.println("Linked list is Empty");
            return null;
        }
        Node<T> data=tail;
        tail=tail.prev;
        if(tail==null)
            head=null;
        size--;
        return data.data;
    }

    @Override
    public T remove(int index) {
        if(head==null) {
            System.out.println("Linked list is Empty");
            return null;
        }
        if(index>=size){
            System.out.println("Invalid index");
            return null;
        }
        Node<T> p=head;
        int i=0;
        while (i!=index){
            p=p.next;
            i++;
        }
        Node<T> prevOfP=p.prev;
        Node<T> aheadOfP=p.next;

        if(prevOfP==null){
            head=head.next;
            if(head!=null)
                head.prev=null;
        }
        if(aheadOfP==null){
            tail=tail.prev;
            if(tail!=null)
                tail.next=null;
        }
        if(prevOfP!=null && aheadOfP!=null){
            prevOfP.next=aheadOfP;
            aheadOfP.prev=prevOfP;
        }

        p.next=null;
        p.prev=null;
        size--;
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return new ToStringClass().toString(size,head);
    }
}
