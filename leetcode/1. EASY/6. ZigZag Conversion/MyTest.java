/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class MyTest { 
    // leetcode
	public static class Solution {
        public String convert(String s, int nRows) {
            if (s==null || nRows<=0)    
            // judge whether string is empty and whether the number of row is abnormal
            return "";
            if (nRows == 1)     // if the nRows = 1, this means the output should be the string itself 
            return s;
            StringBuilder res = new StringBuilder();
            /* 
                we can also use String and "+" to connect a new string, but this will produce too many objects.
                StringBuilder will only produce one object, so it's better.
            */
            int size = 2*nRows-2;   // "size" means the numbers of each loop of "Z".
            for (int i=0; i<nRows; i++) {   // vertical loop, from up to down
                for (int j=i; j<s.length(); j+=size) {  // horizontal loop, from left to right
                    res.append(s.charAt(j));
                if (i!=0 && i!=nRows-1 && j+size-2*i<s.length())
                    /*
                        the first two conditions means the first and the last row
                        the last condition means the letter which is between the two pillars "||" of "Z"
                    */
                    res.append(s.charAt(j+size-2*i));
                }   
            }
        return res.toString();
        }
    }
    // leetcode

        public static void main(String args[]) {    // judge whether there is one string and one number
        String s = args[0];
            if(args.length != 2){
            System.out.println("ERROR!");
       }
       int nRows = Integer.parseInt(args[1]);
       Solution sn = new Solution();
       String ret = sn.convert(s,nRows);
       System.out.println(ret);
    } 
}

// cmd: java MyTest String nRows