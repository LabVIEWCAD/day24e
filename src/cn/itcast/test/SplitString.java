package cn.itcast.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SplitString {

	public static void main(String[] args) throws IOException {
		/*
		 * 按照字节数截取一个字符串。“abc你好”，如果截取到半个中文，舍弃。比如截取4个字节，abc；截取五个字节，abc你好
		 * 定义功能实现
		 * 
		 * 字符串——字节数组：编码
		 * 字节数组——字符串：解码
		 * 提示：GB2312编码的一个中文是两个字节，而且两个字节的最高位都是1，也就是说是一个负数
		 * 
		 * 思路：1、中文两个字节都是负数
		 *   2、判断截取的最后一个字节是否是负数。如果是，直接截取
		 *   如果不是，就往回判断前一个是否是负数，并记录负数的个数。如果连续的负数有奇数个，舍弃最后一个字节；
		 *   如果连续的负数是偶数个，不舍弃
		 */

		//字符串转成字节数组
		String str = "abc你好";
		byte[] buf = str.getBytes("GBK");
		
//		for (byte b : buf) {
//			System.out.println(b);
//		}
		for (int x = 0; x < buf.length; x++) {
			String temp = cutStringByCount(str,4);
			System.out.println("截取"+(x+1)+"个字节是："+temp);
		}
		
	}

	public static String cutStringByCount(String str, int len) {
		//1、将字符串转成字节数组。因为要判断截取的字节是否是负数，先有字节
		byte[] buf = str.getBytes("gbk");
		
		//2、定义计数器，记录负数的个数
		int count = 0;
		
		//3、对字节数组进行遍历。应该从截取长度的最后一个字节开始判断，并往回判断。
		for (int x = len-1; x > 0; x--) {
			//4、遍历过程中，只要满足负数就计数。不是负数就结束遍历
			if (buf[x]<0) {
				count++;
			} else {
				break;
			}
		}
		//5、对遍历后，计数器的值进行判断，奇数就舍弃最后字节，并将字节数组转成字符串；偶数，不舍弃，将字节数组转成字符串
		if (count%2==0) {
			return new String(buf,o,len);
		} else {
			return new String(buf,0,len-1);
		}
	}

}
