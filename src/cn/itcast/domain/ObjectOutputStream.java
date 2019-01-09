package cn.itcast.domain;

import java.io.FileOutputStream;

public class ObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeObj();
	}
	
	public static void writeObj() {
		//1、明确存储对象文件
		FileOutputStream fos = new FileOutputStream("obj.txt");
		//2、给操作文件对象加入写入对象功能
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//3、调用了写入对象的方法
		oos.writeObject(new Person("wangcai",20));
		//关闭资源
		oos.close();
	}
}
