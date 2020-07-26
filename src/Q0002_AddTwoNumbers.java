public class Q0002_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            if (l2 == null) {
                return null;
            }
        }
        if (l2 == null) return l1;

        // 直接相加
        int curVal = l1.val + l2.val;
        int carry = 0;
        if (curVal >= 10) {
            carry = 1;
            curVal -= 10;
        }
        ListNode res = new ListNode(curVal);
        ListNode cur = res;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            curVal = l1.val + l2.val + carry;
            carry = 0;
            if (curVal >= 10) {
                carry = 1;
                curVal -= 10;
            }
            cur.next = new ListNode(curVal);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curVal = l1.val + carry;
            carry = 0;
            if (curVal >= 10) {
                carry = 1;
                curVal -= 10;
            }
            cur.next = new ListNode(curVal);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curVal = l2.val + carry;
            carry = 0;
            if (curVal >= 10) {
                carry = 1;
                curVal -= 10;
            }
            cur.next = new ListNode(curVal);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return res;
    }
}
