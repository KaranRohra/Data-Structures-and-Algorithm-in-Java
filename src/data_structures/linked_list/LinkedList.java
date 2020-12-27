package data_structures.linked_list;

interface LinkedListADT<T>{
    void add(T data);
    void add(int index,T data);
    T remove();
    T remove(int index);
}
public class LinkedList<T> implements LinkedListADT<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

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
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public String toString() {
        if(size==0)
            return "[]";
        if(size==1){
            return "[" +head.data + "]";
        }
       StringBuilder allElements=new StringBuilder();
       Node<T> p=head;
       allElements.append('[');
       for(int i=0;i<size-1;i++){
           allElements.append(p.data).append(',');
           p=p.next;
       }
       allElements.append(p.data).append(']');
       return String.valueOf(allElements);
    }

}
