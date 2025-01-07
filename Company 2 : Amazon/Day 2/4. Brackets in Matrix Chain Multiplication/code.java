//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    private static int get(int[] p, int n) {
        int[][] m = new int[n][n];
        int ans = 1000000000;

        for (int i = 1; i < n; i++) m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                m[i][i + L - 1] = Integer.MAX_VALUE;

                for (int k = i; k <= i + L - 2; k++) {
                    int q =
                        m[i][k] + m[k + 1][i + L - 1] + p[i - 1] * p[k] * p[i + L - 1];

                    if (q < m[i][i + L - 1]) {
                        m[i][i + L - 1] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    private static int find(String s, int[] p) {
        List<int[]> arr = new ArrayList<>();
        int ans = 0;

        for (char t : s.toCharArray()) {
            if (t == '(') {
                arr.add(new int[] {-1, -1});
            } else if (t == ')') {
                int[] b = arr.remove(arr.size() - 1);
                int[] a = arr.remove(arr.size() - 1);
                arr.remove(arr.size() - 1);
                arr.add(new int[] {a[0], b[1]});
                ans += a[0] * a[1] * b[1];
            } else {
                arr.add(new int[] {p[t - 'A'], p[t - 'A' + 1]});
            }
        }

        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            String result = Solution.matrixChainOrder(nums);
            if (get(nums, numsStr.length) == find(result, nums)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair<String,Integer> {
    String first;
    int second;

    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public static Pair<String, Integer> cal(int[] p, Pair<String, Integer>[][] dp, int i, int j) {
        if (i == j) {
            String st = "";
            st += (char) ('A' + i - 1);
            return new Pair(st, 0);
        }

        if (dp[i][j] != null && dp[i][j].second != -1) {
            return dp[i][j];
        }

        int max = Integer.MAX_VALUE;
        String sr = "";

        for (int k = i; k < j; k++) {
            Pair<String, Integer> pr1 = cal(p, dp, i, k);
            Pair<String, Integer> pr2 = cal(p, dp, k + 1, j);
            int x = pr1.second + pr2.second + p[i - 1] * p[k] * p[j];
            String s = "(" + pr1.first + pr2.first + ")";
            if (max > x) {
                max = x;
                sr = s;
            }
        }

        dp[i][j] = new Pair(sr, max);
        return dp[i][j];
    }

    static String matrixChainOrder(int p[]) {
         int n = p.length;
        Pair<String, Integer> dp[][] = new Pair[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair("", -1);
            }
        }

        Pair<String, Integer> pr = cal(p, dp, 1, n - 1);
        return pr.first;
    }

}
