package debashis.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestWordInDict {

    public static void main(String[] args){
        List<String> dict = Arrays.asList("ale", "apple", "monkey", "plea");
        String str = "abpcplea";

        LargestWordInDict largestWordInDict = new LargestWordInDict();
        System.out.println(largestWordInDict.findLargestWord(dict,str));
    }

    private String findLargestWord(List<String> dict, String str) {
        Collections.sort(dict);
        String maxWord = "";
        for(String word : dict){
            if(wordPresent(word,str) && maxWord.length() < word.length()){
                maxWord = word;
            }
        }
        return maxWord;
    }

    private boolean wordPresent(String word, String str) {
        int i=0,j=0;
        for(;i<word.length() && j<str.length();){
            if(word.charAt(i) == str.charAt(j)){
                ++i;
                ++j;
            }else {
                ++j;
            }
        }
        if(i == word.length())
            return true;
        return false;
    }


}
