package Arrays;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = {2,4,3};

//        int res = maxSumOfKSubArr(arr, 3);
//
//        System.out.println(res);

        System.out.println(subArrWithGivenSum(arr, 7));
    }

    static boolean subArrWithGivenSum(int[] arr, int target){
        int sum = 0;
        int l = 0;
//        [1,4,20,2,10,5]

        for (int r = 0; r < arr.length; r++) {

            sum += arr[r];
            while(sum > target){
                sum -= arr[l];
                l++;
            }

            if(sum == target) return true;
        }

        return false;
    }

    static int maxSumOfKSubArr(int[] arr, int k){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
    //[1,8,30,-5,20,7]

       while(r < arr.length){

           if (r + 1 <= k){
               sum+= arr[r];
               maxSum = Math.max(sum, maxSum);
           } else {
               sum += arr[r];

               sum-= arr[l];

               maxSum = Math.max(sum, maxSum);
               l++;
           }
           r++;
       }

        return maxSum;
    }
}
