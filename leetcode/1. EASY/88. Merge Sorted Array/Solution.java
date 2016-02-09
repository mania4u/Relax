public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    int l = m + n;
    while(n > 0) A[--l] = (m == 0 || A[m-1] < B[n-1]) ? B[--n] : A[--m];
    }
}