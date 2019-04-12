package intern;

import java.util.ArrayList;
import java.util.List;
/**
 * ����һ������n,������n�����Ź�����ɵ��ַ���
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
    *@result ��ŷ��������Ľ��
    *@step ��ǰ�ݹ�Ĳ���
    *@tempStringû�ݹ�һ�εõ��������ַ���
    *@ left��right�ֱ��ʾ����������������������
    *@now��ǰѡ���������
    *@�ܵĲ��� �� һ��Ϊ��Ŀn������
    */
    public static void search(List<String> result, String tempString, int left, int right,char now, int sumStep) {
        if (left < right || left > sumStep / 2 || right > sumStep / 2) {
            return; // ������Ҫ��
        }
        if ( left == right && sumStep == left + right) {
            result.add(tempString + now);
        }
        search(result, tempString + now, left + 1, right,'(',sumStep);
        search(result, tempString + now, left, right+1,')',sumStep);
    }
}
