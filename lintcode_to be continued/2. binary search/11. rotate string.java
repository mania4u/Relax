public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public char[] rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0)
            return str;
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        return str;
    }
    
    private void reverse(char[] str, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
}