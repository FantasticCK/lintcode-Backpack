package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = A[j] <= i ? A[j] : 0;
                    continue;
                }

                dp[i][j] = dp[i][j - 1];
                if (A[j] <= i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - A[j]][j - 1] + A[j]);
                }
            }
        }
        return dp[m][n - 1];
    }
}