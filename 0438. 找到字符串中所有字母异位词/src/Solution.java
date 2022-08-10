import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月08日 14:42
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sc =s.toCharArray();
        char[] pc =p.toCharArray();
        if(sc.length<pc.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int[] count= new int[26];
        for(int i=0;i<p.length();i++){
            count[sc[i]-'a']++;
            count[pc[i]-'a']--;
        }
        int diff=0;
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                diff++;
            }
        }
        if(diff==0){
            res.add(0);
        }
        for(int i=0 ;i<sc.length- pc.length;i++){
            int change = --count[sc[i]-'a'];
            if(change==0){
                diff--;
            }else if(change==-1){
                diff++;
            }
            int j = i+pc.length;
            change = ++count[sc[j]-'a'];
            if(change==1){
                diff++;
            }else if(change==0){
                diff--;
            }
            if(diff==0){
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

}
