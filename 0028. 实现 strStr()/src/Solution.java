/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月06日 17:27
 */
public class Solution {

    //kmp算法
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    //暴力
    public int strStr1(String haystack, String needle) {
        char[] hc= haystack.toCharArray();
        char[] nc= needle.toCharArray();
        for(int i=0 ;i + nc.length <= hc.length;i++){
            boolean flag=true;
            for (int j = 0; j < nc.length; j++) {
                if (hc[i + j] != nc[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
