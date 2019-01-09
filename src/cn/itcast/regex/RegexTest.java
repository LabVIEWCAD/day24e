package cn.itcast.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegexTest {

	public static void main(String[] args) {
		
//		matchesDemo();
//		splitDemo();
		getDemo();
		
	}

	public static void getDemo() {
		/*
		 * ʵ�ֻ�ȡ�������Ϲ��������ȡ����
		 * �õ�������ʽ����java.util.regex.Pattern
		 * 
		 * 1�����ַ��������װ��Pattern����compile��regex��
		 * 2��ͨ����������ȡƥ�������󣬽���������õ�Ҫ�������ַ�����
		 * 3��ͨ��ƥ��������ķ������ַ������в���
		 * Pattern p = Pattern.compile("a+b");//�������װ�ɶ���
		 * Matcher m = p.matcher("aaaaab");//��Ҫ�������ַ�������������ƥ��������
		 * boolean b = m.matches();//ʹ��ƥ����󷽷������ַ���
		 */
		
		String temp = "da jia zhu yi le,ming tian fang jia le!";
		//ȡ��������ĸ��ɵĵ���
		String regex = "[a-zA-Z] {3}";
		//1������������Pattern����
		Pattern p = Pattern.compile(regex);
		//2�����ַ�����������ȡƥ��������
		Matcher m = p.matcher(temp);
		
		while(m.find())
			System.out.println(m.group());
	}
	
	public static void splitDemo() {
		// TODO Auto-generated method stub
		String str = "qwe##rtyu&&&io";
		String regex = "(.)\\1+";
		String[] names = str.split(regex);
		for (String name : names) {
			System.out.println("-"+name+"-");
		}
	}

	public static void matchesDemo() {
		// //������֤�ֻ����Ƿ���ȷ
		String tel = "18609035269";
		String regex = "1[358][0-9]{9}";
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
	}

}
