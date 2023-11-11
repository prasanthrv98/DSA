package Matrix;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
//        123
//        456
//        789

        int[][] arr = {{10,20,30,40}, {15,22,35,45}, {27,29,37,48}, {32,33,39,50}};
       var res = search2d(arr,33);
        System.out.println(Arrays.toString(res));

    }

    static int[]  search2d(int[][] arr, int target){

        int row = 0;
        int col = arr[0].length - 1;

        while(col >= 0 && row >= 0){
            if(arr[row][col] == target){
                return new int[]{row, col};
            }
            else if(arr[row][col] > target){
                col--;
            } else {
                row++;
            }
        }

        return new int[] {-1,-1};
    }

    static void spiralTraversal(int[][] arr, int R, int C){
        int top = 0, right = C - 1, bottom =  R - 1, left = 0;

        while(left <= right && top <= bottom){

            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            for (int i = right; i >= left ; i--) {
                System.out.print(arr[bottom][i] + " ");
            }
            bottom--;

            for (int i = bottom; i >= top ; i--) {
                System.out.print(arr[i][left] + " ");
            }
            left++;
        }
    }

    static void rotateMatrixAntiClock90Deg(int[][] arr, int n){
        int[][] res = new int[n][n];

//        first tranpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }

//        reverse each columns
        for (int i = 0; i < n ; i++) {
           int l = 0;
           int r = n - 1;

           while(l < r){
               int temp = arr[r][i];
               arr[r][i] = arr[l][i];
               arr[l][i] = temp;

               l++;
               r--;
           }
        }

//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = 0; j < n; j++) {
//                res[n - 1 - i][j] = arr[j][i];
//            }
//        }

        System.out.println(Arrays.deepToString(arr));
    }

    static void transposeMatrix(int[][] arr, int n){

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
//        int[][] res = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[j][i] = arr[i][j];
//            }
//        }
        System.out.println(Arrays.deepToString(arr));
    }

    static void printMatrixBoundary(int[][] arr){
//        print top row
        int R = arr.length;
        int C = arr[0].length;

        for (int col = 0; col < R; col++) {
            System.out.print(arr[0][col] + " ");
        }

        for (int i = 1; i < R; i++) {
            System.out.print(arr[i][C - 1] + " ");
        }

        for (int i = C - 2; i >= 0; i--) {
            System.out.print(arr[R - 1][i] + " ");
        }

        for (int i = R - 2; i >= 1; i--) {
            System.out.print(arr[i][0] + " ");
        }

    }

    static void printSnakePatter(int[][] arr ){

        for (int row = 0; row < arr.length; row++) {

            if(row % 2 == 0){
                for (int col = 0; col < arr[row].length; col++) {
                    System.out.print(arr[row][col] + " ");
                }
            }
            else {
                for (int col = arr[row].length - 1; col >= 0; col--) {
                    System.out.print(arr[row][col] + " ");
                }
            }
            System.out.println();
        }
    }


}
