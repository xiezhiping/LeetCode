package intern;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个整数n,求满足n对括号规则组成的字符串
 * @author xzp
 *
 */
public class Solution {
	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		for(String string : list) {
			System.out.println(string);
		}
	}
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        search(result, "", 1, 0,'(',n*2);
        return result;
    }
    /**
    *@result 存放符合条件的结果
    *@step 当前递归的步数
    *@tempString没递归一次得到的括号字符串
    *@ left、right分别表示左括号数量、右括号数量
    *@now当前选的括号类别
    *@总的步数 ： 一般为题目n的两倍
    */
    public static void search(List<String> result, String tempString, int left, int right,char now, int sumStep) {
        if (left < right || left > sumStep / 2 || right > sumStep / 2) {
            return; // 不符合要求
        }
        if ( left == right && sumStep == left + right) {
            result.add(tempString + now);
        }
        search(result, tempString + now, left + 1, right,'(',sumStep);
        search(result, tempString + now, left, right+1,')',sumStep);
    }
}
