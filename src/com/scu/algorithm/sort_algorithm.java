package com.scu.algorithm;

public class sort_algorithm {
    public static void exch(Integer[] arr,int i,int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean less(Integer a,Integer b){
        if(a<b){
            return true;
        }else{
            return false;
        }
    }
    public static void sort(Integer[] arr){
        int lo = 0,hi=arr.length-1;
        sort(arr,lo,hi);
    }
    public static void sort(Integer[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int partition = partition(arr, lo, hi);
        sort(arr,lo,partition-1);
        sort(arr,partition+1,hi);
    }
    public static int partition(Integer[] arr,int lo,int hi){
        Integer key =arr[lo];
        int left = lo,right = hi+1;
        while(true){
            while(less(key,arr[--right])){
                if(right == left){
                    break;
                }
            }
            while(less(arr[++left],key)){
                if(left == right){
                    break;
                }
            }
            if(left >= right){
                break;
            }else{
                exch(arr,left,right);
            }
        }
        exch(arr,lo,right);
        return right;
    }
}
