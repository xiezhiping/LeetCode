package recurrence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Solution {
	public static boolean flag = false;
	public static void main(String [] args) {
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		String s = "leetcode";
		System.out.println(new Solution().wordBreak(s, dict));
	}
    public boolean wordBreak(String s, Set<String> dict) {
    	ArrayList<String> ca = new ArrayList<>(dict);
    	System.out.println(ca + "" + ca.isEmpty());
    	get(ca, "", s);
       return flag; 
    }
    private static void get(List ca, String prefix, String s) {
    	if (ca.isEmpty()) {
    		if (prefix.equals(s)) {
    			flag = true;
    			return;
    		}
    	}
    	for (int i = 0; i < ca.size(); i++) {
    		List temp = new LinkedList<>(ca);
    		get(temp, prefix + temp.remove(i), s);
    	}
    }
}
