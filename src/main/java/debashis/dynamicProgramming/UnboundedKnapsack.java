package debashis.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 */
public class UnboundedKnapsack {

    class Knapsack {
        int value;
        int weight;
        Knapsack(int value,int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    public static void main(String[] args){
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        int w = 8;
        List<Integer> values = Arrays.asList(10,40,50,70);
        List<Integer> weights = Arrays.asList(1,3,4,5);
        System.out.println("Result : "+unboundedKnapsack.evaluateMatrix(values,weights,w).value);
    }

    private Knapsack evaluateMatrix(List<Integer> values, List<Integer> weights, int w) {
        List<List<Knapsack>> result = new ArrayList<>();
        init(weights, w, result);
        for(int i=1;i<=weights.size();i++){
            int currentValue = values.get(i-1);
            int currentWeight = weights.get(i-1);
            for(int j=1;j<=w;j++){
                Knapsack upperMatrixValue = result.get(i-1).get(j);
                if(j<currentWeight){
                    result.get(i).set(j,upperMatrixValue);
                }else{
                    int residualWeight = j-currentWeight;
                    Knapsack residual = result.get(i).get(residualWeight);
                    Knapsack finalValue = new Knapsack(currentValue+residual.value,currentWeight+residual.weight);
                    if(upperMatrixValue.value > finalValue.value){
                        result.get(i).set(j,upperMatrixValue);
                    }else{
                        result.get(i).set(j,finalValue);
                    }
                }
            }
        }
        result.stream().forEach(v -> {
            v.stream().forEach(h -> System.out.print(h.value+":"+h.weight+ " "));
            System.out.println();
        });
        return result.get(weights.size()).get(w);
    }

    private void init(List<Integer> weights, int w, List<List<Knapsack>> result) {
        for(int i = 0; i<= weights.size(); i++){
            List<Knapsack> rList = new ArrayList<>();
            for(int j = 0; j<= w; j++){
                rList.add(new Knapsack(0,0));
            }
            result.add(rList);
        }
    }
}
