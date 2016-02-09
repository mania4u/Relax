// “求出最左开始相同的部分”的变形体
// 例如"11101 11"和"11101 01" 返回"11101 00"

public class Solution{
    public int rangeBitwiseAnd(int m, int n){
        int r = Integer.MAX_VALUE;
        while((m & r) != (n & r))
            r = r << 1;
        return n & r;
    }
}