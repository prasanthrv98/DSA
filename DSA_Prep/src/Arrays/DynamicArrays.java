package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArrays {

    public static void main(String[] args) {

        int[] arr = {1,2,-1};
//        minimumCosecutiveFlips(new int[] {1,0});

        var res = minAdjDiff(arr, 3);
        System.out.println(res);



    }

     static int minAdjDiff(int arr[], int n) {

         int minDiff = Integer.MAX_VALUE;
         int diff = 0;

         for(int i = 1; i < n; i++){
             diff = Math.abs(arr[i - 1] - arr[i]);


             minDiff = Math.min(diff, minDiff);
         }


         diff = arr[n - 1] - arr[0];

         minDiff = Math.min(Math.abs(diff), minDiff);

         return minDiff;
    }

    static int maxAppearingElement(int[] left, int[] right){
        int[] freq = new int[101];

        for (int i = 0; i < left.length; i++) {
            freq[left[i]]++;
            freq[right[i] + 1]--;
        }

        int res = 0;
        for (int i = 1; i < 100; i++) {
            freq[i] = freq[i] + freq[i - 1];

            if(freq[i] > freq[res]) res = i;
        }
        return res;



//
//        for (int i = 0; i < left.length; i++) {
//
//            for (int j = left[i]; j <= right[i]; j++) {
//                freq[j] += 1;
//            }
//        }
//
//        int res = 0;
//        int idx = 0;
//        for (int i = 0; i < freq.length; i++) {
//            if(freq[i] > res){
//                idx = i;
//                res = freq[i];
//            }
//        }
//
//        return idx;
    }

    static int[] moveZeroToEnd(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

           if(arr[i] != 0){
               arr[count] = arr[i];
               if(i != count) arr[i] = 0;
               count++;
           }
        }


//        for (int i = 0; i < arr.length; i++) {
//
//            if(arr[i] == 0){
//
//                for (int j = i + 1; j < arr.length; j++) {
//                    if(arr[j] != 0){
//                        arr[i] = arr[j];
//                        arr[j] = 0;
//                        break;
//                    }
//                }
//            }
//        }
        return arr;

    }

    static void minimumCosecutiveFlips(int[] arr){

        int oneCounts = 0;
        int zeroCounts = 0;

        if(arr[0]  == 0) zeroCounts = 1;
        else oneCounts = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]){
                if(arr[i] == 0) zeroCounts++;
                else oneCounts++;
            }
        }

        int res = 0;
        if(oneCounts < zeroCounts) res = 1;
        int start = -1;
        int end = -1;
        System.out.println("min" + res);

//        1,0,0,0,1,0,0,1,1,1,1
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == res && i == 0){
                 start = i;
            } else if (arr[i] == res && arr[i - 1] != res) {
                start = i;
            }

            if (i == arr.length - 1 && arr[i] == res) {
                end = i;
                System.out.println("From" + start + "to" + end);
            }
            else if (arr[i] == res && arr[i + 1] != res) {
                end = i;
                System.out.println("From" + start + "to" + end);
            }
        }

    }

    static int majorityElement(int[] arr){

        int count = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {

            if(arr[res] == arr[i]){
                count++;
            } else count--;

            if(count == 0){
                res = i;
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[res] == arr[i]){
                count++;
            }
        }

        if(count > arr.length / 2){
            return arr[res];
        }

        return -1;
    }


    static  int maxCircularSubArr(int[] arr){
        int maxSum = maxSumSubArr(arr);

        int maxMin = arr[0];
        int curMin = 0;
        int total = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            total += arr[i];
            curMin = Math.min(arr[i] + curMin, arr[i]);
            maxMin = Math.min(curMin, maxMin);
        }

        System.out.println("max" + maxSum);
        System.out.println("min" + maxMin);
        System.out.println("total" + total);

        return Math.max(maxSum, total - maxMin);
    }

    static int maxLenEvenOddSubArr(int[] arr){
        int maxSum = 1;
        int count = 1;
//        boolean isPrevEven = arr[0] % 2 == 0;

        for (int i = 1; i < arr.length; i++) {

            if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) ||
                arr[i] % 2 != 0 && arr[i - 1] % 2 == 0){
                count++;
                maxSum = Math.max(maxSum, count);
            }
            else count = 1;

//            if(isPrevEven){
//                boolean isCurOdd = arr[i] % 2 != 0;
//
//                if(isCurOdd) count++;
//                else count = 1;
//
//            } else {
//                boolean isCurEven = arr[i] % 2 == 0;
//
//                if(isCurEven) count++;
//                else count = 1;
//            }
//            maxSum = Math.max(maxSum, count);
//            isPrevEven = arr[i] % 2 == 0;

        }

        return maxSum;
    }

    static int maxSumSubArr(int[] arr){
        int maxEnding = arr[0];
        int maxSum = 0;

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxEnding, maxSum);
        }


//        for(int i = 0; i < arr.length; i++){
//            int sum = 0;
//            for (int j = i ; j < arr.length; j++) {
//                sum += arr[j];
//                maxSum = Math.max(maxSum, sum);
//
//            }
//        }

        return maxSum;
    }

    static int maxConsecutiveOne(int[] arr){
        int maxSum = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                count++;
                maxSum = Math.max(maxSum, count);
            } else{

                count = 0;
            }
        }

        return maxSum;

    }

    static  ArrayList<Integer> freqSortedArr(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();

        int prevValue = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {

            if(arr[i] != prevValue) {
                res.add(count);
                count = 1;
                prevValue = arr[i];
            }
            else{
                count++;
            }

            if(i == arr.length - 1){
                res.add(count);
            }
        }

        return res;
    }

    static int[] leftRotate(int[] arr, int n){

        int[] res = new int[arr.length];

        while (n > arr.length){
            n -= arr.length;
        }
 //         0 1 2 3 4
//        [1,2,3,4,5]

//         0 1 2 3 4
//        [2,3,4,5,1]


        for (int i = 0; i < arr.length; i++) {
            int idx = i - n;

            if(idx < 0) idx += arr.length;

            res[idx] = arr[i];
        }

        return res;
    }



    static void deleteArr(int[] arr, int ele){

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == ele){
                arr[i] = arr[i + 1];
            }

        }
    }

    static int secondLargest(int[] arr){

        int largest = 0;
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] > arr[largest]){
                secondLargest = largest;
                largest = i;
            }
           else if(arr[i] < arr[largest] && arr[i] > arr[secondLargest]){
               secondLargest = i;
           }

        }

        return secondLargest;
    }

}
