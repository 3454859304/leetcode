import java.util.*;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月21日 22:12
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, new LinkedList<Integer>(), nums,flag,0,nums.length);
        return result;
    }

    private void dfs(ArrayList result, Deque<Integer> stack , int[] nums, boolean[] flag, int idx, int n) {
        if(idx==n){
            result.add(new ArrayList<>(stack));
        }else{
            for(int i=0;i<n;i++){
                if(flag[i]==true || (i > 0 && nums[i] == nums[i - 1] && flag[i - 1]==false )){
                    continue;
                }
                stack.push(nums[i]);
                flag[i]=true;
                dfs(result,stack,nums,flag,idx+1,n);
                stack.pop();
                flag[i]=false;
            }
        }
    }
}
