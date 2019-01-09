package cn.itcast.otherio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		//演示RandomAccessFile
		writeFile();
	}

	public static void writeFile() throws IOException {
		//1、创建一个随机访问文件的对象。文件存在，不创建新文件也不覆盖；不存在就创建新文件
		RandomAccessFile raf = new RandomAccessFile("tempfile\\random.txt", "rw");
		
		//2、写入姓名年龄
		raf.write("张三".getBytes());
		raf.writeInt(97);
		
		raf.close();
	}

}
