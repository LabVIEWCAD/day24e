package cn.itcast.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileTest {

	public static void main(String[] args) throws IOException {
		/*
		 * �ļ��и���
		 * һ����ȡ������Ӧ�����������������ɵ���Ƭ�ļ���������ı��
		 */
		File srcFile = new File("c:\\1.mp3");
		File destdir = new File("tempfile\\partsfile");
		fileSplit(srcFile,destdir);
	}		

	public static void fileSplit(File srcFile,File destdir) throws IOException {
		//�ж�Դ�ļ��Ƿ����
		if (!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+"Դ�ļ������ڣ�");
		}
		//�ж��ļ����Ƿ����
		if (!destdir.exists()) {
			destdir.mkdirs();
		}
		
		//1����ȡԴ�ļ�
		FileInputStream fis = new FileInputStream(srcFile);
		
		//2������Ŀ������
		FileOutputStream fos = null;
		
		//3������һ��������
		byte[] buf = new byte[1024*1024];
		int count = 0;
		int len = 0;
		//4�����������洢����
		while((len=fis.read(buf))!=-1) {
			//5�����������������ȷҪд��Ķ���
			File partFile = new File(destdir,(++count)+".part");
			fos = new FileOutputStream(partFile);
			fos.write(buf, 0, len);
			fos.close();
		}
		//Ӧ���ڲ����ļ���Ƭʱ��Ҫ����һ�������ļ�����¼��Ƭ�ĸ�����Դ�ļ�������
		//partcount = 5; filename = 1.mp3;
		
		//�����ļ��д���ļ�ֵ��Ϣ��ʹ��Properties����
		Properties prop = new Properties();
		
		prop.setProperty("partcount", Integer.toString(count));
		prop.setProperty("filename", srcFile.getName());
		File configFile = new File(destdir,(++count)+".properties");
		fos = new FileOutputStream(configFile);
		prop.store(fos, "save part file info");
		
		fos.close();
		fis.close();
	}
}
