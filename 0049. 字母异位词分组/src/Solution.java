import java.util.*;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月23日 16:30
 */
public class Solution {

    //字符串排序
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                ArrayList value = new ArrayList();
                value.add(strs[i]);
                map.put(key,value);
            }
        }
        return new ArrayList<List<String>>( map.values());
    }


}
