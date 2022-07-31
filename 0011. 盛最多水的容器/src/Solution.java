/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月30日 11:41
 */
public class Solution {
    public int maxArea(int[] height) {
            int left=0;
            int right=height.length-1;
            int max=0;
            while(left<right){
                int temp=0;
                if(height[left]<height[right]){
                    temp =(right-left)*height[left++];
                }else {
                    temp =(right-left)*height[right--];
                }
                if(temp>max){
                    max=temp;
                }
            }
            return max;
    }

    public static void main(String[] args) {

    }
}
