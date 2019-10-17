package C_sort_algorithms;

import java.util.Arrays;

// in selection we have two sorted and unsorted partition
// sorted partition at first and then unsorted partition
// in selection sort we choose minimum or maximum element from unsorted partition and then swap with last index of sorted partition
// O(n^2)
// omega(n^2)
// unstable sort


public class SelectionSort {
    public static int[] sort(int arr[]){
        for(int sortedPartitionIndex=0; sortedPartitionIndex<arr.length; sortedPartitionIndex++){
            int min=sortedPartitionIndex;

            for(int unsortedPartionIndex=sortedPartitionIndex+1; unsortedPartionIndex<arr.length; unsortedPartionIndex++){
                if(arr[unsortedPartionIndex]<arr[min]) min=unsortedPartionIndex;
            }

            if(min!= sortedPartitionIndex){
                int temp = arr[sortedPartitionIndex];
                arr[sortedPartitionIndex] = arr[min];
                arr[min] = temp;
            }

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
