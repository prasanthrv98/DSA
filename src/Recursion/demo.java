package Recursion;

public class demo {

    public static void main(String[] args) {

//        int res = genSubset("abc", "");
//        System.out.println(res);
        genSubset("abc", "", 0);
    }



    static void genSubset(String str, String cur, int i){

        if(i == str.length()){
            System.out.println(cur);
            return;
        }

        genSubset(str, cur, i + 1);
        genSubset(str, cur + str.charAt(i), i + 1);
    }

    static int jos(int n, int k){
        if(n == 1) return 1;


        int res = jos(n -1, k) + k;

        if(res >= n) return res - n;
        else return res;
    }
    static int cuttingRopes(int n , int a, int b, int c ){

        if(n == 0) return 0;
        if(n < 0) return -1;

        int aRes = cuttingRopes(n - a, a, b, c);
        int bRes = cuttingRopes(n - b, a, b, c);
        int cRes = cuttingRopes(n - c, a, b, c);

        int res = Math.max(aRes, Math.max(bRes, cRes));

        if(res == -1) return res;

        return res + 1;
    }



    static int sumOfDigits(int n){

        if(n < 10) return n;

        return n % 10 + sumOfDigits(n / 10);
    }
    static boolean checkPalindrome(String str, int start, int end) {

     if(start >= end) return true;

     return (str.charAt(start) == str.charAt(end) && checkPalindrome(str, start + 1, end - 1));
    }

    static int sumOfNaturalNums(int n){

        if(n <= 1) return n;

        return n + sumOfNaturalNums(n - 1);
    }

    static  void printN(int num){

        if(num == 0) return;

        System.out.println(num);

        printN(num - 1);

    }





}
