package debashis.dynamicProgramming.recursive;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public static void main(String[] args){
        GridTraveller gridTraveller = new GridTraveller();
        int m = 18;
        int n = 18;
        Map<String,Long> memo = new HashMap<>();
        System.out.println(gridTraveller.travel(m,n,memo));
    }

    private long travel(long m, long n,Map<String,Long> memo) {
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 && n ==1)
            return 1;
        String key = new StringBuilder().append(m).append(",").append(n).toString();
        if(!memo.containsKey(key)){
            memo.put(key,travel(m-1,n,memo) + travel(m,n-1,memo));
        }
        return memo.get(key);
    }
}
