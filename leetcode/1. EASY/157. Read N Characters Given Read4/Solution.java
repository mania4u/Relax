/*
	The API: int read4(char *buf) reads 4 characters at a time from a file.
	The return value is the actual number of characters read. 
	For example, it returns 3 if there is only 3 characters left in the file.
	By using the read4 API, implement the function int read(char *buf, int n) that reads 【i】n characters from the file.


	思路：
	n是文件里一共有多少个字符，readbyte是最后要返回的所读过的字符
	由于每次只能读进4个字符，而n未必是4的倍数。
	所以一直读到len+4>n时停止。剩下m = n-len < 4 个字符。
	建立一个新的缓存remain读入4个字符，然后将其中的m个写入buff尾部。
	要注意在整个读入过程中的每个阶段判断是否已经读完文件。
	重点是要理解这道题的边界问题。
*/

public class Solution extends Reader4{
	public int read(char[] buf, int n){
		boolean lessthan4 = false;
		int readbyte = 0;
		int bytes = 0;

		while(!lessthan4 && readbyte < n){
			int size = read4(buffer);
			if(size < 4){			// 如果扫到扫到size不足4，则改变flag，并且break
				lessthan4 = true;
			}
			bytes = Math.min(n-readbyte, size);
			for(int i = 0; i < bytes; i++){		// 用于标记每次readbyte读取的最后位置
				buf[readbyte + i] = buffer[i];
			}
			readbyte += bytes;
		}
		return readbyte;
	}
}