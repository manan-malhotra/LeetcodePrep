package Trees;

import java.util.HashMap;

import javax.swing.tree.TreeNode;


public class Main {

    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(45);
        root.left.left = new Node(40);
        root.right = new Node(77);
        root.right.right = new Node(88);
        String st = serialize(root);
        String[] arr = st.split(" ");
        Node.morrisPreOrder(root); 
        String a = "1234";
        String str = "001";
             
    // Create a map to store differences
    //between counts of 1s and 0s.
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
     
    // Initially difference is 0;
            map. put(0, -1);
            int res =0;
            int count_0 = 0, count_1 = 0;
            for(int i=0; i<str.length();i++)
            {
                // Keep track of count of 0s and 1s
                if(str.charAt(i)=='0')
                    count_0++;
                else
                    count_1++;
 
        // If difference between current counts
        // already exists, then substring between
        // previous and current index has same
        // no. of 0s and 1s. Update result if this
        // substring is more than current result.
 
                if(map.containsKey(count_1-count_0))
                    res = Math.max(res, (i - map.get(count_1-count_0)));
     
        // If the current difference is seen first time.
                else
                    map.put(count_1-count_0,i);
                 
            }
             
            System.out.println("Length of longest balanced sub string = "+res);
        // Node.preOrder(root);
        // System.out.println();
        // Node.iterPreOrder(root);

        // Node.inOrder(root);
        // System.out.println();
        // Node.iterInOrder(root);
        
        // Node.postOrder(root);
        // System.out.println();
        // Node.iterPostOrder(root);

        HashMap<Integer,Integer> hm = new HashMap<>();
            hm.put(2, 1);
            // System.out.println(hm.get(2));
            // System.out.println(hm.containsKey(2));

        
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
