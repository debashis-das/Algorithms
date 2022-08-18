package debashis.dynamicProgramming;

import java.util.*;

public class BestSum {

    public static void main(String[] args){
        BestSum bestSum = new BestSum();
        int targetSum = 100;
        List<Integer> inputs = Arrays.asList(1,2,5,25);
        Map<Integer,List<Integer>> memo = new HashMap<>();
        System.out.println(bestSum.fetchBestArray(targetSum,inputs,memo));
    }

    private List<Integer> fetchBestArray(int targetSum, List<Integer> inputs, Map<Integer,List<Integer>> memo) {
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        if(targetSum == 0)
            return new ArrayList<>();
        if(targetSum<0)
            return null;
        List<Integer> shortest = null;
        for(int temp : inputs){
            int newTargetSum = targetSum-temp;
            List<Integer> result = fetchBestArray(newTargetSum,inputs,memo);
            if(result != null){
                /**
                 * Here a new list is required as java lists are all call by reference
                 */
                List<Integer> finalResult = new ArrayList<>(result);
                finalResult.add(temp);
                if(shortest == null || shortest.size() > finalResult.size()){
                    shortest = finalResult;
                }
            }
        }
        memo.put(targetSum,shortest);
        return shortest;
    }
}
