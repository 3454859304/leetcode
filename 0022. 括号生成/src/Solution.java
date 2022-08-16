import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月05日 16:02
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateByRecursion(strings,0,n,sb);
        return strings;
    }
    public void generateByRecursion(List strings,int flag,int last,StringBuilder sb){
        if(last==0 && 2*flag==sb.length()) {
            strings.add(sb.toString());
        }
        else {

            if(last>0){
                sb.append('(');
                generateByRecursion(strings, flag + 1, last - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (sb.length()<2 * flag) {
                sb.append(')');
                generateByRecursion(strings, flag, last, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        s.generateParenthesis(3);
    }

}
