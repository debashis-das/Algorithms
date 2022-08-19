package debashis.dynamicProgramming.recursive;

import java.util.*;

public class howSum {

    public static void main(String[] args){
        howSum howSum = new howSum();
        int targetSum = 300;
        List<Integer> inputs = Arrays.asList(7,14);
        Map<Integer,List<Integer>> memo = new HashMap<>();
        System.out.println(howSum.howSumArray(targetSum,inputs,memo));
    }

    private List<Integer> howSumArray(int targetSum, List<Integer> inputs, Map<Integer,List<Integer>> memo) {
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        if(targetSum == 0)
            return new ArrayList<>();
        if(targetSum<0)
            return null;
        for(int temp : inputs){
            int newTarget = targetSum - temp;
            List<Integer> result = howSumArray(newTarget,inputs,memo);
            if(result != null){
                result.add(temp);
                memo.put(newTarget,result);
                return result;
            }
        }
        memo.put(targetSum,null);
        return null;
    }
}
