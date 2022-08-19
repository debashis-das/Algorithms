package debashis.dynamicProgramming.recursive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {

    public static void main(String[] args){
        CanSum canSum = new CanSum();
        List<Integer> input = Arrays.asList(7,14);
        int targetSum = 300;
        Map<Integer,Boolean> memo = new HashMap<>();
        System.out.println(canSum.ifSumExists(targetSum,input,memo));
    }

    private boolean ifSumExists(int targetSum, List<Integer> input,Map<Integer,Boolean> memo) {
        if(targetSum < 0)
            return false;
        if(targetSum == 0)
            return true;
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        for(int i=0;i<input.size();i++){
            int newTarget = targetSum - input.get(i);
            if(ifSumExists(newTarget,input,memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum,false);
        return false;
    }


}
