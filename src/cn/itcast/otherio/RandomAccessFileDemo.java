package cn.itcast.otherio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		//��ʾRandomAccessFile
		writeFile();
	}

	public static void writeFile() throws IOException {
		//1������һ����������ļ��Ķ����ļ����ڣ����������ļ�Ҳ�����ǣ������ھʹ������ļ�
		RandomAccessFile raf = new RandomAccessFile("tempfile\\random.txt", "rw");
		
		//2��д����������
		raf.write("����".getBytes());
		raf.writeInt(97);
		
		raf.close();
	}

}
