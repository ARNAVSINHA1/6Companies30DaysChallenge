//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String cont : contact){
            trie.insert(cont);
        }
        
        for(int i = 1; i <= s.length(); i++){
            ArrayList<String> list = trie.getWords(s.substring(0,i));
            Collections.sort(list); // Sorting the list
            list = new ArrayList<>(new LinkedHashSet<>(list)); // Removing duplicates while maintaining orders
            if(list.isEmpty()){
                list.add("0");
            }
            result.add(list);
        }
        return result;
        
    }
    
    static class TrieNode{
        TrieNode arr[] = new TrieNode[26];
        boolean isEnd;
        ArrayList<String> words;
        TrieNode(){
            words = new ArrayList<>();
        }
    }
    
    static class Trie{
        TrieNode root;
        
        Trie(){
            root = new TrieNode();
        }
        
        void insert(String s){
            TrieNode curr = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(curr.arr[ch-'a']==null){
                    curr.arr[ch-'a'] = new TrieNode();
                }
                curr = curr.arr[ch-'a'];
                curr.words.add(s);
            }
            curr.isEnd = true;
        }
        
        ArrayList<String> getWords(String prefix){
            TrieNode curr = root;
            for(int i=0;i<prefix.length();i++){
                char ch = prefix.charAt(i);
                if(curr.arr[ch-'a']==null) return new ArrayList<>();
                curr = curr.arr[ch-'a'];
            }
            return curr.words;
        }
    }
}
