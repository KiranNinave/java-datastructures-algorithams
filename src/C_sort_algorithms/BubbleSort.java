package C_sort_algorithms;

import java.util.Arrays;

// bubble sort push larger element at the end of array
// in bubble sort we have two partitions
// at start unsorted partition
// at end sorted partition
// bubble sort require n-1 pass to complete task
// stable sort
// O(n^2)
// omega(n^2)
// theta(n^2)

public class BubbleSort {

    public static int[] sort(int arr[]){
        for(int sortedPartisionIndex=arr.length-1; sortedPartisionIndex>=1; sortedPartisionIndex--){
            for(int unsortedPartisionIndex=0; unsortedPartisionIndex<sortedPartisionIndex; unsortedPartisionIndex++){
                if(arr[unsortedPartisionIndex] > arr[unsortedPartisionIndex+1]){
                    int temp = arr[unsortedPartisionIndex];
                    arr[unsortedPartisionIndex] = arr[unsortedPartisionIndex+1];
                    arr[unsortedPartisionIndex+1] = temp;
                }
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
