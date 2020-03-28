package list;

/**
 * 从尾到头打印链表
 * @author 谢之平
 *
 */
public class FromTailToHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node oldHead = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		oldHead.next = node2;
		node2.next = node3;
		System.out.println("改变前：");
		print(oldHead);
		// 调转
		Node newHead = exchange(oldHead);
		System.out.println("改变后：");
		print(newHead);
	}
	public static Node exchange(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node pre = null;
		Node Next = head.next;
		while (Next != null) {
			head.next = pre;
			pre = head;
			head = Next;
			Next = Next.next;
		}
		head.next = pre;
		return head;
	}
	public static void print(Node head) {
		if (head == null) {
			System.out.println("链表为空！");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}
class Node {
	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
}
