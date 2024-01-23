package Heap;

import java.util.ArrayList;
import java.util.List;

class Heap{
    private List<Integer> h;
    public Heap(){
         h = new ArrayList<>();
    }
    public void insert(int a){
        h.add(a);
        bottomup(h.size()-1);
    }
    public int remove(){
        if(h.isEmpty()) return -1;
        int temp = h.get(0);
        swap(0, h.size()-1);
        h.remove(h.size()-1);
        topDown(0);
        return temp;
    }
    public boolean isEmpty(){
        return h.isEmpty();
    }
    private void topDown(int i) {
        
        if(i>=h.size()) return;
        int left = left(i);
        int right = right(i);
        int min = i;
        
        if(left<h.size()-1 && h.get(left)<h.get(min)){
            min = left;
        }
        if(left<h.size()-1 && h.get(right)<h.get(min)){
            min = right;
        }
        if(i!=min){
            swap(i, min);
            topDown(min);
        }
        
    }
    private void bottomup(int i) {
        System.out.println("Called for "+h.get(i));
        if(i==0) return;
        if(h.get(i)<h.get(parent(i))){
            System.out.println("test");
            swap(i,parent(i));
            bottomup(parent(i));
        }
    }
    private void swap(int i, int parent) {
        int temp = h.get(i);
        h.set(i,h.get(parent));
        h.set(parent, temp);
    }
    public int parent(int index){
        return (index-1)/2;
    }
    public int left(int index){
        return index*2 + 1;
    }
    public int right(int index){
        return index*2 + 2;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i:h){
            s.append(i+" ");
        }
        return s.toString();
    }
}