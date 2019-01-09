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
		 * 实现获取：将符合规则的内容取出来
		 * 用到正则表达式对象，java.util.regex.Pattern
		 * 
		 * 1、将字符串规则封装成Pattern对象。compile（regex）
		 * 2、通过正则对象获取匹配器对象，将正则规则用到要操作的字符串上
		 * 3、通过匹配器对象的方法对字符串进行操作
		 * Pattern p = Pattern.compile("a+b");//将规则封装成对象
		 * Matcher m = p.matcher("aaaaab");//和要操作的字符串关联，生成匹配器对象
		 * boolean b = m.matches();//使用匹配对象方法操作字符串
		 */
		
		String temp = "da jia zhu yi le,ming tian fang jia le!";
		//取出三个字母组成的单词
		String regex = "[a-zA-Z] {3}";
		//1、将规则编译成Pattern对象
		Pattern p = Pattern.compile(regex);
		//2、和字符串关联，获取匹配器对象
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
		// //需求：验证手机号是否正确
		String tel = "18609035269";
		String regex = "1[358][0-9]{9}";
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
	}

}
