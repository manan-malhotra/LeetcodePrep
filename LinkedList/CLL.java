package LinkedList;

public class CLL {
    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node prev, Node next){
            this.value=value;
            this.prev=prev;
            this.next=next;
        }
    }
    
    public void insertFirst(int value){
        Node node = new Node(value);
        if(head==null){
            head = node;
            tail = node;
            head.next=tail;
            tail.prev=head;
            return;
        }
        head.prev=node;
        node.next=head;
        tail.next=node;
        node.prev=tail;
        head = node;
        return;
    }
    public void display(){
        if(head==null){
            System.out.println("null");
            return;
        }
        Node temp = head;
        while(temp.next!=head){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println(temp.value+"->HEAD");
    }

}
