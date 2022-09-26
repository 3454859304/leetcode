import java.io.Serializable;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月24日 14:59
 */
public class Solution {

    public double quickMul(double x,int n){
        double res =1;
        double base=1/x;
        while(n<0){
            if((n&1)==1){
                res*=base;
            }
            base*=base;
            n/=2;
        }
        return res;
    }

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        else if(n>0){
            return 1/quickMul(x,-n);
        }else{
            return quickMul(x,n);
        }
    }

    public double quickMul1(double x,int n){
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
}

