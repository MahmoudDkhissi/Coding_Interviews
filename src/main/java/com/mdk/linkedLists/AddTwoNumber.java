package com.mdk.linkedLists;

public class AddTwoNumber {

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        boolean plusOne = false;
        addTwoNumbersRecursive(l1, l2, result, plusOne);
        return result;
    }

    public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        boolean r = false;
        int sum;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (r) {
                sum += 1;
            }
            r = (sum/10 > 0);
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }
        if (r) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public void addTwoNumbersRecursive(ListNode l1, ListNode l2, ListNode result, boolean plusOne) {
        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        if (plusOne) {
            sum += 1;
        }
        if (sum > 9) {
            plusOne = true;
            sum = sum % 10;
        }
        else {
            plusOne = false;
        }
        result.val = sum;
        if (l1 != null && l1.next != null && l2 != null && l2.next != null) {
            result.next = new ListNode();
            addTwoNumbersRecursive(l1.next, l2.next, result.next, plusOne);
        }
        else if (l1 != null && l1.next != null) {
            result.next = new ListNode();
            addTwoNumbersRecursive(l1.next, null, result.next, plusOne);
        }
        else if (l2 != null && l2.next != null) {
            result.next = new ListNode();
            addTwoNumbersRecursive(null, l2.next, result.next, plusOne);
        }
        else {
            if (plusOne) {
                result.next = new ListNode();
                result.next.val = 1;
            }
        }
    }

}
