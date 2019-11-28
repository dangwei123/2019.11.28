你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int[] res1=new int[nums.length];
        res1[1]=nums[0];
        for(int i=2;i<nums.length;i++){
            res1[i]=Math.max(res1[i-2]+nums[i-1],res1[i-1]);
        }
        int[] res2=new int[nums.length];
        res2[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            res2[i]=Math.max(res2[i-2]+nums[i],res2[i-1]);
        }
        return Math.max(res1[nums.length-1],res2[nums.length-1]);
    }
}

给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,4);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++)
            dp[i]=Math.min(dp[i],dp[i-j*j]+1);
        }
        return dp[n];
    }
}

给定一个无序的整数数组，找到其中最长上升子序列的长度。
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] res=new int[nums.length];
        int maxlen=0;
        for(int num:nums){
            int l=0;
            int r=maxlen;
            while(l<r){
                int mid=(l+r)>>>1;
                if(res[mid]<num){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            res[l]=num;
            if(l==maxlen){
                maxlen++;
            }
        }
        return maxlen;
    }
}

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
       for(int i=1;i<=amount;i++){
           for(int j=0;j<coins.length;j++){
               if(coins[j]<=i){
                   dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
               }
           }
       }
       return dp[amount]==(amount+1)?-1:dp[amount];
    }
}

给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(11-i);
        }
        return dp[n];
    }
}


给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int res=0;
        dp[0][0]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                dp[i][j]=A[i-1]==B[j-1]?dp[i-1][j-1]+1:0;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}

