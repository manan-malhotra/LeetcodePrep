package LinkedList;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        
       // The code is creating an instance of the `ICar` class and assigning it to a variable `engine`
       // of type `Engine`.
        Engine engine = new ICar();
        
        engine.start();
        System.out.println(engine.CC);
        ((ICar) engine).brake();
        System.out.println(engine.hp);
        Stack<Character> stack = new Stack();
        stack.push('{');
        
        
    }
    
}

class ICar implements Brake,Engine{

    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Start");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("Stop");
    }

    @Override
    public void brake() {
        // TODO Auto-generated method stub
        System.out.println("Brake");
    }

}


abstract class Vehicle{
    String name ;
    public abstract void call();
    
     public String toString(){
        return "dfsdf";
    }
    Vehicle(String name){
        this.name=name;
    }
    
    
}
abstract class Car extends Vehicle{
    int tyre;
    
    Car(int tyre,String name){
        super(name);
        this.tyre = tyre;
    }

    @Override
    public abstract void call();
    
}
class Honda extends Car{
    static String brand;
    
    public String toString(){
        return "Tests";
    }
    Honda(int tyre,String name,String brand){
        super(tyre,name);  
    }
    @Override
    public void call() {
        System.out.println("Called");
    }
}