package StacksQueue;

public class Stack {
    private static final int DEFAULT_SIZE = 10;
    private int ptr=-1;
    private int[] data;
    public Stack(){
        this(DEFAULT_SIZE);
    }
    public Stack(int size){
        data = new int[size];
    }

    public boolean push(int num) throws Exception{
        System.out.println(this.data.length+" "+ptr);
        try{
            if(ptr==this.data.length-1){

                throw new StackException("Exceeds size of stack");
            }
            data[++ptr]=num;
            System.out.println(data[0]+"data");
            return true;
        }catch(StackException e){
            System.out.println(e+"ERRORR");
        }
        return false;
        
    }

    public boolean isEmpty(){
        return ptr==-1;
    }

    public int peak() throws Exception{
        if(isEmpty()){
            throw new StackException("Cannot peak from empty stack");
        }
        return data[ptr];
    }
     public int pop() throws Exception{
        if(isEmpty()){
            throw new StackException("Cannot pop from empty stack");
        }
        return data[ptr--];
    }
    
}
