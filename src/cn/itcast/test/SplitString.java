package cn.itcast.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SplitString {

	public static void main(String[] args) throws IOException {
		/*
		 * �����ֽ�����ȡһ���ַ�������abc��á��������ȡ��������ģ������������ȡ4���ֽڣ�abc����ȡ����ֽڣ�abc���
		 * ���幦��ʵ��
		 * 
		 * �ַ��������ֽ����飺����
		 * �ֽ����顪���ַ���������
		 * ��ʾ��GB2312�����һ�������������ֽڣ����������ֽڵ����λ����1��Ҳ����˵��һ������
		 * 
		 * ˼·��1�����������ֽڶ��Ǹ���
		 *   2���жϽ�ȡ�����һ���ֽ��Ƿ��Ǹ���������ǣ�ֱ�ӽ�ȡ
		 *   ������ǣ��������ж�ǰһ���Ƿ��Ǹ���������¼�����ĸ�������������ĸ��������������������һ���ֽڣ�
		 *   ��������ĸ�����ż������������
		 */

		//�ַ���ת���ֽ�����
		String str = "abc���";
		byte[] buf = str.getBytes("GBK");
		
//		for (byte b : buf) {
//			System.out.println(b);
//		}
		for (int x = 0; x < buf.length; x++) {
			String temp = cutStringByCount(str,4);
			System.out.println("��ȡ"+(x+1)+"���ֽ��ǣ�"+temp);
		}
		
	}

	public static String cutStringByCount(String str, int len) {
		//1�����ַ���ת���ֽ����顣��ΪҪ�жϽ�ȡ���ֽ��Ƿ��Ǹ����������ֽ�
		byte[] buf = str.getBytes("gbk");
		
		//2���������������¼�����ĸ���
		int count = 0;
		
		//3�����ֽ�������б�����Ӧ�ôӽ�ȡ���ȵ����һ���ֽڿ�ʼ�жϣ��������жϡ�
		for (int x = len-1; x > 0; x--) {
			//4�����������У�ֻҪ���㸺���ͼ��������Ǹ����ͽ�������
			if (buf[x]<0) {
				count++;
			} else {
				break;
			}
		}
		//5���Ա����󣬼�������ֵ�����жϣ���������������ֽڣ������ֽ�����ת���ַ�����ż���������������ֽ�����ת���ַ���
		if (count%2==0) {
			return new String(buf,o,len);
		} else {
			return new String(buf,0,len-1);
		}
	}

}
