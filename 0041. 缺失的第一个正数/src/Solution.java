/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月02日 15:17
 */
public class Solution {
    public int firstMissingPositive0(int[] nums) {
        int ans=1;
        for (int i=0;i< nums.length;i++){
            if(nums[i]>0&&nums[i]<=ans){
                ans=nums[i]+1;
            }
        }
        return ans;
    }

    public int firstMissingPositive(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i]=n+1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
