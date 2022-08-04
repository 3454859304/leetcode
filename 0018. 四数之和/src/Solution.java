import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月03日 12:55
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len =nums.length;
        if (nums == null || len < 3) return new ArrayList<>();
        Arrays.sort(nums);
        ArrayList res= new ArrayList<List<Integer>>();
        for(int i=0;i<len-3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                int tar = target-nums[i]-nums[j];
                while(left<right){
                    if(nums[left]+nums[right]==tar){
                        res.add(new int[]{nums[i],nums[j],nums[left],nums[right]});
                        do left++; while (left < right && nums[left] == nums[left - 1]);
                        do right--; while (left < right && nums[right] == nums[right + 1]);
                    }else if(nums[left]+nums[right]<tar){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {


        new Solution().fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);


    }
}
