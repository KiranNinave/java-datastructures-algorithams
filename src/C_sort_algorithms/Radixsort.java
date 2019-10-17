package C_sort_algorithms;

import java.util.Arrays;

// in radix sort we sort we create 0 to 9 buckets
// then we scan throw array then place elements in buckets base on there first 10th position then 100 then 1000 and so on
// hence we only require max num in array num of digit iteration
// radix sort well work with array wich have uniform data like 10, 22, 56, 77, 33
// time complexity O(n.m)
// worst if all elements goes inside same bucket O(n^2)

public class Radixsort {
    public static void sort(int arr[]){
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int max = Integer.MIN_VALUE;
        int i;

        for(i=0; i<arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }

        int maxLength = String.valueOf(max).length();
        int devide = 10;

        for(i=0; i<maxLength; i++){
            for(int j=0; j<bucketCount.length; j++){
                bucketCount[j]=0;
            }

            for(int k=0; k<arr.length; k++){
                int postion = Integer.valueOf(String.valueOf(String.valueOf(arr[k]%devide).charAt(0)));
                bucket[postion][bucketCount[postion]] = arr[k];
                bucketCount[postion]++;
            }

            int couter = 0;
            for(int l=0; l<bucket.length; l++){
                for(int m=0; m<bucketCount[l]; m++){
                    arr[couter] = bucket[l][m];
                    couter++;
                }
            }
            devide *= 10;
        }
    }
    public static void main(String[] args) {
        int[] arr = {123, 234, 795, 342, 101, 558, 146};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
