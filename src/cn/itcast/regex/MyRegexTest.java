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
		 * ��ϰ2����ip��ַ����
		 * 192.168.1.200  10.10.10.10.  3.3.50.3  127.0.0.1
		 */
		String temp = "192.168.1.200  10.10.10.10.  3.3.50.3  127.0.0.1";
		//������0
		temp = temp.replaceAll("(\\d+)", "00$1");
		System.out.println(temp);
		
		//����ÿ�κ���λ
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
		 * "����.....������....��Ҫ....Ҫ...ҪҪҪ....ѧѧѧ...ѧѧ��....���...���̳�...��....�̳�"
		 * ��ԭ�ɣ���Ҫѧ���
		 */
		//1����ȷҪʹ���滻��replaceALL(regex,String)
		//2������ȥ��
		String temp = "����.....������....��Ҫ....Ҫ...ҪҪҪ....ѧѧѧ...ѧѧ��....���...���̳�...��....�̳�"; 
		temp = temp.replaceAll("\\.+", "");
		//3��������ȥ��
		temp = temp.replaceAll("(.)\\1+", "$1");
		System.out.println(temp);
	}

}
