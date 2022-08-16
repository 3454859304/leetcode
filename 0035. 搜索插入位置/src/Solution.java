/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月14日 21:29
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}
