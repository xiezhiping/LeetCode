package list;

/**
 * ��β��ͷ��ӡ����
 * @author л֮ƽ
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
		System.out.println("�ı�ǰ��");
		print(oldHead);
		// ��ת
		Node newHead = exchange(oldHead);
		System.out.println("�ı��");
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
			System.out.println("����Ϊ�գ�");
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
