package debashis.array;

import java.util.*;

public class LongestSubStringWIthKCharacters {

    public static void main(String[] args){
        String input = "aabbcca";
        int k=3;
        LongestSubStringWIthKCharacters longestSubStringWIthKCharacters = new LongestSubStringWIthKCharacters();
        System.out.println(longestSubStringWIthKCharacters.subArrayList(input,k));
    }

    private String subArrayList(String input, int k) {
        String maxSubSeq = "";
        if(input.length() == 0 || k == 0){
            return maxSubSeq;
        }
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        int currentCount = 0;
        for(int i=0,j=0;i<=j && j<input.length();){
            if(!indexMap.containsKey(input.charAt(j))){
                List<Integer> indexes = new ArrayList<>();
                indexes.add(j);
                indexMap.put(input.charAt(j),indexes);
                ++currentCount;
            }else{
                List<Integer> indexes = indexMap.get(input.charAt(j));
                indexes.add(j);
                indexMap.put(input.charAt(j),indexes);
            }
            if(currentCount < k && j+1<input.length()){
                ++j;
            }
            if(currentCount > k){
                List<Integer> indexes = indexMap.get(input.charAt(i));
                indexes.remove(Integer.valueOf(i));
                indexMap.put(input.charAt(j),indexes);
                if(indexes.size() == 0){
                    --currentCount;
                }
                ++i;
            }
            if(currentCount == k && maxSubSeq.length() < input.substring(i,j+1).length()){
                maxSubSeq = input.substring(i,j+1);
                ++j;
            }
        }
        return maxSubSeq;
    }
}
