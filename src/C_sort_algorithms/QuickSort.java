package C_sort_algorithms;

import java.util.Arrays;

// in quick sort we choose one pivote element and move all small elements to the left to pivote element
// and all greater elements to the right of pivote element
// so the pivote element have it's correct position in array
// we repeats this proccess on both side of the array
// time complexity O(nlogn)
// if array is sorted and we didn't implement randmized qucksort then
// it will give time complexity of O(n^2)

public class QuickSort {
    public static int partition(int arr[], int start, int end){
        int pivote = end;
        int i = start-1;
        for(int j=start; j<=end; j++){
            if(arr[j] <= arr[pivote]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
    public static void sort(int arr[], int start, int end){
        if(start < end){
            int pivote = partition(arr, start, end);
            sort(arr, start, pivote-1);
            sort(arr, pivote+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 30, 80, 70, 20, 60, 50, 100, 90};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
