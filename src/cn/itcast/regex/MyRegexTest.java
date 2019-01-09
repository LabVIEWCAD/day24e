package cn.itcast.regex;

import java.util.Arrays;

public class MyRegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
		test2();
	}

	public static void test2() {
		/*
		 * 练习2：对ip地址排序
		 * 192.168.1.200  10.10.10.10.  3.3.50.3  127.0.0.1
		 */
		String temp = "192.168.1.200  10.10.10.10.  3.3.50.3  127.0.0.1";
		//补两个0
		temp = temp.replaceAll("(\\d+)", "00$1");
		System.out.println(temp);
		
		//保留每段后三位
		temp.replaceAll("0*(\\d{3})", "$1");
		System.out.println(temp);
		
		String[] ips = temp.split(" +");
		Arrays.sort(ips);
		for (String ip : ips) {
			System.out.println(ip.replaceAll("0*(\\d+)","$1"));
		}
	}

	public static void test1() {
		/*
		 * "我我.....我我我....我要....要...要要要....学学学...学学编....编编...编编程程...程....程程"
		 * 还原成：我要学编程
		 */
		//1、明确要使用替换。replaceALL(regex,String)
		//2、将点去掉
		String temp = "我我.....我我我....我要....要...要要要....学学学...学学编....编编...编编程程...程....程程"; 
		temp = temp.replaceAll("\\.+", "");
		//3、将叠字去掉
		temp = temp.replaceAll("(.)\\1+", "$1");
		System.out.println(temp);
	}

}
