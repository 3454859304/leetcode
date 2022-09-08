import java.io.IOException;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月02日 15:24
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] nc1= num1.toCharArray();
        char[] nc2= num2.toCharArray();
        StringBuilder ans=new StringBuilder("0");
        for(int i=0;i<nc1.length;i++){
            StringBuilder cur = new StringBuilder();
            int add=0;
            for(int j=0;j<nc1.length-1-i;j++){
                cur.append('0');
            }
            int n1=nc1[i]-'0';
            for(int j=nc2.length-1;j>=0;j--){
                int n2 = nc2[j]-'0';
                cur.append((n1*n2+add)%10);
                add=(n1*n2+add)/10;
            }
            if(add!=0){
                cur.append(add);
            }
           stringAddto(ans,cur.toString());
        }
        return ans.reverse().toString() ;
    }
    public String multiply1(String num1,String num2){
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] nc1 = num1.toCharArray();
        char[] nc2 = num2.toCharArray();
        int n1,n2;
        int[] ans=new int[nc1.length+nc2.length];
        for(int i= 0;i<nc1.length;i++){
            n1=nc1[i]-'0';
            for(int j=0; j<nc2.length;j++){
                n2=nc2[j]-'0';
                int temp=n1*n2;
                ans[i+j+1]+=temp;
            }
        }
        for(int i=nc1.length+nc2.length-1;i>0;i--){
            ans[i-1]+=ans[i]/10;
            ans[i] =ans[i]%10;
        }
        int sta=1;
        if(ans[0]!=0){
            sta=0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=sta;i<ans.length;i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
    //反转字符串相加： 45+87=231
    private void stringAddto(StringBuilder ans, String cur) {
        char[] ac=ans.toString().toCharArray();
        char[] cc =cur.toCharArray();
        ans.delete(0,ac.length);
        int n1,n2,add=0;
        for(int i=0,j=0;i<ac.length||j<cc.length;i++,j++){
            if(i>=ac.length) n1=0; else n1=ac[i]-'0';
            if(i>=cc.length) n2=0; else n2=cc[j]-'0';
            ans.append((n1+n2+add)%10);
            add=(n1+n2+add)/10;
        }
        if(add!=0){
            ans.append(add);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.multiply1("123","456");
    }
}
