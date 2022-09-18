/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月08日 15:21
 */
class Solution {
    //dp+双指针
    public int jump0(int[] nums) {
        int len  = nums.length;
        int[] dp = new int[len];
        int j =0;
        for(int i = 1; i < len; i++){
            while(j+nums[j]<i) j++;
            dp[i]=dp[j]+1;
        }
        return dp[len - 1];
    }

    /*class Solution:
    def jump(self, nums: List[int]) -> int:
    n = len(nums)
    dp = [0 for i in range(n)]

            if n==1:
            return 0

    j = 0
            # dp[i] 表示到第 i 个位置需要的最少步数
        # i是代表当前能跳跃的最远位置
        for i in range(1, n):
            # 如果当前能到达的位置<最远需要到达的位置, j+1
            while j + nums[j] < i:
    j += 1
    dp[i] = dp[j] + 1

            return dp[n-1]*/
    /*class Solution {
        public:
        int jump(vector<int>& nums) {
            int n = nums.size();
            vector<int> dp(n);
            int start = 0;
            for(int i = 1; i<n; ++i){
                for(int j = start; j<i; ++j){
                    if(j+nums[j]>=i){
                        start = j;
                        dp[i] = dp[j] + 1;
                        break;
                    }
                }
            }
            return dp[n-1];
        }
    };*/

    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int step =0;
        int index=0;
        int next =index+nums[index];
        while(next<nums.length-1){
            int max =next--;
            //有元素遍历了两次
            while(next>index){
                if((next+nums[next])>(max+nums[max])){
                   max=next;
                }
                next--;
            }
            index=max;
            next =index+nums[index];
            step++;
        }
        return ++step;
    }
}
