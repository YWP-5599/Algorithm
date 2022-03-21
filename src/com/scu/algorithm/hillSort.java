package com.scu.algorithm;

public class hillSort {
    public static void Sort(int[] nums){
        int n=nums.length;
        //设定增长量初始值
        int h=1;
        while(h<nums.length/2){
            h = 2*h+1;
        }
        //希尔排序
        while(h>=1){
            for(int i=h;i<n; i+=h){
                for(int j=i; j>0;j-=h){
                    if(nums[j] < nums[j-h]){
                        int temp = nums[j];
                        nums[j] = nums[j-h];
                        nums[j-h] = temp;
                    }else{
                        break;
                    }
                }
            }
            h = h/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 22, 8, 15, 33, 7, 9, 13};
        hillSort.Sort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
