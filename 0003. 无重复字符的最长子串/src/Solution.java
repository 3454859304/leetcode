import java.util.Arrays;
import java.util.HashMap;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月14日 15:01
 */
public class Solution {

    /*
     * @Description 用数组代替hash更快
     * @Date 2022/7/14 17:22
     * @Author PJY
     * @Param [java.lang.String]
     * @return int
     **/
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        int[] last = new int[128];
        for(int i=0;i<128;i++){
            last[i]=-1;
        }
        int max=0;
        int start =0;
        int length = s.length();
        for(int i = 0;i<length;i++){
            int index = s.charAt(i);
            if(last[index]>=start) {
                if(i-start>max){
                    max=i-start;
                }
                start = last[index]+1;
                last[index]=i;
                if(length-start <= max){
                    return max;
                }
            }
            else{
                last[index]=i;
            }
        }
        return length-start;
    }


    public int lengthOfLongestSubstring1(String s) {
        int[] last = new int[128];
        for(int i=0;i<128;i++){
            last[i]=-1;
        }
        int max=0;
        int start =0;
        int length = s.length();
        for(int i = 0;i<length;i++){
            int index = s.charAt(i);
            if(last[index]>=start) {
                if(i-start>max){
                    max=i-start;
                }
                start = last[index]+1;
                last[index]=i;
                if(length-start <= max){
                    return max;
                }
            }
            else{
                last[index]=i;
            }
        }
        return max;
    }
    public static void main(String[] args) {

       String s= "";
       System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

}
