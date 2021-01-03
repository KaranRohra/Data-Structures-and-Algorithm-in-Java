package data_structures.linked_list;

class ToStringClass {
    public String toString(int size,Node<?> p) {
        if(size==0)
            return "[]";
        if(size==1){
            return "[" +p.data + "]";
        }
        StringBuilder allElements=new StringBuilder();
        allElements.append('[');
        for(int i=0;i<size-1;i++){
            allElements.append(p.data).append(',');
            p=p.next;
        }
        allElements.append(p.data).append(']');
        return String.valueOf(allElements);
    }
}
