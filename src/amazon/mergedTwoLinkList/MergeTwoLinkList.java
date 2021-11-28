package amazon.mergedTwoLinkList;

/*
    Merge two sorted linked list into one sorted linked lists.
 */
public class MergeTwoLinkList {

    public static LinkedListNode merge_sorted(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        LinkedListNode mergedHead = null;
        LinkedListNode mergedRoot = null;
        while (head1 != null || head2 != null) {
            LinkedListNode node;
            if (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    node = new LinkedListNode(head1.data);
                    head1 = head1.next;
                } else {
                    node = new LinkedListNode(head2.data);
                    head2 = head2.next;
                }

                if (mergedHead == null) {
                    mergedHead = node;
                } else {
                    mergedHead.next = node;
                }

                if (mergedRoot == null) {
                    mergedRoot = mergedHead;
                }
            } else {
                if (head1 == null) {
                    node = new LinkedListNode(head2.data);
                    head2 = head2.next;
                } else {
                    node = new LinkedListNode(head1.data);
                    head1 = head1.next;
                }
                mergedHead.next = node;
            }
            if (mergedHead.next != null) {

                mergedHead = mergedHead.next;
            }
        }
        return mergedRoot;
    }

    public static LinkedListNode merge_sorted2(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        LinkedListNode head = null;
        LinkedListNode root = null;

        while (head1 != null || head2 != null) {
            LinkedListNode linkedListNode = null;

            if (head1 == null) {
                linkedListNode = new LinkedListNode(head2.data);
                head2 = head2.next;
            } else if (head2 == null) {
                linkedListNode = new LinkedListNode(head1.data);
                head1 = head1.next;
            } else {
                if (head1.data < head2.data) {
                    linkedListNode = new LinkedListNode(head1.data);
                    head1 = head1.next;
                } else {
                    linkedListNode = new LinkedListNode(head2.data);
                    head2 = head2.next;
                }
            }

            if (head == null) {
                head = linkedListNode;
                root = head;
            } else {
                head.next = linkedListNode;
                head = head.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 8};
        int[] arr2 = new int[]{2, 4, 6, 20, 34};
        LinkedListNode list_head1 = LinkedList.create_linked_list(arr1);
        System.out.print("List1: ");
        LinkedList.display(list_head1);

        LinkedListNode list_head2 = LinkedList.create_linked_list(arr2);
        System.out.print("list2: ");
        LinkedList.display(list_head2);

        System.out.println("\nMerged:");

        LinkedListNode newHead = merge_sorted2(list_head1, list_head2);
        LinkedList.display(newHead);
    }
}

