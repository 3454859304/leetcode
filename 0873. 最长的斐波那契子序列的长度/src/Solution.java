import com.sun.org.glassfish.gmbal.Description;
import com.sun.xml.internal.bind.v2.TODO;
import sun.misc.JavaIOFileDescriptorAccess;

import javax.xml.transform.Source;
import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 功能描述
 * 873. 最长的斐波那契子序列的长度
 *
 *如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr，找到 arr中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
 *
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
 * 例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）
 *
 * 示例 1：
 *
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 *
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *
 * 提示：
 *
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: PJY
 * @date: 2022年07月09日 13:49
 */
class Solution {
    /*
     * @Description  暴力二分和hash
     * @Date 2022/7/9 17:05
     * @Author PJY
     * @Param [int[]]
     * @return int
     **/
    public static int lenLongestFibSubseq(int[] arr) {

        int max = 2;
        HashMap<Integer,Integer> map = new HashMap<>(arr.length*4/3);

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        for (int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length-1;j++){

                int sum =arr[i]+arr[j];
                int temp = arr[j];
                int len =2;

                int flag;
                while(map.containsKey(sum)){
                    len++;
                    int temp2=sum;
                    sum+=temp;
                    temp=temp2;
                }

                if(len>max){
                    max=len;
                }
            }
        }

        if(max==2){
            return 0;
        }
        return max;
    }

    /*
     * @Description 动态规划解法
     * @Date 2022/7/9 17:07
     * @Author PJY
     * @Param [int[]]
     * @return int
     **/
    public static int lenLongestFibSubseq2(int[] arr){

        return 0;
    }

    public static void main(String[] args) {
        int array[]={1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(array));
    }
}


