package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 这是一段涉及java泛型擦除的例子
 * 通过API文档可以看到Iterator迭代器也是需要泛型参数的，如果不添加泛型参数，返回的结果是Object类型
 * 所以可以通过注释1，注释2两处进行不同的修改，两种修改方式即可，否则会编译错误
 * @author 谢之平
 *
 */
public class GenericErasure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Welcome");
		list.add("to");
		list.add("ZJU");
		for (Iterator i = list.iterator(); i.hasNext();) {  // 代码2
//		for (Iterator<String> i = list.iterator(); i.hasNext();) {  // 注释2
//			String string = i.next();  // 注释1
			String string = (String)i.next();  // 代码1
			System.out.println(string);
		}
	}

}
