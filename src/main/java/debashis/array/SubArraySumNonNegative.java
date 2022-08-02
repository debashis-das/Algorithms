package debashis.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySumNonNegative {

    public static void main(String[] args){
        List<Integer> input = Arrays.asList(1,4,20,3,10,5);
        int sum = 33;
        SubArraySumNonNegative subArraySumNonNegative = new SubArraySumNonNegative();
        subArraySumNonNegative.subArrayList(input,sum).stream().forEach(System.out::println);
    }

    private List<Integer> subArrayList(List<Integer> input, int sum) {
        List<Integer> result = new ArrayList<>();
        int tempSum = input.get(0);
        for(int i=0,j=0;i<=j && j<input.size();){
            if(tempSum < sum){
                ++j;
                tempSum += input.get(j);

            }else if(tempSum > sum){
                tempSum -= input.get(i);
                ++i;
            }else{
                result.add(i);
                result.add(j);
                return result;
            }
        }
        return result;
    }

}
