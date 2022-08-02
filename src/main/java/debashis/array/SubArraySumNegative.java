package debashis.array;

import java.awt.geom.RectangularShape;
import java.util.*;

public class SubArraySumNegative {

    public static void main(String[] args){
        List<Integer> inputs = Arrays.asList(10,2,-2,-20,10);
        int sum = -10;
        SubArraySumNegative subArraySumNegative = new SubArraySumNegative();
        subArraySumNegative.sumSubArray(inputs,sum).stream().forEach(System.out::println);
    }

    private List<Integer> sumSubArray(List<Integer> inputs, int sum) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int currentSum = 0;
        for(int i=0;i<inputs.size();i++){
            currentSum += inputs.get(i);
            if(currentSum == sum){
                result.add(0);
                result.add(i);
                return result;
            }
            if(map.containsKey(currentSum-sum)){
                result.add(map.get(currentSum-sum)+1);
                result.add(i);
                return result;
            }
            map.put(currentSum,i);
        }
        return result;
    }
}
