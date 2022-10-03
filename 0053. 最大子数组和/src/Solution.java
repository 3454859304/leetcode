import javax.xml.stream.events.StartDocument;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月26日 21:39
 */
public class Solution {

    //woshisb
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max =sum;
        for(int i=1;i<nums.length;i++){
            if(sum>0){
                sum=sum+nums[i];
            }else{
                sum=nums[i];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSubArray(new int[]{-2,1});
    }
}


