package Practice;

import java.util.Arrays;
import java.util.HashSet;

public class Practice {

    public static void main(String[] args) {
        int[] arr = {1,2,4,5};

        var res = subArrGivenSum(arr, 6);

        System.out.println(res);

    }

    static boolean subArrGivenSum(int[] arr, int target){

        int totalSum = 0;
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            if(hash.contains(sum - target)){
                return true;
            }

            hash.add(sum);
        }

        return false;


    }

    static boolean subArrZeroSum(int[] arr){

        HashSet<Integer> hash = new HashSet<>();
        int prefix = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];

            if(hash.contains(prefix)) return true;
            else {
                hash.add(prefix);
            }
        }

        return false;
    }

    static int equilibriumPoint(int[] arr){

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int prefixSum = 0;
        int suffixSum = sum;
        for (int i = 0; i < arr.length; i++) {


            suffixSum -= arr[i];

            if(prefixSum == suffixSum) return arr[i];

            prefixSum += arr[i];
        }

        return -1;
    }

    static int[] moveZeroToEnd(int[] arr){

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                arr[count] = arr[i];

                if(count != i) arr[i] = 0;

                count++;
            }

        }


//        for (int i = 0; i < arr.length; i++) {
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


    static int[] searchInRwiseCwiseSorted(int[][] arr, int target){
        int R = arr.length;
        int C = arr[0].length;

        int r = 0;
        int c = C - 1;

        while (r < R && c >= 0){
            if(arr[r][c] == target){
                return new int[] {r, c};
            }
            else if (arr[r][c] > target) {
                c--;
            }
            else r++;
        }

        return new int[] {-1, -1};
    }

    static void spiralTraversal(int[][] arr ){
//        1  2  3  4
//        5  6  7   8
//        9  10 11  12

        int R = arr.length;
        int C = arr[0].length;

        int top = 0, right = C - 1, bottom = R - 1, left = 0;


        while(left <= right && top <= bottom){

//            left to right
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

//            top to bottom
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;


            if(top <= bottom){
                //            right to left
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if(left <= right){

//            bottom to top
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

        }
    }




}
