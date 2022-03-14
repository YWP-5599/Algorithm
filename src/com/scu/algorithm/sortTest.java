package com.scu.algorithm;

public class sortTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 18, 20,55, 31, 7, 27};
        sort_algorithm.sort(arr);
        for( Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
