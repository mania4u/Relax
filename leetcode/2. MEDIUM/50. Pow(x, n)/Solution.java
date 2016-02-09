public class Solution{
	public double pow(double x, int n){
		if(x == 0) return 0;
		if(n == 0 && x > 0) return 1;
		if(n < 0){
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
	}
}