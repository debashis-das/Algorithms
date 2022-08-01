package debashis.array;

import java.util.*;

public class TripletSumZero {

    public static void main(String args[]){
        TripletSumZero tripletSumZero = new TripletSumZero();
        tripletSumZero.tripletSum(Arrays.asList(0,-1,2,-3,1)).stream().forEach(innerList -> {
            innerList.stream().forEach(inner -> {
                System.out.print(inner + " ");
            });
            System.out.println();
        });
    }

    private List<List<Integer>> tripletSum(List<Integer> inputs){
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(inputs);
        Set<Integer> inputSet = new HashSet<>(inputs);
        for(int i=0,j=inputs.size()-1;i<j;++i,--j){
            int sum = inputs.get(i) + inputs.get(j);
            if(sum > inputs.get(inputs.size()-1) || sum < inputs.get(0)){
                continue;
            }
            if(inputSet.contains(-1*sum)){
                List<Integer> resultInner = new ArrayList<>();
                resultInner.add(inputs.get(i));
                resultInner.add(-1*sum);
                resultInner.add(inputs.get(j));
                result.add(resultInner);
            }
        }
        return result;
    }
}
