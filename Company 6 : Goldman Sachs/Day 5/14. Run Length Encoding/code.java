//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder encodedString = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char ch = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            encodedString.append(ch);
            encodedString.append(count);
        }
        return encodedString.toString();
    }
}
    