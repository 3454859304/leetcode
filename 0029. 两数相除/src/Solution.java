/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月06日 17:57
 */
public class Solution {
                          //被除数       //除数
    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean sign = false; // false 代表 商为正数
        if(dividend > 0) {
            dividend = -dividend;
            sign=!sign;
        }
        if(divisor > 0) {
            divisor = -divisor;
            sign=!sign;
        }

        int result=0;
        if(dividend > divisor){
            result=0;
        }else if(dividend==divisor){
            result=1;
        }else{
            int left = 1;
            int right = Integer.MAX_VALUE;
            while (left <= right) {
                // 注意溢出，并且不能使用除法
                int mid = left + ((right - left) >> 1);
                //我懒得写快乘来判断了
                if(mid>dividend/divisor){
                    right=mid-1;
                }else{
                    result=mid;
                    if(left==right){
                        break;
                    }
                    left=mid+1;
                }
            }

        }

        if(sign){
            return -result;
        }
        return result;
    }

    //优解
    public int divide(int dividend, int divisor) {
        //TODO 两数相乘优解 用 负数表示被除数和除数   并且用负数存正数答案的商;
        return 1^1;
    }


    public static void main(String[] args) {

        System.out.println((-16)>>1);

        //Solution solution = new Solution();
        //System.out.println(solution.divide(2147483647, 2));
    }
}
