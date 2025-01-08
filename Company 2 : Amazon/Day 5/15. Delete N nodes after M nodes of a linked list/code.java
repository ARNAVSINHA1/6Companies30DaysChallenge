//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            String str2[] = read.readLine().trim().split(" ");

            int n = Integer.parseInt(str2[0]);
            int m = Integer.parseInt(str2[1]);
            new Solution().linkdelete(head, n, m);
            printList(head);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    static void linkdelete(Node head, int n, int m) {
        
        Node curr = head;
        Node prev = curr;
        
        for(int i=0; curr!=null; i++){
            if(i!=0&&i%m==0){
                int j=n;
                while(j>0&&prev!=null&&curr!=null){
                    prev.next = curr.next;
                    curr = curr.next;
                    j--;
                }
            }
            prev = curr;
            if(curr!=null)
                curr = curr.next;
           
        }
       
        
        head = prev;
    }
}
