import java.util.Arrays;

public class MinCoinChange {
    public static int minCoins(int[] coins, int sum) {
        int[] dp = new int[sum+1];

        Arrays.fill(dp,9999);
        dp[0]=0;

        for(int coin : coins){
            for(int i=coin;i<=sum;i++){
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[sum]==9999?-1:dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1,3, 4};
        int sum = 6;

        int result = minCoins(coins, sum);
        if (result == -1)
            System.out.println("No combination can make the sum " + sum);
        else
            System.out.println("Minimum coins needed for sum " + sum + " = " + result);
    }
}
