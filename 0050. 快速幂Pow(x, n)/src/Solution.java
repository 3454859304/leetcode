/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月07日 16:14
 */
public class Solution {

    public double quickMul1(double x,int n){
        double res =1;
        double base=x;
        while(n>0){
            if((n&1)==1){
                res*=base;
            }
            base*=base;
            n>>=1;
        }
        return res;
    }

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        else if(n>0){
            return 1/quickMul1(x,-n);
        }else{
            return quickMul1(x,n);
        }
    }
    public double quickMul(double x,int n){
        if(n==1){
            return x;
        }
        double target=myPow(x,n/2);
        if((n&1)==0){
            return target*target;
        }else{
            return target*target*1/x;
        }
    }

    public static void main(String[] args) {
        System.out.println((-16)>>6);
    }

}
