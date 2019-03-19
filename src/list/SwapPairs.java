package list;
/**
 * 交换链表中两两节点: 1 -> 2 -> 3 -> 4   => 2 -> 1 -> 4 -> 3
 * @author 谢之平
 *
 */
public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode swap = list1;
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		ListNode head = list1;
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		head = swapPairs(swap);;
		System.out.println("交换之后：");
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
        if (head == null) { // 一定每次都要判空
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode temp = null;
        ListNode tail = null; // 指向每次迭代完之后的尾节点
        if (second == null) {
            return head;
        }
        if (second.next == null) {
            head = second;
            second.next = first;
            first.next = null;
            return head;
        }
        head = second;
        temp = second.next; // 获取下一次迭代的头结点
        second.next = first;
        first.next = null;
        while (temp != null && temp.next != null) {
            tail = first;
            first = temp;
            second = temp.next;
            temp = second.next;
            // 开始交换
            tail.next = second;
            second.next = first;
            first.next = null;
        }
        if (temp != null) {
            first.next = temp;
        }
        return head;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
