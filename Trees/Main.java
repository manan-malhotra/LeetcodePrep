package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // Node root = Node.insert(null, 1);
        // for(int i = 2;i<1000;i++){
        //     root = Node.insert(root, i);
        // }
        
        // System.out.println(Node.height(root));
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        String a = bf.readLine();
        String[] arr = a.split(" ");
        int[] arr2 = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            arr2[i]=Integer.parseInt(arr[i]);
        }
        for(int i : arr2){
            System.out.println(i);
        }
       
        
    }
    public static String serialize(Node root) {
        String st = "";
        
        return serialize(root,st);
    }
    private static String serialize(Node root, String st){
        if(root==null) return st + "N ";
        st=st+root.value+" ";
        st = serialize(root.left,st);
        st = serialize(root.right,st);
        // System.out.println(st+" called"+"");
        return st;
    }
    static int index=0;
    public static Node deserialize(String st) {
        String[] arr = st.split(" ");
        return deserialize(arr,st);
    }
    private static Node deserialize(String[] arr, String st){
        if(arr[index]!="N"){
            Node root = new Node(Integer.parseInt(arr[index++]));
            root.left = deserialize(arr, st);
            root.right = deserialize(arr, st);
            return root;
        }else{
            return null;
        }

    }

    
    
}
