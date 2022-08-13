import java.util.Arrays;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月10日 16:52
 *
 * 1234
 * 1243
 * 1324
 * 1342
 * 1423
 * 1432
 * 2134
 * 2143
 * 2314
 * 2341
 * 2413
 * 2431
 * 3124
 * 3142
 * 3214
 * 3241
 * 3412
 * 3421
 * 4123
 * 4132
 * 4213
 * 4231
 * 4312
 * 4321
 */


public class Solution {
    public void nextPermutation(int[] nums) {
        int index=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                index=i;
                break;
            }
        }
        int temp=-1;
        if(index!=0){
            temp = nums[index-1];
            //没有意义的双指针
            for(int i=index, j=nums.length-1;i-1<=j;i++,j--){
                if(nums[i]<=temp){
                    nums[index-1]=nums[i-1];
                    nums[i-1]=temp;
                    break;
                }else if(nums[j]>temp){
                    nums[index-1]=nums[j];
                    nums[j]=temp;
                    break;
                }
            }
        }
        for(int i=index,j=nums.length-1;i<j;i++,j--){
            temp =nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,3,1};
        Solution solution = new Solution();
        solution.nextPermutation(a);
    }
}
