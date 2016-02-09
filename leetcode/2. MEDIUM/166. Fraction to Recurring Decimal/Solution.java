/*
	这道题有这么几个重点：1. 溢出的问题，需要将int转换成long；2. 正负的问题
	只要是分数，那他表示的小数必然是有周期性规律的，也就是有理数
*/

public class Solution{
	public String fractionToDecimal(int numerator, int denominator){
		StringBuilder res = new StringBuilder();
		String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		res.append(sign);
		res.append(num / den);
		long remainder = num % den;
		if(remainder == 0) return res.toString();
		res.append(".");
		HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
		while(!hashMap.containsKey(remainder)){
			hashMap.put(remainder, res.length());
			// 神奇的地方。利用有理数必有周期性规律的性质
			// 将余数每次保存，直到除到有相同的余数，则退出循环
			res.append(10 * remainder / den);
			remainder = 10 * remainder % den;	
			// 这边是因为每一次做完除法，没除尽需要乘以10以保证下次能继续做除法
		}
		int index = hashMap.get(remainder);	
		// 最后保存的remainder，从哈希表里取出，取出的是第一次保存的remainder的index号码
		// 也就是在这边插入左括号“(”
		res.insert(index, "(");
		res.append(")");
		return res.toString().replace("(0)", "");
	}
}