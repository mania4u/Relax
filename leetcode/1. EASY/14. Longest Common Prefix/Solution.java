public class Solution {
	public String longestCommonPrefix(String[] strs) {
		int minlength = Integer.MAX_VALUE;
		String prefix = "";
		int n = 0;
		if (strs.length == 0) return "";
		if (strs.length == 1) return strs[0];
		for (int i = 0; i <= strs.length - 1; i++) {    // judge how many strings are in the array
			if (strs[i].length() == 0) return "";
			else if (minlength > strs[i].length()) {
				minlength = strs[i].length();
				n = i;
			}
		}
		for (int index = 0; index <= minlength - 1; index++) {  // check the string one by one in the array
			char ch = strs[n].charAt(index);
			for (int i = 0; i <= strs.length - 1; i++) {        // check the character one by one in each string
				if (ch != strs[i].charAt(index))
					return prefix;
			}
			prefix += ch;
		}
		return prefix;
	}
}