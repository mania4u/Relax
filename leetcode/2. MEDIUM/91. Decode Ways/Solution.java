/* 
	f[i]表示从头到第i位有多少种方法
	那么就是
	i如果是能和i-1构成 1..26...
	那么f[i] = f[i-1] + f[i-2]
	意思就是i单独的一种方法，和与i-1一起构成两位的方法。
	如果不能f[i] = f[i-1]
*/

public class Solution{
	public int numDecodings(String s){
		if(s == null || s.length() == 0) return 0;
		if(s.charAt(0) == '0') return 0;
		int[] ways = new int[s.length() + 1];
		ways[0] = 1;
		ways[1] = 1;
		for(int i = 1; i < s.length(); i++){
			int num = Integer.parseInt(s.substring(i - 1, i + 1));
			// substring(i-1, i+1)中的i-1是包含在内的，i+1不包含在内
			if(s.charAt(i) != '0') ways[i + 1] += ways[i];	
			// 因为不等于0，就代表着他可以用一个字母来decode
			// 如果等于0的话，那他就必须跟先前那个字符构成一个10到26的两位数才行
			if(num > 9 && num < 27) ways[i + 1] += ways[i - 1];
			// ways[i+1]=ways[i+1]+way[i-1]是因为可以将第i-1位和第i位看成一个整体
			// 这样则需要加上先前ways[i-1]，也就是dp[i-1]中所含的所有可能性
		}
		return ways[ways.length - 1];
	}
}