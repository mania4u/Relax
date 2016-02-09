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
            if(source.substring(i, i + target.length()).equals(target))
                return i;
        }
        return -1;
    }
}