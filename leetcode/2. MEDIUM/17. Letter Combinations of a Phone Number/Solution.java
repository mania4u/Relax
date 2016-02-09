/*
	思路：	初始化一个数组用来存储数字和字幕的关系，
		  	letterCombinations这个方法用来分隔输入的数字，并调用combine这个方法
		  	combine用来将每次输入数字对应的字母与后面的子母组进行匹配

*/

public class Solution{
	public static List<String> letterCombinations(String digits){
		String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new ArrayList<String>();
		if(digits.length() == 0) return result;
		result.add("");
		for(int i = 0; i < digits.length(); i++){
			result = combine(digitletter[digits.charAt(i) - '0'], result);
		}
		return result;
	}

		public static List<String> combine(String digit, List<String> l){
			List<String> result = new ArrayList<String>();
			for(int i = 0; i < digit.length(); i++){
				for(String x : l){
					result.add(x + digit.charAt(i));	// 用来匹配后面添加的子母组，并添加到result这个数组
				}
			}
			return result;
		}
	}
