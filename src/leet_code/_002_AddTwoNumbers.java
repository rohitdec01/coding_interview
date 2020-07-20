package leet_code;

public class _002_AddTwoNumbers {

    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
    reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

            Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(AddNumbers(l1, l2));
    }

    private static ListNode AddNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        ListNode output = null;
        ListNode currentOutput = null;

        int rem = 0;
        while (a != null || b != null) {
            int val1 = a.val;
            int val2 = b.val;

            int sum = rem + val1 + val2;
            rem = sum / 10;

            if (output == null) {
                output = new ListNode(0);
                currentOutput = output;
            }
            currentOutput.next = new ListNode(sum % 10);
            currentOutput = currentOutput.next;
            a = a.next;
            b = b.next;
        }

        return output.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
