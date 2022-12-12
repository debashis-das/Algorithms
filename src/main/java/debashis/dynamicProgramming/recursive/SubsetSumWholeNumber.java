package debashis.dynamicProgramming.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * N = 2, S = 2, output = 3, Assignments (0 2) (1 1) (2 0)
 * N = 3, S = 2, output = 6, Assignments (0 2 0) (1 1 0) (2 0 0) (1 0 1) (0 0 2) (0 1 1)
 */
public class SubsetSumWholeNumber {

    static class SumForLength{
        public int sum;
        public int length;

        public SumForLength(){
            sum=0;
            length=0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SumForLength that = (SumForLength) o;
            return sum == that.sum && length == that.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, length);
        }
    }

    public static void main(String[] args) {
        SubsetSumWholeNumber sub = new SubsetSumWholeNumber();
        int S=2,N=3;
        Map<SumForLength,Integer> memo = new HashMap<>();
        SumForLength current = new SumForLength();
        System.out.println(sub.subsetSumOdWholeNumber(N,S,memo,current));
    }

    private int subsetSumOdWholeNumber(int N, int S,Map<SumForLength,Integer> memo,SumForLength current) {
        if(memo.containsKey(current)){
            return memo.get(current);
        }
        if(current.length == N && S==current.sum){
            return 1;
        }
        if(current.length == N && current.sum != 0){
            return 0;
        }
        if(current.sum<0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<=S;i++){
            SumForLength newCurrent = new SumForLength();
            newCurrent.sum = current.sum - i;
            newCurrent.length = current.length-1;
            int currentCount = subsetSumOdWholeNumber(N,S-i,memo,current);
            if(currentCount != 0){
                count += currentCount;
            }
        }
        return count;
    }
}
