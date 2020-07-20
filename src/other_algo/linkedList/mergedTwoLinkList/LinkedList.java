package other_algo.linkedList.mergedTwoLinkList;

public class LinkedList {
    public static LinkedListNode create_linked_list(int[] arr) {
        LinkedListNode head = null;
        LinkedListNode root = null;
        for (int val : arr) {
            LinkedListNode node = new LinkedListNode(val);
            if (head != null) {
                head.next = node;
            } else {
                root = node;
            }
            head = node;
        }
        return root;
    }

    public static void display(LinkedListNode root) {
        while (root != null) {
            System.out.println(root.data);
            root = root.next;
        }
    }
}
