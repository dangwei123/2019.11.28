给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
class Solution {
    public int maxSubArray(int[] nums) {
      int sum=0;
      int maxsum=nums[0];
      for(int i=0;i<nums.length;i++){
          if(sum>0){
            sum+=nums[i];
          }else{
              sum=nums[i];
          }
          maxsum=Math.max(maxsum,sum);
      }
      return maxsum;
    }
}

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
       int min=prices[0];
       int max=0;
       for(int i=1;i<prices.length;i++){
           min=Math.min(min,prices[i-1]);
           max=Math.max(max,prices[i]-min);
       }
       return max;
    }
}

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
       int[] dp=new int[nums.length+1];
       dp[1]=nums[0];
       for(int i=2;i<dp.length;i++){
           dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
       }
       return dp[nums.length];
    }
}


数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] res=new int[cost.length];
       res[0]=cost[0];
       res[1]=cost[1];
       for(int i=2;i<res.length;i++){
           res[i]=Math.min(res[i-1],res[i-2])+cost[i];
       }
       return Math.min(res[res.length-1],res[res.length-2]);
    }
}

给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
class Solution {
    public int maxProduct(int[] nums) {
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        int res=nums[0];
        max[0]=nums[0];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            max[i]=Math.max(Math.max(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            min[i]=Math.min(Math.min(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            res=Math.max(res,max[i]);
        }
        return res;
    }
}

