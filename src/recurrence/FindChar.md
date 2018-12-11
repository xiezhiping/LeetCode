# 题目要求
一串字符串可能包含a-z中的多个字符，如有重复，求出现字母字数最多那个以及次数，如果有多个则全部输出
## 解题思路
- 集合可以快速找到所有出现多次的数
- 用ArrayList有两个好处，一是排序，二是通过下标相减算出现具体次数
- 因为set是有序的，为了一致，将list排序后使用set的迭代器遍历
- 同时确保哪些数才是真正次数最多，maxList中的数据并不是都次数最多，通过以下代码进行跳过那些比真正max小的数据

```
		int index = 0;
		for(int i = 0; i < maxList.size(); i++) {
			if(maxList.get(i).equals(maxString)) {
				index = i;
				break;
			}
		}
		
```