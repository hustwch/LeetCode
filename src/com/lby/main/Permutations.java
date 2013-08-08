package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-7
 * Time: 上午12:14
 *Given a collection of numbers, return all possible permutations.
 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
          ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
          permute(num,0,list,new ArrayList<Integer>());
          return list;
    }
    public void permute(int[] num,int start,ArrayList<ArrayList<Integer>>list,ArrayList<Integer> subList) {
       if(start==num.length){
           list.add(subList);
           return;
       }
       for(int i=start;i<num.length;i++){
          ArrayList subList1  = new ArrayList<Integer>();
          subList1.addAll(subList);
          swap(num,start,i);
          subList1.add(num[start]);
          permute(num,start+1,list,subList1);
          swap(num,start,i);
       }
    }
    public void swap(int[]num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

}
