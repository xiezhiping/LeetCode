package list;

import java.io.*;
import java.util.*;

/**
 * 被自己坑死了，问题不难，但是很考察对空指针的考虑！！！
 * @author xzp
 *
 */
public class ExchangTwoNode {
  public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode two = new ListNode(2);
      ListNode three = new ListNode(3);
      head.next = two;
      ListNode now = exchange(head);
      while (now != null) {
          System.out.println(now.val);
          now = now.next;
      }
  }
  public static ListNode exchange(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
      
      ListNode first = head; // 每次交换的第一个节点
      ListNode second = head.next; // 每次交换的第二个节点
      head = head.next;
      ListNode pre = new ListNode(0); // 每次交换对的前一个虚拟节点
      while (first != null && first.next != null) {
         pre.next = second;
          // 首先要暂存second的下一个节点
          ListNode temp = second.next; // 可能为空
          second.next = first;
          first.next = null;
          pre = first; // 更换pre指向
          if (temp == null) {
              break;
          }
          first = temp;
          second = first.next;
      }
      if (first != null && second == null) { // 这里容易错，second指针才是奇数的时候的情况
          pre.next = first;
      }
      return head;
  }
}