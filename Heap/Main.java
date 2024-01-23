package Heap;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(4);
        heap.insert(6);
        heap.insert(5);
        heap.insert(1);
        heap.insert(15);
        heap.insert(11);
        heap.insert(17);
        heap.insert(10);
        heap.insert(-1);
        heap.insert(17);
        heap.insert(12);
        System.out.println(heap.toString());
        while(!heap.isEmpty()){
            System.out.print(heap.remove()+" ");
        }

    }
    
}
