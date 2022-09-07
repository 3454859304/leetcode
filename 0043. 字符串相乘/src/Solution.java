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

    //反转字符串相加： 45+87=231
    private void stringAddto(StringBuilder ans, String cur) {
        char[] ac=ans.toString().toCharArray();
        char[] cc =cur.toCharArray();
        ans.delete(0,ac.length);
        int n1,n2,add=0;
        for(int i=0,j=0;i<ac.length||j<cc.length;i++,j++){
            if(i>=ac.length) n1=0; else n1=ac[i];
            if(i>=cc.length) n2=0; else n2=cc[j];
            ans.append((n1+n2+add)%10);
            add=(n1+n2+add)/10;
        }
        if(add!=0){
            ans.append(add);
        }
    }

    public static void main(String[] args) {
        //TODO test
    }
}
