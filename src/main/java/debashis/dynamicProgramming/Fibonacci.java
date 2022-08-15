package debashis.dynamicProgramming;

/**
 * Memorization
 */
public class Fibonacci {
    
    int[] hash;

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        int n = 15;
        fibonacci.hash = new int[n];
        System.out.println(fibonacci.nthFiboNumberTopToBottom(n));
        System.out.println(fibonacci.nthFiboNumberBottomToTop(n));
    }

    // top to bottom
    private int nthFiboNumberTopToBottom(int n){
        if(n<=2){
            return 1;
        }
        if(hash[n-1] == 0){
            hash[n-1] = nthFiboNumberTopToBottom(n-1) + nthFiboNumberTopToBottom(n-2);
        }
        return hash[n-1];
    }

    // bottom to top
    private int nthFiboNumberBottomToTop(int n){
        if(n <= 2){
            return 1;
        }
        int init1 = 1,init2 = 1,result=0;
        for(int i=3;i<=n;i++){
            result = init1 + init2;
            init2 = init1;
            init1 = result;
        }
        return result;
    }

}
