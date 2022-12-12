package deva.com.datastructure.greedy;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int n = 7, m=15;
        int[] w = {2,3,5,7,1,4,1};
        int[] p = {10,5,15,7,6,18,3};
        double[] profitPerWeight = new double[n];
        for(int i=0;i<n;i++){
            profitPerWeight[i] = (double)p[i]/w[i];
        }
        System.out.println(Arrays.toString(profitPerWeight));
    }
}
