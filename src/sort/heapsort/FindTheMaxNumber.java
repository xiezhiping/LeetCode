package sort.heapsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import wheels.MaxHeap;


/**
 * 题目描述见目录下的README.md文件
 * @author XZP
 *
 */
public class FindTheMaxNumber {
	public static void main(String[] args) {
		int row = 20;
		int column = 500;
		Random random = new Random();
		Integer[][] data = new Integer[row][column];
		// 数据生成
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				data[r][c] = random.nextInt(1000); // 随机生成[0, 1000)的伪随机数
			}
			Arrays.sort(data[r]); // 对数组进行升序排列
		}
		// 用一个map来存值在数组中对应的下标
		HashMap<Integer, ArrInfo> value2ArrInfo = new HashMap<>();
		// 用一个数组存储结果
		ArrayList<Integer> result = new ArrayList<>();
		// 初始化一个最大堆
		MaxHeap maxHeap = new MaxHeap(20);
		// 先将20个数组各自的最大值入堆
		for (int i = 0; i < 20; i++) {
			maxHeap.push(data[i][499]);
			value2ArrInfo.put(data[i][499], new ArrInfo(i, 499));
		}
		// 循环500次，每次取一个最大的数
		int value;
		for (int i = 0; i < 500; i++) {
			value = maxHeap.pop();
			result.add(value);
			// 找到value对应的数组然后选取该数组的下一个最大数放入堆
			int r = value2ArrInfo.get(value).getArr();
			int index = value2ArrInfo.get(value).getIndex();
			maxHeap.push(data[r][index - 1]); // 将该值入堆，很巧妙的是不用判断index是否越界
			value2ArrInfo.put(data[r][index - 1], new ArrInfo(r, index - 1));
		}
		int size = result.size();
		System.out.println("结果计算完毕，总大小： " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(result.get(i) + " ");
		}
	}
}
class ArrInfo {
	private int arr; // 存储数组编号
	private int index; // 存储在数组中的索引
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