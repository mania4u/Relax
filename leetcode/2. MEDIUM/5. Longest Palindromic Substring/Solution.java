// 思路就是先设立一个判断回文的方法，然后在循环中根据奇数还是偶数来判断是否有回文
// 时间复杂度O(n^2)，空间复杂度O(字符串长度)即O(1)

public class Solution{
	public boolean isPalindrome(String s, int startIndex, int endIndex){
		for(int i = startIndex, j = endIndex; i <= j; i++, j--){
			if(s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
    
    public String longestPalindrome(String s){
		int n = s.length();
		int longestLen = 0;
		int longestIndex = 0;

		for(int currentIndex = 0; currentIndex < n; currentIndex++){
			if(isPalindrome(s, currentIndex - longestLen, currentIndex)){	// 判断偶数情况的palindrome
				longestLen += 1;
				longestIndex = currentIndex;
			}else if(currentIndex - longestLen - 1 >= 0 && isPalindrome(s, currentIndex - longestLen - 1, currentIndex)){
				// 判断奇数情况的palindrome
				longestLen += 2;
				longestIndex = currentIndex;
			}
		}
		longestIndex++;
		return s.substring(longestIndex - longestLen, longestIndex);
	}
}