package Array.easy;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RemoveDuplicatesFromSortedList83 {

    ListNode head;

    public static void main(String[] args) {

        // ListNode listNode = new RemoveDuplicatesFromSortedList83().new ListNode(1);

        // ListNode head = deleteDuplicates(listNode);

        // int[] seen = { 2, 3, 4, 6, 7, 8 };
        // RemoveDuplicatesFromSortedList83.deleteDuplicates(seen);
        RemoveDuplicatesFromSortedList83 ll = new RemoveDuplicatesFromSortedList83();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(13);
        ll.addFirst(13);
        ll.addLast(15);
        ll.printList();
        ll.deleteFirst();
        ll.printList();
        ll.deletelast();
        ll.printList();
        // ListNode listNode = new ListNode(13, new ListNode(13, new ListNode(15)));
        // listNode.val = 13;
        // RemoveDuplicatesFromSortedList83.deleteDuplicates(listNode);
        // ll.printList();

        // System.out.println(ll.toString());
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode currNode = head;
        ListNode secondNode = currNode.next;
        System.out.println(currNode.val + " " + secondNode.val);
        while (currNode.val == secondNode.val) {
            secondNode = secondNode.next;
            System.out.println(currNode.val + " " + secondNode.val);
        }
        System.out.println(currNode.next.val + " " + secondNode.val);
        return head.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void deletelast() {

        ListNode currNode = head;
        ListNode secondLastNode = currNode.next;

        if (head == null) {
            return;
        }

        while (currNode != null) {
            if (secondLastNode.next == null) {
                currNode.next = null;
                return;
            }
            currNode = currNode.next;
            secondLastNode = secondLastNode.next;
        }
    }

    public void printList() {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }
}
