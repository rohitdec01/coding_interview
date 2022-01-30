package leet_code.linkedList;

public class AddTwoNumbers {

    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
    reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

            Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.*/

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(2);
        l1.next = new LinkedListNode(4);
        l1.next.next = new LinkedListNode(3);

        LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(6);
        l2.next.next = new LinkedListNode(4);

        System.out.println(AddNumbers(l1, l2));
    }

    private static LinkedListNode AddNumbers(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode a = l1;
        LinkedListNode b = l2;

        LinkedListNode output = null;
        LinkedListNode currentOutput = null;

        int rem = 0;
        while (a != null || b != null) {
            int val1 = a.data;
            int val2 = b.data;

            int sum = rem + val1 + val2;
            rem = sum / 10;

            if (output == null) {
                output = new LinkedListNode(0);
                currentOutput = output;
            }
            currentOutput.next = new LinkedListNode(sum % 10);
            currentOutput = currentOutput.next;
            a = a.next;
            b = b.next;
        }

        return output.next;
    }
}