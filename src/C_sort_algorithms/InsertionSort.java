package C_sort_algorithms;

import java.util.Arrays;

// if array is already sorted then insertion sort perform best in O(n) in worst O(n^2)
// insertion sort have two sorted and unsorted partitions
// sorted partition first and then unsorted
// in insertion sort we choose first element in unsorted partition
// then insert at right position at sorted partition
// stable sort

public class InsertionSort {
    public static int[] sort(int arr[]){
        for(int unsortedPartitionIndex=1; unsortedPartitionIndex<arr.length; unsortedPartitionIndex++){
            int newElement = arr[unsortedPartitionIndex];
            int j=unsortedPartitionIndex;
            while (j>0 && arr[j-1]>newElement){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = newElement;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,1,8,3,6,2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
