package regex;

import java.util.Date;

/**
 * 一些简单的正则表达式练手代码:这种题实现形式有多样，只是效率不同
 * @author xzp
 *
 */
public class SimpleRegex {
	public static void main(String[] args) {
		String string = "2018-12-21 02:31:54"; // 替换成只有数字的字符串
		String[] result = string.split("\\D");
		for (int i = 0; i < result.length; i++) { // 最好不要这样写
			System.out.print(result[i]); // 输出结果
		}
	}
}
