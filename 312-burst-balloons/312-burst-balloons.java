class Solution {
    public int maxCoins(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int gap = 0; gap < arr.length; gap++) {
            int si = 0, ei = gap;
            while (ei < arr.length) {
                for (int k = si; k <= ei; k++) {
                    int leftVal = 1;
                    int rightVal = 1;
                    if (si != 0) {
                        leftVal = arr[si - 1];
                    }
                    if (ei != arr.length - 1) {
                        rightVal = arr[ei + 1];
                    }

                    int before = 0;
                    int after = 0;
                    if (si != k) {
                        before = dp[si][k - 1];
                    }
                    if (ei != k) {
                        after = dp[k + 1][ei];
                    }

                    dp[si][ei] = Math.max(dp[si][ei], before + after + (leftVal * rightVal * arr[k]));
                }
                si++;
                ei++;
            }

        }
        return dp[0][arr.length - 1];
    }
}