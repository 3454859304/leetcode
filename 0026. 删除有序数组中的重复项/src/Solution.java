/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月06日 16:08
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }else{
                nums[index++]=nums[i];
            }
        }
        return index;
    }

    //0027
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                continue;
            }else{
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
