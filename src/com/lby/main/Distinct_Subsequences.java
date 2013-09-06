package com.lby.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-7
 * Time: 上午12:15
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class Distinct_Subsequences {
    public int numDistinct(String S, String T) {
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        int len = S.length(), len1 = T.length();
        if (len == 0 || len1 == 0) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(c, list);
            }
        }
        return numDistinct(map, T, 0, -1,len);
    }

    public int numDistinct(Map<Character, List<Integer>> map, String T, int index, int start,int len) {
        int j = 0,sum = 0;
        char c = T.charAt(index);
        List<Integer> list = map.get(c);
        if(list == null){
            return 0;
        }
        while (j<list.size()  && list.get(j) <= start) {
            j++;
        }
        int tLen = T.length();
        if(index == tLen-1){
           return list.size()-j;
        }
        for (; j < list.size(); j++) {
            int val = list.get(j);
            if(len-val < tLen-index) {
                break;
            }
            int tmp = numDistinct(map, T, index + 1, val,len);
            if(tmp == 0){
                break;
            }
            sum += tmp;
        }
        return sum;
    }
    public static void main(String[]args){
        System.out.println(new Distinct_Subsequences().numDistinct("ddd","dd"));
    }
}



