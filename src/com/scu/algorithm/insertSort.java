package com.scu.algorithm;

public class insertSort {
    public static void insertSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 22, 8, 15, 33, 7, 9, 13};
        insertSort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }

    }
}
