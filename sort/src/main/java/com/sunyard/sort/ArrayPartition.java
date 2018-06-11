package com.sunyard.sort;

/**
 * Created by Administrator on 2018/6/11.
 */
public class ArrayPartition {
    public static void main(String[] args){
        int[] arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*200);
        }
        for(int j:arr){
            System.out.print(j+",");
        }
        System.out.print("\n");
        int left=-1;
        int right=arr.length;
        int pivot=99;
        while(true){
            while(left<right&&arr[++left]<pivot);
            while(right>left&&arr[--right]>pivot);
            if(left>=right)break;
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        for(int j:arr){
            System.out.print(j + ",");
        }
    }
}
