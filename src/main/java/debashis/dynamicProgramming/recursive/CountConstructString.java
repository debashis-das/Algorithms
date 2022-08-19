package debashis.dynamicProgramming.recursive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstructString {

    public static void main(String[] args){
        CountConstructString countConstructString = new CountConstructString();
        String target = "abcdef";
        List<String> inputs = Arrays.asList("ab","abc","cd","def","abcd","ef");
        Map<String,Integer> memo = new HashMap<>();
//        String target = "skateboard";
//        List<String> inputs = Arrays.asList("bo","rd","ate","t","ska","sk","boar");
//        String target = "eeeeeeeeeeęeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
//        List<String> inputs = Arrays.asList("e","ee","eeeee","eeeeeeee");
        System.out.println(countConstructString.countConstruct(target,inputs,memo));
    }

    private int countConstruct(String target, List<String> inputs,Map<String,Integer> memo) {
        if(memo.containsKey(target))
            return memo.get(target);
        if(target.length() == 0){
            return 1;
        }
        int result = 0;
        for(String temp : inputs){
            if(target.startsWith(temp)){
                result += countConstruct(target.substring(temp.length()),inputs,memo);
            }
        }
        memo.put(target,result);
        return memo.get(target);
    }
}
