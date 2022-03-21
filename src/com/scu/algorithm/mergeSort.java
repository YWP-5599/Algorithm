package com.scu.algorithm;

public class mergeSort {
    //辅助数组，用来合并过程中的排序实现
    private static int[] assist;
    public static void Sort(int[] nums){
        int n=nums.length;
        assist = new int[n];
        int l=0,r=n-1;
        Sort(nums, l, r);
    }
    public static void Sort(int[] nums, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        Sort(nums,lo,mid);
        Sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    public static  void merge(int[] nums,int lo, int mid, int hi){
        int i=lo,p=lo,q=mid+1;
        while(p<=mid && q<=hi){
            if(nums[p] < nums[q]){
                assist[i++] = nums[p++];
            }else{
                assist[i++] = nums[q++];
            }
        }
        while(p<=mid){
            assist[i++] = nums[p++];
        }
        while(q<=hi){
            assist[i++] = nums[q++];
        }
        for(int index=lo;index<=hi;index++){
            nums[index] = assist[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 18, 20, 55, 31, 7, 27};
        mergeSort.Sort(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
