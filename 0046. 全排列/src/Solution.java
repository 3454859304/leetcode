
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月18日 12:32
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,0,nums.length);
        return result;
    }

    private void dfs(ArrayList result,int[] nums, int idx,int n) {
        if(idx==n){
            ArrayList list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(nums[i]);
            }
            result.add(list);
        }else{
            if(idx<n){
                dfs(result,nums,idx+1,n);
            }
            for(int i=idx+1;i<n;i++){
                int temp = nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                dfs(result,nums,idx+1,n);
                nums[idx]=nums[i];
                nums[i]=temp;
            }
        }
    }
}
