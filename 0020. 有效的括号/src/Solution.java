import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月04日 14:01
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i]==123||cs[i]==91||cs[i]==40){
                stack.push((int) cs[i]);
            }
            else if(stack.isEmpty()){
                return false;
            }else{
                int target =cs[i]-stack.peek();
                if(target==1||target==2){
                    stack.pop();
                }else return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 123 125 91 93 40 41
        int[] c={'{','}','[',']','(',')'};
        System.out.println(c);
        char d= (char) 124;
        char e= (char) 92;

        new Solution().isValid("]");
    }

}
