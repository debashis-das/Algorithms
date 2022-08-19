package debashis.dynamicProgramming.recursive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstructString {

    public static void main(String[] args){
        CanConstructString canConstructString = new CanConstructString();
//        String target = "abcdef";
//        List<String> inputs = Arrays.asList("ab","abc","cd","def","abcd");
//        String target = "skateboard";
//        List<String> inputs = Arrays.asList("bo","rd","ate","t","ska","sk","boar");
        String target = "eeeeeeeeeeęeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        List<String> inputs = Arrays.asList("e","ee","eeeee","eeeeeeee");
        Map<String,Boolean> memo = new HashMap<>();
        System.out.println(canConstructString.canConstruct(target,inputs,memo));
    }

    private boolean canConstruct(String target, List<String> inputs,Map<String,Boolean> memo) {
        if(memo.containsKey(target))
            return memo.get(target);
        if (target.length() == 0)
            return true;
        for (int j = 0; j < inputs.size(); j++) {
            String currentString = inputs.get(j);
            if(target.startsWith(currentString)){
                String newTarget = target.substring(currentString.length());
                if(canConstruct(newTarget,inputs,memo)){
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);
        return false;
    }
}
