package data_structures.linked_list;

class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;
    Node(T data){
        this.data=data;
    }
}
