// https://leetcode.com/problems/rotate-image/description/
// Tags: Matrix
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.
package Arrays;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
        rotateImage(matrix);
        System.out.println();
        for(int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
    }

    private static void rotateImage(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(matrix,i,j,j,i);
            }
        }
        // swap r to l
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                swap(matrix,i,j,i,n-j-1);
            }
        }
        
    }
    public static void swap(int[][] arr,int i,int j, int m, int n){
        int temp = arr[i][j];
        arr[i][j]=arr[m][n];
        arr[m][n]=temp;
    }
    
}
