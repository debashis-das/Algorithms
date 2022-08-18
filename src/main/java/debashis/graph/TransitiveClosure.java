package debashis.graph;

import java.util.*;

public class TransitiveClosure {

    public static void main(String[] args){
        int n = 5;
        int[][] graph = {{1,1,0,0,0},{0,1,1,0,0},{0,0,1,1,0},{0,0,0,1,1},{0,0,0,0,1}};
        TransitiveClosure transitiveClosure = new TransitiveClosure();
        transitiveClosure.fetchTCList(n,graph);
    }

    private void fetchTCList(int n, int[][] g) {
        for(int k  = 0;k < n;k++)
        {
            for(int i = 0;i < n;i++)
            {
                for(int j = 0;j < n;j++)
                {
                    if(g[i][j] == 0)
                    {
                        if(g[i][k] == 1 && g[k][j] == 1) {
                            System.out.println("---> i:"+i+"  j:"+j+"  k:"+k);
                            g[i][j] = 1;
                        }
                    }
                }
            }
        }
        Arrays.stream(g).forEach(v->{
            Arrays.stream(v).forEach(System.out::print);
            System.out.println();
        });
    }
}
