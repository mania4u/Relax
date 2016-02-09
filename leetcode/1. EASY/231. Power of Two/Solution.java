/*
	// 如果一个数是2的次方数的话，那么它的二进数必然是最高位为1，其它都为0，
	那么如果此时我们减1的话，则最高位会降一位，其余为0的位现在都为变为1，
	那么我们把两数相与，就会得到0，用这个性质也能来解题。
*/

public class Solution{
	public boolean isPowerOfTwo(int n){
		return n > 0 && (n & (n - 1)) == 0; 
	}
}