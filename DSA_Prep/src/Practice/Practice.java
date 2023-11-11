package Practice;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        spiralTraversal(arr);
//        var res = search2dMatrix(arr, 30);
//        System.out.println(Arrays.toString(res));
    }

    static void spiralTraversal(int[][] arr){
//        1  2  3  4
//        5  6  7  8
//        9 10 11 12

        int top = 0 , right = arr[0].length - 1, bottom = arr.length - 1, left = 0;

        while(top <= bottom && left <= right){

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

            //  right to left
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if(left <= right){
                //            bottom to top
                for (int i = bottom; i >= top ; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }


        }


    }

    static int[] search2dMatrix(int[][] arr, int target){
//        row wise sorted and column wise sorted

        int i = 0;
        int j = arr[0].length - 1;

        while(i < arr.length && j >= 0){
            if(arr[i][j] == target) return new int[] {i, j};
            else if(arr[i][j] > target) j--;
            else i++;
        }

        return new int[] {-1, -1};
    }

    
    static int majorityElement(int[] arr){
        
        int res = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[res] == arr[i]) count++;
            else{
                count--;
            }

            if(count == 0){
                res = i;
                count = 1;
            }
        }


        count = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[res] == arr[i]) count++;
            if(count > arr.length / 2) return res;
        }

        return -1;
    }

    static  boolean equilibriumPoint(int[] arr){
//        4 6  4
//        4 0 -2
        int rSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rSum += arr[i];
        }

        int lSum = 0;
        for (int i = 0; i < arr.length; i++) {

            rSum -= arr[i];

            if(lSum == rSum) return true;

            lSum += arr[i];
        }


//        navie sol
//        for (int i = 0; i < arr.length; i++) {
//            int lSum = 0;
//            int rSum = 0;
//
//            for (int j = 0; j < i; j++) {
//                lSum  += arr[j];
//            }
//
//            for (int k = i + 1; k < arr.length ; k++) {
//                rSum += arr[k];
//            }
//
//            if(lSum == rSum) return true;
//        }

        return false;
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
//        navie sol
//        for (int i = 0; i < arr.length; i++) {
//
//            if(arr[i] == 0){
//                for (int j = i + 1; j < arr.length; j++) {
//                    if(arr[j] != 0){
//                        arr[i] = arr[j];
//                        arr[j] = 0;
//                        break;
//                    }
//                }
//            }
//
//        }

        return arr;
    }


}
