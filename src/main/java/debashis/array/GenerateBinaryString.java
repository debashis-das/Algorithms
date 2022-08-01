package debashis.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryString {

    class QuestionMarkList {
        int count;
        List<Integer> indexes;

        QuestionMarkList(int count,List<Integer> indexes){
            this.count = count;
            this.indexes = indexes;
        }
    }

    public static void main(String[] args){
        GenerateBinaryString generateBinaryString = new GenerateBinaryString();
        String str = "1??0?101";
        QuestionMarkList qMarks = generateBinaryString.countQMarks(str);
        List<String> generatedChars = generateBinaryString.generateChars(qMarks.count);
        generatedChars.stream().forEach(charList ->{
            int padding = qMarks.count - charList.length();
            StringBuilder result = new StringBuilder(str);
            for(int i=0;i<qMarks.count;i++){
                if(i<padding){
                    result.setCharAt(qMarks.indexes.get(i),'0');
                }else{
                    result.setCharAt(qMarks.indexes.get(i), charList.charAt(i-padding));
                }
            }
            System.out.println(result);
        });
    }

    private List<String> generateChars(int noOfChars){
        int min = 0;
        int max = 0;
        List<String> result = new ArrayList<>();
        for(int i=0;i<noOfChars;i++){
            max += (Math.pow(2,i));
        }
        for(int i=min;i<=max;i++){
            result.add(Integer.toBinaryString(i));
        }
        return result;
    }

    private QuestionMarkList countQMarks(String str) {
        int count = 0;
        List<Integer> indexs = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '?'){
                ++count;
                indexs.add(i);
            }
        }
        return new QuestionMarkList(count,indexs);
    }
}
