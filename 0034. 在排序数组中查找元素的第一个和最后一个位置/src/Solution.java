/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月14日 21:03
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearchStart(nums,target);
        int end = binarySearchEnd(nums,target);
        if(start>=0&&start<=end){
            return new int[]{start,end};
        }
        return new int[]{-1,-1};
    }

    private int binarySearchEnd(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        int answer = -1;
        while(left<=right){
            int mid = (left +right)/2;
            if (nums[mid]<=target){
                left=mid+1;
                answer=mid;
            }else{
                right=mid-1;
            }
        }
        return answer;
    }

    public int binarySearchStart(int[] nums, int target){
        int left =0;
        int right=nums.length-1;
        int answer = -1;
        while(left<=right){
            int mid = (left +right)/2;
            if (nums[mid]>=target){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return answer;
    }


    public int binarySearch(int[] nums, int target, boolean flag){
        int left =0;
        int right=nums.length-1;
        int answer = -1;
        while(left<=right){
            int mid = (left +right)/2;
            if (nums[mid]>target ||(flag && nums[mid]==target)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return answer;
    }
}
