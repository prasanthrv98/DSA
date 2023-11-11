package Hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        int[] arr = {10,20,10,10,30,40 };
//        var res = longestConsecutiveSubsequence(arr);
//        System.out.println(res);

        HashMap<Character, Integer> hash = new HashMap<>();

        hash.put('a', 2);
        hash.put('b', 3);

        System.out.println(Collections.max(hash.values()));

    }



    static int longestConsecutiveSubsequence(int[] arr){

        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hash.add(arr[i]);
        }

        int res = 0;
        int count = 0;

        // 1 3 4 3 3 2 9 10
        // 1 3 4 2 9 10
        for (int i = 0; i < arr.length; i++) {
            int curEle = arr[i];
            int conEle = 0;
            if(!hash.contains(curEle - 1)){
                count = 1;
                conEle = curEle + 1;
                while(hash.contains(conEle)){
                    count++;
                    conEle++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }

    static int longestSubArrWithZeroAndOnes(int[] arr){
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) arr[i] = -1;
        }

        res = longestSubArr(arr, 0);


//naive sol
//        for (int i = 0; i < arr.length; i++) {
//            int oneCount = 0;
//            int zeroCount = 0;
//            for (int j = i; j < arr.length; j++) {
//                if(arr[j] == 1) oneCount++;
//                else zeroCount++;
//
//                if(oneCount == zeroCount) res = Math.max(res, oneCount + zeroCount);
//            }
//
//
//        }

        return res;
    }

    static  int longestSubArr(int[] arr, int target){
        int res = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if(prefixSum == target) res = i + 1;

            if(!hash.containsKey(prefixSum)) hash.put(prefixSum, i);

            if(hash.containsKey(prefixSum - target)){
                int l = hash.get(prefixSum - target);

                res = Math.max(res, i - l);
            }


        }

//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0;
//            for (int j = i ; j < arr.length; j++) {
//
//                sum += arr[j];
//                if(sum == target) {
//                    res = Math.max(res, j - i + 1);
//                }
//            }
//
//        }

        return res;
    }

    static boolean subArrWithgivenSum(int[] arr, int targetSum){
        HashSet<Integer> hash = new HashSet<>();
        int sum = 0;
        for (int x :
                arr) {
            sum += x;

            if(hash.contains(sum - targetSum) || sum == targetSum) return true;
            hash.add(sum);
        }

        return false;
    }

    static boolean isZeroSubArr(int[] arr){
        HashSet<Integer> hash = new HashSet<>();
        int sum = 0;
        for (int x :
                arr) {
            sum += x;

            if(hash.contains(sum) || sum == 0) return true;
            hash.add(sum);
        }
        return false;
    }

    static boolean twoSum(int[] arr, int sum){
        HashSet<Integer> hash = new HashSet<>();

        for (int x : arr) {
            if(hash.contains(sum - x)) return true;
            else hash.add(x);
        }

        return false;
    }

    static void freqOfArr(int[] arr){
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(hash.containsKey(arr[i])){
                int val = hash.get(arr[i]);
                hash.put(arr[i], val + 1);
            }
            else {
                hash.put(arr[i], 1);
            }
        }

        System.out.println(hash);
    }

    static void basicHash(){
        HashSet<String> myhash = new HashSet<>();

        myhash.add("help");
        myhash.add("red");

        HashMap<String, Integer> cache = new HashMap<>();
        cache.put("red", 10);
        cache.put("blue", 100);

        for (Map.Entry<String, Integer> ele:
                cache.entrySet()){
            System.out.println(ele.getValue());
        }
    }

}
