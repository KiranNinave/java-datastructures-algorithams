package C_sort_algorithms;


import java.util.Arrays;

// bucket sort is identical when we have uniformly distrubuted data
// in bucket sort first we create bucket unsing formula ceil(sqrt(arr.length))
// then we scan through array and place elements in buckets using formula ceil((value*numBuckets)/max element in array)
// then we sort induvisual buckets using any sorting algorithm like bubble sort or quick sort
// the time compexity is depend on sorting algorithm that we use

// O(nlogn)
// worst case if we dont have uniformly distrubuted data like 1, 3, 91, 96...
// and all the elements goes inside same bucket then O(n^2)


public class BucketSort {
    public static int[] sort(int arr[]){

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 30, 80, 70, 20, 60, 50, 100};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
