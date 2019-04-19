package list;

import java.io.*;
import java.util.*;

/**
 * ���Լ������ˣ����ⲻ�ѣ����Ǻܿ���Կ�ָ��Ŀ��ǣ�����
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
      
      ListNode first = head; // ÿ�ν����ĵ�һ���ڵ�
      ListNode second = head.next; // ÿ�ν����ĵڶ����ڵ�
      head = head.next;
      ListNode pre = new ListNode(0); // ÿ�ν����Ե�ǰһ������ڵ�
      while (first != null && first.next != null) {
         pre.next = second;
          // ����Ҫ�ݴ�second����һ���ڵ�
          ListNode temp = second.next; // ����Ϊ��
          second.next = first;
          first.next = null;
          pre = first; // ����preָ��
          if (temp == null) {
              break;
          }
          first = temp;
          second = first.next;
      }
      if (first != null && second == null) { // �������״�secondָ�����������ʱ������
          pre.next = first;
      }
      return head;
  }
}