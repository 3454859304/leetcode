/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月28日 16:16
 */
public class Solution {
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            /*if(res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10){
                return 0;
            }*/
            int temp= res;
            res=res*10+x%10;
            if(res/10!=temp){
                return 0;
            }
            x=x/10;
        }
        return res;
    }
}
