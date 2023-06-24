package LinkedList;

public class DLL {
    private Node head;
    private int size;
    public DLL(){
        this.size = 0;
    }
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }


    }

    public int insertFirst(int value){
        Node node = new Node(value);
        if(head==null){
            head = node;
            return ++size;
        }
        node.next=head;
        head.prev=node;
        head=node;
        return ++size;
    }
    public int insertLast(int value){
        if(size==0) return insertFirst(value);
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node node = new Node(value, null, temp);
        temp.next=node;
        return ++size;

    }
    public int insert(int value,int index){
        if(index==0) return insertFirst(value);
        if(index==size) return insertLast(value);
        Node temp = head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node = new Node(value, temp.next, temp);
        temp.next.prev=node;
        temp.next=node;

        return ++size;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayBothEnds(){
        Node temp = head;
        Node last = null;
        while(temp!=null){
            System.out.print(temp.value + "->");
            last = temp;
            temp=temp.next;
        }
        System.out.println("null");
        while(last!=null){
            System.out.print(last.value+"<-");
            last=last.prev;
        }
        System.out.println("head");
    }
    public int removeFirst(){
        int value = head.value;
        if(head.next==null) {
            head = null; 
            return value;
        }
        head.next.prev=null;
        Node node = head.next;
        head.next=null;
        head = node;
        return value;
    }
    public int removeLast(){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        if(temp.prev!=null){
            temp.prev.next=null;
            temp.prev=null;
        }else{
            head=null;
        }
        
        return temp.value;
    }
    public int remove(int index){
        if(index==0) return removeFirst();
        if(index==size-1) return removeLast();
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return temp.value;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
