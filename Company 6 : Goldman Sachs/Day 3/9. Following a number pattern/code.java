
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class Solution {
    static String printMinNumberForPattern(String S) {
        // code here
        char res[] = new char[S.length() + 1];
        int st = 1;

        for (int i = 0; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) == 'I') {
                res[i] = (char) (st + '0');
                st++;
                int t = i - 1;
                while (t >= 0 && res[t] == (char) 0) {
                    res[t] = (char) (st + '0');
                    st++;
                    t--;
                }
            }
        }
        return new String(res);
    }
}
