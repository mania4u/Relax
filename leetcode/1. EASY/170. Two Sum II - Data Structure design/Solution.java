/*
	题目：
	Design and implement a TwoSum class. It should support the following operations: add and find.
	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.
	For example,
	add(1); add(3); add(5);find(4) -> true; find(7) -> false

	思路：
	1。 第一种思路（但不符合题目的空间复杂度要求，这种方法的时间复杂度O(n^2)）：
	add()：构成一个新的hash table，每当新的element添加，并将新的element与前面的所有的数字相加并添加到hash table内
	find()：只用来从hash table内，查找是否所要查找的数字在hash table内。

	2. 第二种思路：
	add(): 将新添加的值再附加一个映射值用来计算次数
	find(): 因为a+b=c，则b必然等于c-a，所以只需要从先前构成的hash table内找是否 存在c-a即可。
	注意，每次add()之前出现过的key，都是直接将key所映射的value覆盖，而不是重新添加一个相同的key
	因为hash table里不能出现重复的key
*/

public class TwoSum{
	Map<Integer, Integer> numToCountMap = new HashMap<>();
	
	public void add(int number){
		Integer counts = numToCountMap.get(number);		//  给添加的值再附加一个映射值用来计算次数
		counts = (counts == null) ? 1 : counts + 1;		// counts为null，便赋一个初值1
		numToCountMap.put(number, counts);				// 将number映射到counts
	}

	public boolean find(int value){
		for(Map.Entry<Integer, Integer> entry : numToCoun	tMap.entrySet(){		// entrySet()是key-value对的集合
			/* for (int b:a)等价于：
		for(int i = 0;i < a.length;i++){
   			int b = a[i];
   			System.out.println(b);
  		}
		*/
			int key = entry.getKey();
			int second = value - key;
			int counts = entry.getValue();
			if((second == key && counts > 1) || (second != key) && numToCountMap.containsKey(second)){
				// 数字相同的情况：counts > 1 || 数字不同的情况，直接从表内搜 
				return true
			}
		}
		return false
	}
}