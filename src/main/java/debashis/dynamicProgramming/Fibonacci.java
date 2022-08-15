package debashis.dynamicProgramming;

public class Fibonacci {

    int[] hash;

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        int n = 15;
        fibonacci.hash = new int[n];
        System.out.println(fibonacci.nthFiboNumber(n));
    }

    private int nthFiboNumber(int n){
        if(n<=2){
            return 1;
        }
        if(hash[n-1] == 0){
            hash[n-1] = nthFiboNumber(n-1) + nthFiboNumber(n-2);
        }
        return hash[n-1];
    }
}
