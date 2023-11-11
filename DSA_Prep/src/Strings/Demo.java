package Strings;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        String s1 = "ABABABCD";
        String s2 = "ABAB";

//        var res = checkAnagram(s1,s2);
//
//        System.out.println(res);
        naviePatternSearching(s1,s2);
    }


    static void naviePatternSearching(String txt, String pattern){

       int n = txt.length();
       int m = pattern.length();

        for (int i = 0; i <= n - m ; i++) {
            int j;
            for ( j = 0; j < m; j++) {
                if(pattern.charAt(j) != txt.charAt(i + j)){
                    break;
                }
            }

            if(j == m) System.out.println(i);
        }

    }



    static boolean checkAnagram(String s1, String s2){
        int[] chars = new int[25];

        for (int i = 0; i < s1.length(); i++) {
            int idx = s1.charAt(i) - (int) 'a';
            chars[idx]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int idx = s2.charAt(i) - (int) 'a';
            chars[idx]--;
        }

        for (int i = 0; i < s1.length(); i++) {
            int idx = s1.charAt(i) - (int) 'a';
            if(chars[idx] != 0) return false;
        }

        return true;


    }

    static boolean checkStringSubSeq(String s1, String s2){
        int i = 0;
        int j = 0;

        while(i < s1.length() && j < s2.length()){

            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }

        return j == s2.length();

    }

    static void stringFunc(){
        char c = '*';
        String s = "*";

        System.out.println((int)s.charAt(0));
        String s1 ="hello";
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String res = new String(arr);
        System.out.println(arr);
        System.out.println();
    }

}
