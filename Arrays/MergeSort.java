package Arrays;

import java.util.Arrays;

class MergeSort{
    public static void main(String[] args) {
        int[] arr = {8,2,1,0,4,7,14,6};
        sort(arr);       
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int n = arr.length;
        int l = 0;
        int r = n-1;
        mergesort(arr,l,r);


    }
    private static void mergesort(int[] arr, int l, int r) {
        if (l<r){
            int m = l + (r-l)/2;
            mergesort(arr, l, m);
            mergesort(arr, m+1, r);

            merge(arr,l,r,m);
        }
    }
    private static void merge(int[] arr, int l, int r, int m) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[m+1+i];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
}