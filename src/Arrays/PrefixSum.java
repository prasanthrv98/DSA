package Arrays;

public class PrefixSum {

    static int[] prefixSum;

    public static void main(String[] args) {
        int[] arr = {2,8,3,9,6,5,4};
         prefixSum = new int[arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            prefixSum[i] = sum;
        }

        int res = getSum(1,3,arr);
        System.out.println(res);

//        2,3,5,4,6,1
//        2,6,15,24,30,6
//        l 2, r 3 = 13
    }

    static int getSum(int l, int r, int[]arr){
         if(l == 0) return prefixSum[r];
         else{
             return prefixSum[r] - prefixSum[l - 1];
         }
    }

}
