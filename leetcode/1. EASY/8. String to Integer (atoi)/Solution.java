/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution {
	public int myAtoi(String str) {
		int i = 0;
		boolean sign = true;	
		// the sign for judging whether it's positive or negative
		int num = 0;
		long sum = 0;
		boolean flag = false;	
		// the flag for keeping there's no more sign after the first sign or after a number
		str = str.trim();
		if (str.length() == 0)
			return 0;
		while (i < str.length()) {
			if (str.charAt(i) == '+' && !flag) {
				sign = true;
				flag = true;	// no more sign after the first sign
			} else if (str.charAt(i) == '-' && !flag) {
				sign = false;
				flag = true;	// no more sign after the first sign
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				num = str.charAt(i) - '0';
				flag = true;	// no more sign after the any number
			} else
				break;
			i++;
			sum = sum * 10 + num;
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)		
			// keep the number in the scope of the integer
				return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return sign ? (int) sum : (int) -sum;
	}
}