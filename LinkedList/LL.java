package LinkedList;


public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public int insert(int val, int index){
        if(index==0){
            return insertFirst(val);
        }
        if(index==size){
            return insertLast(val);
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        return ++size;
    }
    public int insertFirst(int val){
        Node node = new Node(val,head);
        head = node;
        if(tail==null){
            tail = node;
        }
        size++;
        return size;
    }
    public int insertLast(int val){
        if(tail==null){
            return insertFirst(val);
        }
        Node node = new Node(val);
        tail.next=node;
        tail = node;
        return ++size;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int deleteFirst(){
       int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next=null;
        size--;
        return value;
    }
    public int delete(int index){
        if(index==0) return deleteFirst();
        if(index==size-1) return deleteLast();
        Node node = get(index-1);
        int value = node.next.value;
        node.next=node.next.next;
        size--;
        return value;
    }
    public Node find(int value){
        Node temp = head;
        while(temp.next!=null){
            if(temp.value==value){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}
