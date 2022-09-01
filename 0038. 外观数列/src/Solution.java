/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月17日 10:48
 */
public class Solution {
    public String countAndSay(int n) {
        String res ="1";
        for(int i=1;i<n;i++){
            res =nextString(res);
        }
        return res;
    }

    public String nextString(String str){
        StringBuilder sb = new StringBuilder();
        char[] sc =str.toCharArray();
        int count=1;
        for(int i=1;i<sc.length;i++){
            if(sc[i]==sc[i-1]){
                count++;
            }else{
                sb.append(count).append(sc[i-1]);
                count=1;
            }
        }
        return sb.append(count).append(sc[sc.length-1]).toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countAndSay(5);
    }
}
