package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(){
        this(0);
    }
    public Node(int value){
        this.value=value;
    }

    public static void preOrder(Node node){
        if(node==null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void iterPreOrder(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
            System.out.println(temp.value);
        }
    }

    public static void iterInOrder(Node node){
        Stack<Node> stack = new Stack<>();
       while(true){
        if(node!=null) {
            stack.push(node);
            node=node.left;
        }else{
            if(!stack.isEmpty()){
                node=stack.pop();
                System.out.println(node.value);
                node=node.right;
            }else{
                break;
            }
        }
       }
    }

    public static void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void iterPostOrder(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if(node==null) return;
        stack.push(node);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            stack2.push(temp);
            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null) stack.push(temp.right);
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }

        
    }

    public static void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            if(queue.peek().left!=null){
                queue.add(queue.peek().left);
            }
            if(queue.peek().right!=null){
                queue.add(queue.peek().right);
            }
            System.out.println(queue.poll().value);
        }
    
    }
    public static void morrisPreOrder(Node node){
        if(node==null) return;
        Node curr = node;
        while(curr!=null){
            if(curr.left==null){
                System.out.println(curr.value);
                curr=curr.right;
            }else{
                Node temp = curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp = temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    System.out.println(curr.value);
                    curr=curr.left;
                }else{
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }
    }
    
}
