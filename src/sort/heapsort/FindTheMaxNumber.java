package sort.heapsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import wheels.MaxHeap;


/**
 * ��Ŀ������Ŀ¼�µ�README.md�ļ�
 * @author XZP
 *
 */
public class FindTheMaxNumber {
	public static void main(String[] args) {
		int row = 20;
		int column = 500;
		Random random = new Random();
		Integer[][] data = new Integer[row][column];
		// ��������
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				data[r][c] = random.nextInt(1000); // �������[0, 1000)��α�����
			}
			Arrays.sort(data[r]); // �����������������
		}
		// ��һ��map����ֵ�������ж�Ӧ���±�
		HashMap<Integer, ArrInfo> value2ArrInfo = new HashMap<>();
		// ��һ������洢���
		ArrayList<Integer> result = new ArrayList<>();
		// ��ʼ��һ������
		MaxHeap maxHeap = new MaxHeap(20);
		// �Ƚ�20��������Ե����ֵ���
		for (int i = 0; i < 20; i++) {
			maxHeap.push(data[i][499]);
			value2ArrInfo.put(data[i][499], new ArrInfo(i, 499));
		}
		// ѭ��500�Σ�ÿ��ȡһ��������
		int value;
		for (int i = 0; i < 500; i++) {
			value = maxHeap.pop();
			result.add(value);
			// �ҵ�value��Ӧ������Ȼ��ѡȡ���������һ������������
			int r = value2ArrInfo.get(value).getArr();
			int index = value2ArrInfo.get(value).getIndex();
			maxHeap.push(data[r][index - 1]); // ����ֵ��ѣ���������ǲ����ж�index�Ƿ�Խ��
			value2ArrInfo.put(data[r][index - 1], new ArrInfo(r, index - 1));
		}
		int size = result.size();
		System.out.println("���������ϣ��ܴ�С�� " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(result.get(i) + " ");
		}
	}
}
class ArrInfo {
	private int arr; // �洢������
	private int index; // �洢�������е�����
	public ArrInfo(int arr, int index) {
		this.arr = arr;
		this.index = index;
	}
	public int getArr() {
		return arr;
	}
	public int getIndex() {
		return index;
	}
	
}