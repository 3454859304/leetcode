import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月02日 13:58
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList lists = new ArrayList<List>();
        Arrays.sort(candidates);
        dfs(lists,new ArrayList<Integer>(),0,candidates,target);
        return lists;
    }
    public void dfs(List<List<Integer>> lists,List<Integer> list,int flag,int[] candidates,int target ){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }else if(target<0||flag==candidates.length){
            return;
        } else{
            int num=1;
            while((flag+num)<candidates.length&&candidates[flag]==candidates[flag+num]){
                num++;
            }
            dfs(lists,list,flag+num,candidates,target);
            int most = Math.min(target / candidates[flag], num);
            for(int i=1;i<=most;i++){
                list.add(candidates[flag]);
                dfs(lists,list,flag+num,candidates,target-i*candidates[flag]);
            }
            for(int i=0;i<most;i++){
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] c={1,2,2,2,5};
        List<List<Integer>> lists = solution.combinationSum2(c, 50);

    }

}
