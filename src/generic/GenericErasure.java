package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * ����һ���漰java���Ͳ���������
 * ͨ��API�ĵ����Կ���Iterator������Ҳ����Ҫ���Ͳ����ģ��������ӷ��Ͳ��������صĽ����Object����
 * ���Կ���ͨ��ע��1��ע��2�������в�ͬ���޸ģ������޸ķ�ʽ���ɣ������������
 * @author л֮ƽ
 *
 */
public class GenericErasure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Welcome");
		list.add("to");
		list.add("ZJU");
		for (Iterator i = list.iterator(); i.hasNext();) {  // ����2
//		for (Iterator<String> i = list.iterator(); i.hasNext();) {  // ע��2
//			String string = i.next();  // ע��1
			String string = (String)i.next();  // ����1
			System.out.println(string);
		}
	}

}
