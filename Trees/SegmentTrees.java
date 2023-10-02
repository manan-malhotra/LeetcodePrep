/**
 * The SegmentTrees class is a Java implementation of a segment tree data structure, which supports
 * efficient range queries and updates on an array.
 */
package Trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class SegmentTrees{
    private class Node{
        int val;
        int start;
        int end;
        Node left;
        Node right;
        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    Node root;
    public SegmentTrees(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }
    public int query(int qsi, int qei){
        return query(this.root,qsi, qei);
    }
    /**
     * The function performs a query on a binary tree node to find the sum of values within a given
     * range.
     * 
     * @param node The current node being processed in the recursive function.
     * @param qsi The parameter "qsi" stands for "query start index". It represents the starting index
     * of the range for which we want to perform the query.
     * @param qei The parameter "qei" stands for "query end index". It represents the ending index of
     * the range for which we want to perform the query.
     * @return The method is returning an integer value.
     */
    private int query(Node node,int qsi, int qei){
        if(node.end<qsi || node.start>qei) return 0;
        if(node.end<=qei && node.start>=qsi) return node.val;
        return query(node.left,qsi,qei)+query(node.right, qsi, qei);
    }
    public Node update(int index, int value){
        return update(this.root, index, value);
    }
    /**
     * The function updates the value of a node in a binary tree and returns the updated node.
     * 
     * @param node The current node being processed in the recursive function.
     * @param index The index parameter represents the index of the node that needs to be updated with
     * the new value.
     * @param value The value is the new value that you want to update at the given index.
     * @return The method is returning a Node object.
     */
    private Node update(Node node, int index, int value){
        if(node.start==node.end && node.start==index){
            node.val = value;
            return node;
        } 
        if(index<node.start || index>node.end){
            return node;
        }else{
            int left = update(node.left, index, value).val;
            int right = update(node.right, index, value).val;
            node.val = left+right;
            return node;
        }
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        if(node==null) return;
        System.out.println("Node starts from: "+node.start+" till "+node.end+" and data is: "+node.val);
        display(node.left);
        display(node.right);
    }
    /**
     * The function constructs a binary tree from an array of integers by recursively dividing the
     * array into halves and assigning the sum of the values of the left and right child nodes to the
     * parent node.
     * 
     * @param arr The input array from which the binary tree is constructed.
     * @param start The starting index of the array segment that we are currently constructing the tree
     * for.
     * @param end The "end" parameter represents the index of the last element in the current subarray
     * being considered.
     * @return The method is returning a Node object.
     */
    private Node constructTree(int[] arr, int start, int end) {
        if(start==end){
            // leaf node
            Node leaf = new Node(start, end);
            leaf.val = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end)/2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);
        node.val = node.left.val + node.right.val;
        
        return node;
    }
    public static void main(String[] args) {
        // int[] arr = {3,8,7,6,-2,-8,4,9};
        // SegmentTrees tree = new SegmentTrees(arr);
        // System.out.println(tree);
        // tree.display();
        // System.out.println(tree.query(0, 2));
        // tree.update( 0, 0);
        // System.out.println("\n");
        // // tree.display();
        // System.out.println(tree.query(0, 2));
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(4);
        b.add(5);
        b.add(6);
        b.add(1);

        a.addAll(b);
        System.out.println(a);
        for(int i=0;i<a.size();i++){
            if(a.get(i)>4){
                a.remove(i);
                i--;
            }
        }
        System.out.println(a);
        int arr[] = {5,10,17,2};
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();
        boolean even = true;
        for(int i:arr){
            addNum(i,small,large,even);
            System.out.println(findMedian(small,large,!even));
            even = !even;
        }

        // heap.add(2);
        // heap.add(5);
        // heap.add(7);
        // heap.add(1);
        // heap.add(8);
        // // heap.poll();
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.size());
        // System.out.println(heap);
        
    }
    private static double findMedian(PriorityQueue<Integer> small, PriorityQueue<Integer> large,boolean even) {
        if(even) return (small.peek()+large.peek())/2.0;
        return small.peek();
    }
    private static void addNum(int num, PriorityQueue<Integer> small, PriorityQueue<Integer> large, boolean even) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
    }
}