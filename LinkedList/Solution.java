package LinkedList;

public class Solution {

    public static void main(String[] args) {
        int n = 3;
        int min = 0;
        for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                min = Math.min(i, j);
                System.out.print(n-min+" ");
            }
            for (int j = n-2; j >= 0; j--) {
                min = Math.min(i, j);
                System.out.print(n-min+" ");
            }
            System.out.println();
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                min = Math.min(i, j);
                System.out.print(n-min+" ");
            }
            for (int j = n-2; j >= 0; j--) {
                min = Math.min(i, j);
                System.out.print(n-min+" ");
            }
            System.out.println();
        }
    }
    
}
