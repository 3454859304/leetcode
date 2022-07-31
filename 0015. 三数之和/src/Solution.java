import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月30日 16:34
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        ArrayList res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) return res;
            int target = -nums[i];
            for (int left=i+1,right=nums.length-1;left<right;){
                if(nums[left]+nums[right]==target){
                    res.add(new int[]{nums[i],nums[left],nums[right]});
                    do left++; while (left < right && nums[left] == nums[left - 1]);
                    do right--; while (left < right && nums[right] == nums[right + 1]);
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }


}
