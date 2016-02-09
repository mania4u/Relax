class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target){
        //write your code here
        if(source == null || target == null || source.length() < target.length())
            return -1;

        for(int i = 0; i < source.length() - target.length() + 1; i++){
            int j = 0;      // 用来表示target字段的长度
            for(j = 0; j < target.length(); j++){
                if(source.charAt(i + j) != target.charAt(j))
                    break;
            }
            if(j == target.length())
            // 在执行完上面的代码，j是以target.length()的值跳出的
            // 这个语句就是用来表示将所有target中所有字符都比较过了
                return i;
        }
        return -1;
    }
}