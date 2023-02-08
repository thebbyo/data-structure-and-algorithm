
import java.io.File;
import java.util.Formatter;
// import java.time.Duration;
// import java.time.Instant;
import java.util.Scanner;

public class Main{
    //max
    public static int max(int[] arr){
        int m = -1000000;
        for(int i=0 ;i<arr.length;i++){
            if(m < arr[i]) m = arr[i];
        }
        return m;
    }
    //count sort
    public static void countSort(int[] arr, int pos){
        int[] count = new int[10];
        for(int i=0; i<arr.length ; i++) count[(arr[i]/pos)%10]++;
        for(int i=1;i<10;i++) count[i]+=count[i-1];
        int[] out= new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            out[--count[(arr[i]/pos)%10]]=arr[i];
        }
        for(int i=0;i<arr.length;i++) arr[i] = out[i];
    }
    public static void radixSort(int[] arr){
        int m = max(arr);
        for(int pos = 1; m/pos>0; pos*=10){
            countSort(arr, pos);
        }
    }
    //quicksort_partition
    public static int partition(int[] arr,int pos, int l, int r){
        int x= arr[r];
        int pivot = (arr[r]/pos)%10;
        int i= l-1;
        for(int j=l;j<r;j++){
            if((arr[j]/pos)%10 < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = x;
        arr[r] = temp;
        return i;
    }
    //quick sort

    public static void quickSort(int[] arr,int pos, int l, int r){
        if(l<r){
            int pidx = partition(arr, pos,l, r);
            quickSort(arr,pos ,l, pidx-1);
            quickSort(arr,pos, pidx+1, r);
        }
    }

    public static void radixSort2(int[] arr,int l, int r){
        int m = max(arr);
        for(int pos = 1; m/pos>0; pos*=10){
            quickSort(arr, pos,l,r);
        }
    }
    //selection sort
    public static  void selectionSort(int[] arr, int pos){
        for(int i =0; i< arr.length;i++){
            int midx = i;
            for(int j= i+1;j<arr.length;j++){
                if((arr[j]/pos)%10<(arr[midx]/pos)%10){
                    int temp = arr[j];
                    arr[j] = arr[midx];
                    arr[midx] = temp;
                }
            }
        }
    }
    public static void radixSort3(int[] arr,int l, int r){
        int m = max(arr);
        for(int pos = 1; m/pos>0; pos*=10){
            selectionSort(arr, pos);
        }
    }
    public static void merge(int[] arr, int l, int r, int mid, int pos){
        int l_sz = mid - l+1, r_sz = r-mid;
        int[] left = new int[l_sz+1], right = new int[r_sz+1];
        for(int i =0;i<l_sz;i++) left[i] = arr[i+l];
        for(int i =0;i<r_sz;i++) right[i] = arr[mid+i+1];
        int l_i = 0, r_i =0;
        for(int i = l;i<=r ;i++){
            if(r_i == r_sz){
                arr[i] = left[l_i];
                l_i++;
            }
            else if(l_i == l_sz){
                arr[i]  = right[r_i];
                r_i++;
            }
            else if((left[l_i]/pos)%10 <= (right[r_i]/pos)%10){
                arr[i] = left[l_i];
                l_i++;
            }
            else{
                arr[i] = right[r_i];
                r_i++;
            }
        }
    }
    public static void mergesort(int[] arr, int l, int r, int pos){
        if(l==r) return;
        int mid  = (l+r)/2;
        mergesort(arr, l, mid, pos);
        mergesort(arr, mid+1, r, pos);
        merge(arr , l,r,mid,pos);
    }
    //merge sort
    public static void radixSort4(int[] arr,int l, int r){
        int m = max(arr);
        for(int pos = 1; m/pos>0; pos*=10){
            mergesort(arr,l,r-1, pos);
        }
    }
    public static void main(String args[]) {
        File dir = new File("/home/dell/sorting");
        dir.mkdir();
        String path = dir.getAbsolutePath();
        File file1 = new File(path + "/in.txt");
        File file2 = new File(path + "/out.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        int[] arr = new  int[5000];
        try {
            Formatter frmtr = new Formatter(path+"/in.txt");
            int min=9999, max=100000;
            for(int i=0 ;i< 5000; i++){
                arr[i] = (int)(Math.random()*(max-min+1)+min);
                frmtr.format("%d ",arr[i]);
            }
            frmtr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        long start = System.nanoTime();
        radixSort(arr);
        long end= System.nanoTime();
        try {
            Formatter frmtr = new Formatter(path+"/out.txt");
            for(int i=0 ;i< 5000; i++){
                frmtr.format("%d ",arr[i]);
            }
            frmtr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("excuting time usnig counting sort " );
        System.out.println((end-start)/1000000);
        int[] arr2 = new int[5000];
        try{
            File file = new File(path+"/in.txt");
            Scanner sc = new Scanner(file);
            int i = -1;
            while(sc.hasNext()){
                i++;
                int x = sc.nextInt();
                arr2[i] = x;
            }
            sc.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        File file3 = new File(path + "/outquick.txt");
        try{
            file3.createNewFile();
        }
        catch(Exception e){
            System.out.println(e);
        }
        long strt = System.nanoTime();
        radixSort2(arr2,0,arr2.length-1);
        long endd = System.nanoTime();
        try{
            Formatter frmt = new Formatter(path+"/outquick.txt");
            for(int i =0;i<5000;i++) frmt.format("%d ", arr2[i]);
            frmt.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("excuting time using quick sort");
        System.out.println((endd-strt)/1000000);
        int[] arr3 = new int[5000];
        try{
            File file = new File(path+"/in.txt");
            Scanner sc = new Scanner(file);
            int i = -1;
            while(sc.hasNext()){
                i++;
                int x = sc.nextInt();
                arr3[i] = x;
            }
            sc.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        File file4 = new File(path + "/outquick.txt");
        try{
            file4.createNewFile();
        }
        catch(Exception e){
            System.out.println(e);
        }
        long strtt = System.nanoTime();
        radixSort3(arr3, 0, arr3.length);
        long enddd = System.nanoTime();
        try{
            Formatter frmt = new Formatter(path+"/outselection.txt");
            for(int i =0;i<5000;i++) frmt.format("%d ", arr3[i]);
            frmt.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("excuting time using selection sort");
        System.out.println((enddd-strtt)/1000000);

        int [] ARR = new int[5000];
        try {
            File file =new File(path+"/in.txt");
            Scanner sc = new Scanner(file);
            int i =-1;
            while (sc.hasNext()){
                i++;
                int x= sc.nextInt();
                ARR[i] =x;

            }
            sc.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
        File file5 =  new  File(path+"/outmerge.txt");
        try {
            file5.createNewFile();
        }
        catch (Exception e){
            System.out.println(e);
        }
        long s = System.nanoTime();
        radixSort4(ARR,0,ARR.length);
        long e = System.nanoTime();
        radixSort4(ARR, 0 , ARR.length);
        try {
            Formatter frmt = new Formatter(path+"/outmerge.txt");
            for (int i=0;i<5000;i++) frmt.format("%d ",ARR[i]);
            frmt.close();
        }
        catch (Exception x){
            System.out.println(x);
        }
        System.out.println("excution time using mergesort " );
        System.out.println((e-s)/1000000);

    }
}
