package cn.itcast.domain;

import java.io.FileOutputStream;

public class ObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeObj();
	}
	
	public static void writeObj() {
		//1����ȷ�洢�����ļ�
		FileOutputStream fos = new FileOutputStream("obj.txt");
		//2���������ļ��������д�������
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//3��������д�����ķ���
		oos.writeObject(new Person("wangcai",20));
		//�ر���Դ
		oos.close();
	}
}
