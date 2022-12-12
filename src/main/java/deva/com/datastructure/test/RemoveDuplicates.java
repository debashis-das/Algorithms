package deva.com.datastructure.test;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {1,1,2,2,2,2,2,9,9,9,9,3,3,3,4,4,4};
        int result = rd.removeDuplicates(nums);
        for(int i=0;i<result ;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int distinct=0,i=nums.length-1;
        while(i>=0){
            int j = i;
            while(j-1 >=0 && nums[j] == nums[j-1]){
                --j;
            }
            int padding = i-j;
            if(padding != 0){
                if(distinct == 0 && j==0){
                    return 1;
                }
                for(int k=j+1;k<j+1+distinct;k++){
                    int temp = nums[k];
                    nums[k] = nums[k+padding];
                    nums[k+padding] = temp;
                }
                i = j;
            }
            ++distinct;
            --i;
        }
        return distinct;
    }
}
