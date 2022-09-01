import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月01日 15:13
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        dfs(lists,new ArrayList<Integer>(),candidates,0,target);
        return lists;
    }

    public void dfs(List<List<Integer>> lists,ArrayList list,int[] candidates,int flag,int target){
        if(flag==candidates.length){
            return;
        }
        int temp =candidates[flag];
        if(temp>target){
            return;
        }else if(temp==target){
            list.add(temp);
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }else{
            dfs(lists,list,candidates,flag+1,target);
            if(target-temp>0){
                list.add(temp);
                dfs(lists,list,candidates,flag,target-temp);
                list.remove(list.size()-1);
            }
        }
    }
}
