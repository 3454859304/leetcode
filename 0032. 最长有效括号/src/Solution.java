import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月13日 15:45
 */
public class Solution {

    //使用栈
    public int longestValidParentheses1(String s) {
        char[] sc =s.toCharArray();
        Deque<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        stack.push(-1);
        for(int i=0;i<sc.length;i++){
            if(sc[i]==40){//'('
                stack.push(i);
            }else if(sc[i]==41){//')'
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    int len = i-stack.peek();
                    if(len>max){
                        max =len;
                    }
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s){
        int left =0;
        int right =0;
        int max = 0;
        char[] sc=s.toCharArray();
        for(int i=0;i<sc.length;i++){
            if(sc[i]==40){
                left++;
            }else{
                right++;
            }
            if(right>left){
                left=0;
                right=0;
            }else if(right==left && 2*left>max){
                max=2*left;
            }
        }
        left=0;
        right=0;
        for(int i=sc.length-1;i>=0;i--){
            if(sc[i]==40){
                left++;
            }else{
                right++;
            }
            if(right<left){
                left=0;
                right=0;
            }else if(right==left && 2*right>max){
                max=2*right;
            }
        }
        return max;
    }
    //()
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("(()");
    }
}
