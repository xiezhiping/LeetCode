package regex;

import java.util.Date;

/**
 * һЩ�򵥵�������ʽ���ִ���:������ʵ����ʽ�ж�����ֻ��Ч�ʲ�ͬ
 * @author xzp
 *
 */
public class SimpleRegex {
	public static void main(String[] args) {
		String string = "2018-12-21 02:31:54"; // �滻��ֻ�����ֵ��ַ���
		String[] result = string.split("\\D");
		for (int i = 0; i < result.length; i++) { // ��ò�Ҫ����д
			System.out.print(result[i]); // ������
		}
	}
}
