/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (ListNode list : lists) {
            while (list != null) {
                if (max < list.val) {
                    max = list.val;
                }
                if (min > list.val) {
                    min = list.val;
                }
                list = list.next;
            }
        }

        ListNode[] table = new ListNode[max - min + 1];

        for (int i = lists.length - 1; i >= 0; i--) {
            ListNode node = lists[i];
            while (node != null) {
                ListNode temp = node.next;
                node.next = table[node.val - min];
                table[node.val - min] = node;
                node = temp;
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for (ListNode list : table) {
            if (list != null) {
                cur.next = list;
                while (list.next != null) {
                    list = list.next;
                }
                cur = list;
            }
        }

        return dummy.next;
    }
}
