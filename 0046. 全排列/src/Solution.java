
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
        //TODO medium
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(result,0,nums);
        return result;
    }

    private void dfs(ArrayList result, int idx,int[] nums) {
        if(idx==nums.length){
            ArrayList<Object> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
        }else{
            for(int i=idx;i<nums.length;i++){
                int temp = nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                dfs(result,idx+1,nums);
                nums[idx]=nums[i];
                nums[i]=temp;
            }
        }
    }
}
