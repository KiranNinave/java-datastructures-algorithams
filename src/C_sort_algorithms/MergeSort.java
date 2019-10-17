package C_sort_algorithms;

import java.util.Arrays;

// merge sort is not in place algorithm
// time complexity O(nlogn) in all cases

public class MergeSort {
    public static void sort(int arr[], int start, int end){
        if(end > start){
            int mid = (start + end) /2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i=start;
        int j=mid+1;
        int couter=0;
        while (i<=mid && j<=end){
            temp[couter++] = arr[i]<=arr[j] ? arr[i++]: arr[j++];
        }

        // copying remaning array
        while (i<=mid){
            temp[couter++] = arr[i++];
        }

        while (j<=end){
            temp[couter++] = arr[j++];
        }

        couter=0;
        i=start;
        j=mid+1;

        while (i<=mid){
            arr[i++] = temp[couter++];
        }

        while (j<=end){
            arr[j++] = temp[couter++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 30, 80, 70, 20, 60, 50, 100, 90};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
