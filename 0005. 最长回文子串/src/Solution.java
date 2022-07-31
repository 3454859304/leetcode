import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * 功能描述  中心扩散法
 *
 * @author: PJY
 * @date: 2022年07月27日 17:00
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] cs =s.toCharArray();
        int len =s.length();
        if(len < 2){
            return s;
        }
        int maxLeft=-1;
        int maxRight=-1;
        int maxLen=0;
        for(int i=0;i<len;i++){
            int len1=palindromeLength(cs,i,i);
            int len2=palindromeLength(cs,i,i+1);
            if(len1>maxLen&&len1>len2){
                maxLeft=i;
                maxRight=i;
                maxLen=len1;
            }
            else if(len2>maxLen){
                maxLeft=i;
                maxRight=i+1;
                maxLen=len2;
            }
        }
        return s.substring(maxLeft-(maxLen-1)/2,maxRight+(maxLen-1)/2+1);
    }
    private int palindromeLength(char[] cs,int left,int right){

        while(left>=0 && right<cs.length && cs[left]==cs[right]){
            left--;
            right++;
        }
        left++;
        right--;
        return right-left+1;
    }

    //动态规划
    public String longestPalindrome1(String s) {
        int len =s.length();
        char[] cs=s.toCharArray();

        int maxLength=1;
        int start=0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        for(int d=1;d<len;d++){
            for(int i=0;i+d<len;i++){
                if(cs[i]==cs[i+d]&&(d==1||dp[i+1][i+d-1])){
                    dp[i][i+d]=true;
                }
                if (dp[i][i+d] && d+1 > maxLength) {
                    maxLength=d+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }



    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ccc"));
    }
}
