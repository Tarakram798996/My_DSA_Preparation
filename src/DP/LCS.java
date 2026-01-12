public class LCS {
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Reconstruct the LCS string
        StringBuilder lcsStr = new StringBuilder();
        int i=m,j=n;
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                lcsStr.append(X.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        lcsStr.reverse();
        System.out.println("LCS: " + lcsStr);
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int length = lcs(X, Y);
        System.out.println("Length of LCS: " + length);
    }
}
