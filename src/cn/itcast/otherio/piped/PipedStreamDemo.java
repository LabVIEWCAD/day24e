package cn.itcast.otherio.piped;

import java.io.PipedInputStream;

public class PipedStreamDemo {

	public static void main(String[] args) {
	
	}

}

//1、定义输入任务
	class Input implements Runnable{
		private PipedInputStream pis;
		
			public Input(PipedInputStream pis) {
			super();
			this.pis = pis;
		}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		
	}
	//2、定义输出任务
	class Output implements Runnable{
		private PipedInputStream pos;
		
			public Output(PipedInputStream pos) {
			super();
			this.pos = pos;
		}

			@Override
			public void run() {
				//通过write写方法完成
				pos.write("hi，管道来了！".getBytes());
					
			}
			
		}