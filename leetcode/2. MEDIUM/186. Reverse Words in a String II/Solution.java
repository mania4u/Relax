/*
	Given an input string, reverse the string word by word. 
	A word is defined as a sequence of non-space characters.
	The input string does not contain leading or trailing spaces 
	and the words are always separated by a single space.
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
	思路就是先将整个数组逐一反转
	然后根据" "，再进行一次反转即可
*/

public class Solution{
	public void reverseWords(char[] s){
		reverse(s, 0, s.length);
		for(int i =0, j = 0; j <= s.length; j++){
			if(j == s.length || s[j] == ' '){
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}

	private void reverse(char[] s, int begin, int end){
		for(int i = 0; i < (end - begin) / 2; i++){
			char tmp = s[begin + 1];
			s[begin + 1] = s[end - i - 1];
			s[end - i - 1] = tmp
		}
	}
}