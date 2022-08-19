package debashis.dynamicProgramming.recursive;

import java.util.*;

public class AllConstructString {

    public static void main(String[] args){
        AllConstructString allConstructString = new AllConstructString();
//        String target = "abcdef";
//        List<String> inputs = Arrays.asList("ab","abc","cd","def","abcd","ef","c");
        Map<String,List<List<String>>> memo = new HashMap<>();
//        Map<String,Integer> memo = new HashMap<>();
//        String target = "skateboard";
//        List<String> inputs = Arrays.asList("bo","rd","ate","t","ska","sk","boar");
        String target = "eeeeeeeeeeeeeeeeeeeeee";
        List<String> inputs = Arrays.asList("e","ee","eeeee","eeeeeeee");
        System.out.println(allConstructString.allConstruct(target,inputs,memo));
    }

    private List<List<String>> allConstruct(String target, List<String> inputs,Map<String,List<List<String>>> memo) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        List<List<String>> finalresult = new ArrayList<>();
        if(target.length() == 0) {
            List<String> values = new ArrayList<>();
            finalresult.add(values);
            return finalresult;
        }
        for(String temp : inputs){
            if(target.startsWith(temp)){
                List<List<String>> result = allConstruct(target.substring(temp.length()),inputs,memo);
                for(List<String> values : result){
                    List<String> newValues = new ArrayList<>();
                    newValues.add(temp);
                    newValues.addAll(values);
                    finalresult.add(newValues);
                }
            }
        }
        memo.put(target,finalresult);
        return finalresult;
    }
}
