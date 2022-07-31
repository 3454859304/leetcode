/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月28日 23:44
 */
public class Solution {
    public int myAtoi(String s) {
        char[] cs =s.toCharArray();
        int res=0;
        int flag=0;
        boolean op= false;
        while( flag<cs.length && cs[flag]==' ' ){
            flag++;
        }
        if(flag<cs.length &&( cs[flag]=='-'|| cs[flag]=='+')){
            if(cs[flag]=='-'){
                op=true;
            }
            flag++;
        }
        while(flag<cs.length && cs[flag]=='0'){
            flag++;
        }
        while(flag<cs.length){
            if(cs[flag]<48||cs[flag]>57){
                break;
            }
            if(res > Integer.MAX_VALUE / 10 ){
                if(op){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }else if(res == Integer.MAX_VALUE/10){
                if(op&&cs[flag]>'7'){
                    return Integer.MIN_VALUE;
                }else if(cs[flag]>'6'&&!op){
                    return Integer.MAX_VALUE;
                }
            }
            res=res*10+cs[flag]-48;
            flag++;
        }
        if(op){
            res=-res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("2147483646"));
    }
}
