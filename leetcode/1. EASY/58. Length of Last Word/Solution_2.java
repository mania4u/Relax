// function: lastIndexOf()

public class Solution {
	public int lengthOfLastWord(String s) {
		String ss = s.trim();
		return ss.length() - 1 - ss.lastIndexOf(' ');
	}
}