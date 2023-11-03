package BinarySearch;

import java.util.ArrayList;

public class Search {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,5,4,3};

        var res = twoRepeatingElements(arr);
        System.out.println(res);
    }


    static ArrayList<Integer> twoRepeatingElements(int[] arr){

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i]);

            if(arr[abs] > 0) arr[abs] = -arr[abs];
            else res.add(abs);
        }
        return res;
    }
    static int allocateMinPages(int[] arr, int k){
//        10, 20, 10, 30
        int l = 0;
        int r = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            l = Math.max(l, arr[i]);
            r += arr[i];
        }

        while(l <= r){
            int mid = (l + r) / 2;

            int sum = 0;
            int count = 1;
            for (int i = 0; i < arr.length; i++) {

                if(sum + arr[i] > mid) {
                    sum = arr[i];
                    count++;
                }
                else sum+= arr[i];
            }

            if(count <= k){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;

            }
        }
        return res;
    }

    static double medianOfTwoSortedArr(int[] nums1, int[] nums2){

        int[] a = nums1;
        int[] b = nums2;

        if(b.length < a.length){
            var temp = a;
            a = b;
            b = temp;
        }
        int total = a.length + b.length;
        int half = (total ) / 2;
        var res = 0.0;

        int l = 0;
        int r = a.length - 1;


//        b = 1 2 3 4 5 6 7 8
//        a = 1 2 3 4
        while(l <= r){
            int i = (l+r)/2; // A
            int j = half - i - 2 ; // B

            int aLeft = i >= 0 ? a[i] : Integer.MIN_VALUE ;
            int aRight = i + 1 < a.length ? a[i + 1] : Integer.MAX_VALUE;

            int bLeft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int bRight = j + 1 < b.length ? b[j + 1] : Integer.MAX_VALUE;


            if(aLeft <= bRight && bLeft <= aRight){
                if(total % 2 == 0) {
                     res =  (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
                else{
                    res =  Math.min(aRight, bRight);
                }
                break;
            }
            else if(aLeft > bRight) r = i - 1;
            else l = i + 1;
        }

        return res;

    }



    static int findPeakElement(int[]arr){
        int l = 0;
        int n = arr.length ;
        int r = n - 1;

        while(l <= r){
            int mid = (l + r) /2;

            if((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == n -1 || arr[mid] > arr[mid + 1])){
                return mid;
            }
            else if(mid > 0 && arr[mid - 1] > arr[mid]) r = mid - 1;
            else l = mid + 1;
        }
    return -1;

    }

    static int sortedRotatedArr(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = (l+r) /2;

            if(arr[mid] == target) return mid;
            else if (arr[l] <= arr[mid]) {
//                left portion sorted
                if(target < arr[mid] && target >= arr[l]) r = mid - 1;
                else l = mid + 1;
            }
            else {
                if(target <= arr[r] && target > arr[mid]) l = mid + 1;
                else r = mid - 1;
            }

        }
        return -1;
    }

    static int searchInfiniteArr(int[] arr, int target){
        int previousLow = 0;
//        1,10,15,20,40,60,80,100,200,300

        if(arr[0] == target) return 0;
        int i = 1;

        while(arr[i] < target){
            previousLow = i;
            i *= 2;
        }
        if(arr[i] == target) return i;

        return binarySearch(arr, target, previousLow, i);


    }

    static  int binarySearch(int[] arr, int target, int left, int right){

        while (left <= right){
            int mid = (left+right) / 2;

            if(arr[mid] < target) left = mid + 1;
            else if (arr[mid] > target) right = mid - 1;
            else return mid;
        }

        return -1;
    }


    static  int getSquareRoot(int x){
        int l = 1;
        int r = x;
//        1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        int mid = 0;
        while(l <= r){
             mid = (l+r) /2;

            if(mid * mid == x) return mid;
            else if(mid * mid > x) r = mid - 1;
            else l = mid + 1;
        }


        if(mid * mid < x) return mid;
        else return mid - 1;
    }
    static int countOne(int [] arr){
        int l = 0;
        int r = arr.length - 1;
        int firstOccIdx = -1;

        while(l <= r){
            int mid = (l+r) / 2;

            if(arr[mid] == 0) l = mid + 1;
            else {
                if(mid == 0 || arr[mid - 1] == 0){
                    firstOccIdx = mid;
                    break;
                }
                else r = mid - 1;
            }
        }

        if(firstOccIdx == -1) return 0;
        else return arr.length - firstOccIdx;
    }

    static int getOccCount(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        int idx = -1;
        while(l <= r){
           int mid = (l+r) /2;

            if(arr[mid] < target) l = mid + 1;
            else if(arr[mid] > target) r = mid - 1;
            else {
                if(mid == 0 || arr[mid - 1] != target) {
                    idx = mid;
                    break;
                }
                else r = mid - 1;
            }
        }

        if(idx == -1) return idx;

        int count = 0;

        for (int i = idx; i < arr.length ; i++) {
            if(arr[i] == target) count++;
            else break;
        }

        return count;
    }

    static  int getLastOcc(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;

            if(arr[mid] < target){
                l = mid + 1;
            }
            else if(arr[mid] > target){
                r = mid - 1;
            }
            else {
                if(mid == arr.length - 1 || arr[mid + 1] != target) return mid;
                else l = mid + 1;
            }
        }

        return -1;
    }



    static int getFirstOccInSortedArr(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r){
             mid = (l + r) / 2;

            if(arr[mid] > target){
                r = mid - 1;
            }
            else if(arr[mid] < target){
                l = mid + 1;
            } else {
                if(mid == 0 || arr[mid - 1] != target) return mid;
                else r = mid - 1;
            }
        }

       return -1;
    }
}
