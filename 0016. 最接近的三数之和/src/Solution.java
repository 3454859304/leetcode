import java.util.Arrays;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月31日 15:24
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (i > 0 && 3*nums[i] -target > diff ) break;
            for(int left=i+1,right=nums.length-1;left<right;){
                int temp =nums[i]+nums[left]+nums[right] -target;
                if(temp==0){
                    return target;
                }else if(temp<0){
                    left++;
                    temp=-temp;
                    if(temp<diff){
                        diff=temp;
                        flag=false;
                    }
                }else {
                    right--;
                    if(temp<diff){
                        diff=temp;
                        flag=true;
                    }
                }
            }
        }
        if(flag){
            return target+diff;
        }
        return target-diff;
    }

}
