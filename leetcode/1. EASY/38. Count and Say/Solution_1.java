/*
"Count and Say problem" Write a code to do following: 
n String to print 
0 1 
1 1 1    因为前面一行有1个1
2 2 1     因为前面一行有2个1
3 1 2 1 1  因为前面一行有1个2和1个1
... 
Base case: n = 0 print "1" 
for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case, digit 1 is seen 1 time in a row... so print "1 1" 
for n = 2, digit 1 is seen two times in a row, so print "2 1" 
for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1" 
for n = 4 you will print "1 1 1 2 2 1" 

Consider the numbers as integers for simplicity. e.g. if previous string is "10 1" then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"
*/

public class Solution {
	public String countAndSay(int n) {
		String str = "";
		while (n-- > 0)
			str = next_seq(str);
		return str;
	}
	public String next_seq(String str) {
		StringBuffer nextstr = new StringBuffer();
		if (str.equals("")) {
			nextstr.append("1");
			return nextstr.toString();
		}
		int count = 1;
		int i;
		char ch = str.charAt(0);
		for (i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				count++;
			else {
				nextstr.append(count).append(str.charAt(i - 1));
				ch = str.charAt(i);
				count = 1;
			}
		}
		nextstr.append(count).append(str.charAt(i - 1));
		return nextstr.toString();
	}
}