package LinkedList;

public class InsertInLinkedList {

    public static void main(String[] args) {
        LL list = new LL();
        System.out.println(list.isEmpty());
        list.insertLast(5);
        System.out.println(list.isEmpty());
        list.insertLast(6);
        list.insertLast(7);
        list.insertFirst(2);
        list.insert(3, 1);
        list.display();
        list.deleteFirst();
        list.deleteLast();
        list.display();
        list.delete(1);
        list.display();
        System.out.println("DLL");
        DLL dlist = new DLL();
        dlist.insertFirst(0);
        dlist.insertFirst(1);
        dlist.insertFirst(4);
        dlist.insertLast(7);
        dlist.insertLast(88);
        dlist.insert(9, 0);
        dlist.display();
        dlist.remove(4);
        dlist.display();
        System.out.println("CLL");
        CLL clist = new CLL();
        clist.insertFirst(4);
        clist.insertFirst(3);
        clist.insertFirst(2);
        clist.display();
    }
    
}
