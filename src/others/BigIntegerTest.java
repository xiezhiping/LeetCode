package others;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		BigInteger sum = new BigInteger("0");
		// ��ʾ 1 + 2 + 3 = 6 �����д��,�÷�������sum��ȻΪ0
		sum.add(one);
		sum.add(two);
		sum.add(three);
		System.out.println(sum.toString()); // 0
		// ��ȷ��д��:��ʾ�ķ���
		sum = sum.add(one);
		sum = sum.add(two);
		sum = sum.add(three);
		System.out.println(sum.toString()); // 6
	}

}
