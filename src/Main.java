import java.time.Duration;
import java.time.Instant;
public class Main {
    public static void merge(int[] arr, int l, int r, int mid){
        int l_sz = mid-l+1, r_sz = r-mid;
        int[] left = new int[l_sz+1], right = new int[r_sz+1];
        for(int i=0;i<l_sz;i++) left[i] = arr[l+i];
        for(int i=0;i<r_sz;i++) right[i] = arr[mid+i+1];
        left[l_sz] = right[r_sz] =10000000;
        int l_i=0, r_i=0;
        for(int i=l;i<=r;i++){
            if(left[l_i] < right[r_i]){
                arr[i] = left[l_i];
                l_i++;
            }
            else {
                arr[i] = right[r_i];
                r_i++;
            }
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(l == r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l,mid);
        mergeSort(arr, mid+1,r);
        merge(arr,l,r,mid);
    }
    public static void main(String args[]){
        int[] arr = {45,25,34,98};
        mergeSort(arr, 0, arr.length-1);
        for(int i =0;i<arr.length;i++) System.out.printf(arr[i]+" ");
        System.out.println();
    }
}