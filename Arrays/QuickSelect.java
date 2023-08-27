package Arrays;

// import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {8,2,1,0,4,7,14,6,-2};
        int k = 8;
        sort(arr,k);       
        System.out.println(arr[k]);
        // System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr,int k) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        quickSort(arr,l,r,k);   
    }

    private static void quickSort(int[] arr, int l, int r,int k) {
        if(l<r){
            int pi = partition(arr,l,r);
            if(pi==k) return;
            if(pi>k) quickSort(arr, l, pi-1,k);
            else quickSort(arr, pi+1, r,k);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int p = l-1;
        int pivot = arr[r];
        for(int i=l;i<r;i++){
            if(arr[i]<pivot){
                swap(arr,++p,i);
            }
        }
        swap(arr,++p,r);
        return p;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}
