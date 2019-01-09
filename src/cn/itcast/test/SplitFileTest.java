package cn.itcast.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileTest {

	public static void main(String[] args) throws IOException {
		/*
		 * 文件切割器
		 * 一个读取流，对应多个输出流，而且生成的碎片文件都有有序的编号
		 */
		File srcFile = new File("c:\\1.mp3");
		File destdir = new File("tempfile\\partsfile");
		fileSplit(srcFile,destdir);
	}		

	public static void fileSplit(File srcFile,File destdir) throws IOException {
		//判断源文件是否存在
		if (!srcFile.exists()) {
			throw new RuntimeException(srcFile.getAbsolutePath()+"源文件不存在！");
		}
		//判断文件夹是否存在
		if (!destdir.exists()) {
			destdir.mkdirs();
		}
		
		//1、读取源文件
		FileInputStream fis = new FileInputStream(srcFile);
		
		//2、创建目的引用
		FileOutputStream fos = null;
		
		//3、创建一个缓存区
		byte[] buf = new byte[1024*1024];
		int count = 0;
		int len = 0;
		//4、往缓存区存储数据
		while((len=fis.read(buf))!=-1) {
			//5、创建输出流，并明确要写入的对象
			File partFile = new File(destdir,(++count)+".part");
			fos = new FileOutputStream(partFile);
			fos.write(buf, 0, len);
			fos.close();
		}
		//应该在产生文件碎片时需要生成一个配置文件，记录碎片的个数和源文件的名字
		//partcount = 5; filename = 1.mp3;
		
		//配置文件中储存的键值信息。使用Properties集合
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
