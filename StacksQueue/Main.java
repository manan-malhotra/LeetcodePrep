package StacksQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Stack stack = new Stack(6);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(7);
        stack.push(8);
        stack.push(99);
        stack.push(00);
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peak());


    }
    
}
