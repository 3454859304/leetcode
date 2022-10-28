/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年10月04日 21:49
 */
public class Solution {
    //sb
    public boolean canJump(int[] nums) {
        int end =0;
        for(int i=0;i<nums.length;i++){
            if(i>end) return false;
            else if(nums[i]>end-i) end = nums[i]+i;
        }
        return true;
    }
}
