/*
思路：解题思路：典型问题, palindrome number回文数即正着读和反着读都一样的数据。
                 1. 负数不能是回文数.
                 2. 不能尝试将integer变string处理这样有extra space不满足条件。
                 3. 在得到逆序数值时，再次注意overflow的情况！！
*     我们尝试采用一种更generic的方法来解决，就是对integer进行求商求余数不断获取到这个integer的每一位digit,
* 然后逆向根据每一位所在的权值累加求和得到reversed integer，然后和之前的数进行比较看是否相等，相等即为palindrome.
* 因此首先我们得获取到integer的数字位数，目的是为了之后的权值.通过不断除以10得到商,来统计数字位数（别忘了while跳出循环后还差一digit）
* 然后我们通过mod 10从个位数字开始不断得到每一位digit, 然后将其作为逆向基数乘以相应权值，不断累加得到新的逆序数据，最后注意逆序
* 数据有可能overflow的情况！
*/
public class Solution{
	public boolean isPalindrom(int x){
		if(x < 0) return false;
		if (reverse(x) == x) return true;
		else return false;
	}

	public static int reverse(int x) {
		boolean neg = false;
		if(x < 0){
			x = -x;
			neg = true;
		}
		int result = 0;
		while (x != 0){
			result = 10 * result + x % 10;
			x /= 10;
		}
		if(neg) {
			return -result;
		}
		return result;
	}
}