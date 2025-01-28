
//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;

        long expectedSoln = (long) (n * (n + 1)) / 2;
        long expectedSqrSoln = (long) (n * (n + 1) * (2 * n + 1)) / 6;

        long actualSoln = 0, actualSqrSoln = 0;
        for (int i = 0; i < n; i++) {
            actualSoln += arr[i];
            actualSqrSoln += (long) arr[i] * arr[i];
        }

        long x = actualSoln - expectedSoln;
        long y = (actualSqrSoln - expectedSqrSoln) / x;

        long X = (x + y) / 2;
        long Y = X - x;

        ans.add((int) X);
        ans.add((int) Y);

        return ans;
    }
}
