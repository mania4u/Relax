/*
	思路非常有意思的一道题，重点是要理解这么一个分组间排列关系
	对于n个数他有n!种排列，n-1个数则有(n-1)!种
	对于左边第一个数字，后续n-1个数字则有(n-1)!种排列，
	则我们可以看成n个小组，每组里面有(n-1)!个元素
	这样最高位可以从k/(n-1)!得出，
	注意：取得了这个元素后，要将这个元素从list里删除
	新的k则是k%(n-1)!的余数，以此进行循环
*/

public class Solution{
	public String getPermutation(int n, int k){
		k--;
		List<Integer> numList = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++)		// 添加1-n元素到numList
			numList.add(i);
		int factorial = 1;
		for(int i = 2; i < n; i++)		// 阶乘
			factorial *= i;
		StringBuilder res = new StringBuilder();
		int times = n - 1;
		while(times >= 0){
			int indexInList = k / factorial;
			res.append(numList.get(indexInList));	// 结果添加字符
			numList.remove(indexInList);	// 从numList删除已经添加的字符
			k = k % factorial;
			if(times != 0)	
				factorial = factorial / times;	// 循环时阶乘的每次递减
			times--;
		}
		return res.toString();
	}
}