package debashis.array;

import java.util.*;

public class JumpingNumber {

    public static void main(String[] args){
        int x = 105;
        JumpingNumber jumpingNumber = new JumpingNumber();
        jumpingNumber.generateAllNum(x).stream().forEach(System.out::println);
    }

    private Set<Integer> generateAllNum(int x) {
        Set<Integer> result = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int initNumbers = x<9 ? x : 9;
        for(int i=0;i<=initNumbers;i++){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(result.contains(current)){
                continue;
            }
            addIntoQueue(x, queue, current);
            result.add(current);
        }
        return result;
    }

    private void addIntoQueue(int x, Queue<Integer> queue, int current) {
        int rem = current%10;
        if(rem<9){
            int newNum = current *10+(rem +1);
            checkAndOffer(x, queue, newNum);
        }
        if(rem != 0){
            int newNum = current *10+(rem -1);
            checkAndOffer(x, queue, newNum);
        }
    }

    private void checkAndOffer(int x, Queue<Integer> queue, int newNum) {
        if(newNum <= x){
            queue.offer(newNum);
        }
    }


}
