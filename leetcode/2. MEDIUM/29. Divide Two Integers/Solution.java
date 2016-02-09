// 递归解法

public class Solution{
	public int divide(int dividend, int divisor) {
	    long result = divideLong(dividend, divisor);
	    return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
	}


	public long divideLong(long dividend, long divisor) {
	    boolean negative = dividend < 0 != divisor < 0;
	    // Make dividend and divisor unsign
	    if (dividend < 0) dividend = -dividend;
	    if (divisor < 0) divisor = -divisor;
	    if (dividend < divisor) return 0;

	    // Sum divisor 2, 4, 8, 16, 32 .... times
	    long sum = divisor;
	    long divide = 1;
	    while ((sum + sum) <= dividend) {
	        sum += sum;
	        divide += divide;
	    }

	    // Make a recursive call for (devided-sum) and add it to the result
	    return negative ? -(divide + divideLong((dividend - sum), divisor)) :
	        (divide + divideLong((dividend - sum), divisor));
	}
}