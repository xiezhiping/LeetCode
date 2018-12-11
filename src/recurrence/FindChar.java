package recurrence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 从给定字符串中查找出现最多的那个字母和次数，如果有多个则都求出
 * @author 谢之平
 *
 */
public class FindChar {
	public static void main(String[] args) {
		String input = "abbcccddd";
		new FindChar().doString(input);
	}
	public void doString(String input) {
		char[] chars = input.toCharArray();
		ArrayList lists = new ArrayList<>();
		TreeSet set = new TreeSet<>();
		for (int i = 0; i < chars.length;i++) {
			lists.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i]));
		}
		System.out.println("set: " + set);
		Collections.sort(lists);
		System.out.println("sorted lists: " + lists);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < lists.size();i++) {
			sb.append(lists.get(i));
		}
		input = sb.toString();
		System.out.println(input);
		int max = 0;
		String maxString = "";
		ArrayList maxList = new ArrayList<>();
		Iterator its = set.iterator();
		while(its.hasNext()) {
			String os = (String)its.next();
			int begin = input.indexOf(os);
			int end = input.lastIndexOf(os);
			int value = end - begin + 1;
			if (value > max) {
				max = value;
				maxString = os;
				maxList.add(os);
			} else if(value == max) {
				maxList.add(os);
			}
		}
		int index = 0;
		for(int i = 0; i < maxList.size(); i++) {
			if(maxList.get(i).equals(maxString)) {
				index = i;
				break;
			}
		}
		System.out.println("max data:");
		for (int i = 0; i < maxList.size(); i++) {
				System.out.println(maxList.get(i) + " ");
	}
		System.out.println();
		System.out.println("max:" + max);
	}
	
}
