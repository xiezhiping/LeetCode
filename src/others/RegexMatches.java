package others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	
	public static void main(String args[]) {
		String str = "wooooooow";
		System.out.println(str.replace("([a-zA-Z])\1{2} ", ""));
	}

}