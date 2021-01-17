package data_structures.tree;

interface BinarySearchTreeADT<T>{
    void preorder();
    void inorder();
    void postorder();
    void bfs();

    boolean search(T key);
    void insert(T key);
    boolean delete(T key);
}
public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T>{
    Node<T> root;

    @Override
    public void preorder() {
        Traversals.preorder(root);
        System.out.println();
    }

    @Override
    public void inorder() {
        Traversals.inorder(root);
        System.out.println();
    }

    @Override
    public void postorder() {
        Traversals.postorder(root);
        System.out.println();
    }

    @Override
    public void bfs() {
        Traversals.bfs(root);
        System.out.println();
    }

    @Override
    public boolean search(T key) {
        Node<T> p=root;
        while (p!=null){
            if(p.data.compareTo(key)<0)
                p=p.right;
            else if(p.data.compareTo(key)>0)
                p=p.left;
            else
                return true;
        }
        return false;
    }

    @Override
    public void insert(T key) {
        Node<T> toInsert=new Node<>(key);

        Node<T> p=root;
        Node<T> followP=null;
        while (p!=null){
            followP=p;
            if(p.data.compareTo(key)<0)
                p=p.right;
            else if(p.data.compareTo(key)>=0)
                p=p.left;
        }
        if(root==null){
            root=toInsert;
        }
        else if(followP.data.compareTo(key)>0){
            followP.left=toInsert;
        }
        else{
            followP.right=toInsert;
        }
    }

    @Override
    public boolean delete(T key) {
        Node<T> p=root;
        Node<T> followP=null;
        while(p!=null){
            if(p.data.compareTo(key)<0) {
                followP=p;
                p = p.right;
            }
            else if(p.data.compareTo(key)>0) {
                followP=p;
                p = p.left;
            }
            else
                break;
        }
        if(p==null){
            return false;
        }

        if(p.left==null && p.right==null){
            if(followP==null){
                root=null;
            }
            else if(followP.left==p){
                followP.left=null;
            }
            else{
                followP.right=null;
            }
        }
        else if(p.left==null){
            if(followP==null){
                root=null;
            } else if(followP.left==p){
                followP.left=p.right;
            }
            else{
                followP.right=p.right;
            }
        }else  if(p.right==null){
            if(followP==null){
                root=null;
            } else if(followP.left==p){
                followP.left=p.left;
            }
            else{
                followP.right=p.left;
            }
        }else {
            Node<T> successor = p.right;
            followP=p;
            while (successor.left!=null){
                followP=successor;
                successor=successor.left;
            }
            T temp=successor.data;
            successor.data=p.data;
            p.data=temp;

            if(followP.right==successor){
                followP.right=successor.right;
            }else {
                followP.left = successor.right;
            }
        }
        return true;
    }
}
final class Traversals{
    static void preorder(Node<?> p){
        if(p==null)
            return;
        System.out.print(p.data+" ");
        preorder(p.left);
        preorder(p.right);
    }
    static void inorder(Node<?> p){
        if(p==null)
            return;
        inorder(p.left);
        System.out.print(p.data+" ");
        inorder(p.right);
    }
    static void postorder(Node<?> p){
        if(p==null)
            return;
        postorder(p.left);
        postorder(p.right);
        System.out.print(p.data+" ");
    }
    static void bfs(Node<?> p){

    }
}