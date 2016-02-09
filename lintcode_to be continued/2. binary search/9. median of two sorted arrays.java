/*
    极其经典的一道二分法活用的题目，将寻找中位数化作寻找第k/2+1个数。
    这里有个比较巧妙的地方在于，两个数组总长度的一半=较小数组的一半+较大数组的一半(midB = k - midA)
    这样就巧妙的将2个没有关系的数组变相“合并”成了一个数组
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int k = A.length + B.length;
        if(k % 2 == 0){
            return (findk(A, 0, A.length - 1, B, 0, B.length - 1, k / 2) + findk(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1)) / 2.0;
        }else{
            return findk(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1);
        }
    }
    
    public double findk(int[] a, int s1, int e1, int[] b, int s2, int e2, int k){
        int m = e1 - s1 + 1;
        int n = e2 - s2 + 1;
        if(m > n){      
        // 下面所有的计算都需要满足m > n
        // 原因在于如果先定义midB = Math.min(n, k / 2)，midA = k - midB
        // 由于数组a长度较小，会造成越界的问题
            return findk(b, s2, e2, a, s1, e1, k);
        }
        if(s1 > e1){
        // 这种情况出现在数组a长度远小于数组b，且数组a的中位数小于数组b的中位数
            return b[s2 + k - 1];
        }
        if(s2 > e2){
        // 与上面类似，数组b长度远小于数组a，且数组b的中位数小于数组a的中位数
            return a[s1 + k - 1];
        }
        if(k == 1){
        // 这个最容易理解了，k=1说明先撇开已经被二分排除的那些部分
        // s1和s2的坐标之前已经被更新，所以从剩余数组的起始坐标位置s1和s2
        // 两者相比，找到最小的那个数，便是第k个数
            return Math.min(a[s1], b[s2]);
        }
        int midA = Math.min(m, k / 2);  // 搭配上之前的m > n，保证每次切的都是较小的一半
        int midB = k - midA;
        if(a[s1 + midA - 1] > b[s2 + midB - 1]){
        // 数组b从s2到s2+midB-1这段不可能存在中位数，
        // 起始坐标更新，目的也从找第k个数变成找第k-midB个数
            return findk(a, s1, e1, b, s2 + midB, e2, k - midB);
        }else if(a[s1 + midA - 1] < b[s2 + midB - 1])
        // 与上面类似，数组a从s1到s1+midA-1这段不可能存在中位数，
        // 起始坐标更新，目的也从找第k个数变成找第k-midA个数
            return findk(a, s1 + midA, e1, b, s2, e2, k - midA);
        }else{  
        // 若两个数组的中位数相同，自然两个的中位数就是两者数组各自的中位数
            return a[s1 + midA - 1];
        }
    }
}
