/*
	思路: 	先创建一个新的数组，用来存储每个num1和num2对位的每个digit的乘积
			利用普通的进位计算便能得出答案
*/

public class Solution{
	public String multiply(String num1, String num2){
		int n1 = num1.length(), n2 = num2.length();
		int[] products = new int[n1 + n2];
		for(int i = n1 - 1; i >= 0; i--){
			for(int j = n2 - 1; j >= 0; j--){
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				products[i + j + 1] += d1 * d2;
			}
		}

		int carry = 0;
		for(int i = products.length - 1; i >= 0; i--){
			int tmp = (products[i] + carry) % 10;
			carry = (products[i] + carry) / 10;
			products[i] = tmp;	
		}
		StringBuilder sb = new StringBuilder();
		for(int num : products) sb.append(num);	
		while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);	
		// 防止多个"0"的产生，例如"0", "0"，没有这条语句则会产生"00"的结果
		return sb.length() == 0 ? "0" : sb.toString();
	}
}