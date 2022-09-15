/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月02日 15:23
 */
public class Solution {

    public int trap(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                ++left;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public int trap0(int[] height) {
        int sum = 0;
        int max_left = 0, max_right = 0;
        int left = 1, right = height.length - 2;
        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (max_left > height[left]) {
                    sum = sum + (max_left - height[left]);
                }
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                if (max_right > height[right]) {
                    sum = sum + (max_right - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
