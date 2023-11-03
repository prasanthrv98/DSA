package BinarySearch;

public class TwoPointers {

    public static void main(String[] args) {
        int[] arr = {2,3,4,8,9,20,40};
        var res = checkTripletsExists(arr, 41);

        System.out.println(res);

    }

    static boolean checkTripletsExists(int[] arr, int target){

        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;

            int sum = target - arr[i];

            while (l < r){
                if(arr[l] + arr[r] == sum) return true;
                else if(arr[l] + arr[r] < sum) l++;
                else r--;
            }
        }

        return false;
    }

    static boolean checkPairsExists(int[] arr, int target){

        int l = 0;
        int r = arr.length - 1;
        int sum = 0;

        while(l < r){
            sum = arr[l] + arr[r];

            if(sum == target) return true;
            else if(sum < target)l++;
            else r--;
        }

        return false;
    }

}
