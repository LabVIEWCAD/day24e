package cn.itcast.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AwtDemo {

	public static void main(String[] args) {
		//1、创建一个窗体
		Frame f = new Frame("my frame");
		//2、对框体进行基本设置
		f.setSize(500, 400);
		f.setLocation(400, 300);
		//设置布局
		f.setLayout(new FlowLayout());
		
		//给窗口添加组件
		Button but = new Button("my button");
		TextField tf = new TextField();
		tf.setSize(100, 10);
		
		//将组件添加到窗口中
		f.add(but);
		f.add(tf);
		
		/*
		 * 需求：给点击按钮添加效果，比如打印一句话
		 * 思路：1、确定事件源。按钮
		 * 2、确定监听器。按钮添加监听器，到按钮对象中查找
		 * 3、定义处理方式
		 * 
		 */
		//1、按钮添加所需的监听器
		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("按钮被触发..."+e);
				System.exit(0);
			}
			
		});
		
		/*
		 * 需求：点击窗口右上角的x，退出窗口
		 * 思路：1、事件源。窗口
		 * 2、事件监听器。调用窗口对象方法
		 * 3、事件处理
		 */
//		f.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("window closing!");
//				System.exit(0);
//			}
//			
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		//以上语句中只覆盖了其中一个方法，调用WindowAdapter，简化程序
//		f.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("window closing!");
//				System.exit(0);
//			}
//		});
		
		/*
		 * 演示鼠标监听
		 * 按钮事件源，鼠标监听器注册到按钮上
		 */
		but.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount()==2) {
					System.out.println("mouse double click");
				}
			}
			
		});
		
		/*
		 * 需求：文本框中只能输入数字
		 * 事件源：文本框
		 * 文本框注册键盘监听
		 * 事件处理
		 */
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				//1、如何获取录入内容，通过键盘事件对象获取
				char key = e.getKeyChar();
				int code = e.getKeyCode();
				System.out.println(code+"...."+KeyEvent.getKeyText(code));
			}
			
		});
		
		//3、让窗体显示
		f.setVisible(true);
		System.out.println("over!");
	}

}
