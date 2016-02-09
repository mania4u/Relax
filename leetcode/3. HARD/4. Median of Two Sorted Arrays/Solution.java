/*
    重点： 将中位数看成找到第k个数的题目
           对称操作，小只的切一半，大只的那边对称的切小只的那一半，而不是切大只的一半
    思路：http://www.cnblogs.com/springfor/p/3861890.html
          http://blog.csdn.net/Hackbuteer1/article/details/7584838
*/

public class Solution{
	public double findMedianSortedArrays(int A[], int B[]){
        int k = A.length + B.length;
        if(k % 2 == 0)
            return (findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1) + findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2)) / 2.0;
        else 
            return findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1);
    }
 
    public double findK(int a[], int s1, int e1, int b[], int s2, int e2, int x){
    /* 
        参数:
        数组a，数组a的起始坐标，数组a的结束坐标
        数组b，数组b的其实坐标，数组b的结束坐标
        x为2数组的中位数序号
        IMPORTANT: 迭代后x的值随数组而改变
    */
        int m = e1 - s1 + 1;    // 动态数组a的长度
        int n = e2 - s2 + 1;    // 动态数组b的长度
        if(m > n) 
            return findK(b, s2, e2, a, s1, e1, x);   
        // 因为下面的情况都是m<n的情况，所以当m>n则需要颠倒
        if(s1 > e1) 
            return b[s2 + x - 1];  
        /* 两种情况
        1. 数组a不存在，返回数组b的值
        2. 因为s1+midA可能导致两者之和大于e1
        */
        if (s2 > e2) 
            return a[s1 + x - 1];  // 与上面类似
        if (x == 1) 
            return Math.min(a[s1], b[s2]);  
        // 此时应该元素只会剩下2或者3个
        int midA = Math.min(x / 2, m), midB = x - midA;  
        // IMPORTANT: 保证a的长度不会超过b，也就是上面备注写的“只切小的那一半”
        if (a[s1 + midA - 1] < b[s2 + midB - 1])               
            return findK(a, s1 + midA, e1, b, s2, e2, x - midA);
        // 每进行findK()，当数组a的中位数<数组b的中位数
        // 那0到midA-1这些元素都可以舍去，同时x的序号从原来的x变成x-midA
        else if (a[s1 + midA - 1] > b[s2 + midB - 1]) 
            return findK(a, s1, e1, b, s2 + midB, e2, x - midB);     
        else
            return a[s1 + midA - 1];    
        // 正巧数组a的中位数和数组b的中位数是一样的，直接返回任意一组的中位数
    }
}