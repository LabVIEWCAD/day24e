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
		//1������һ������
		Frame f = new Frame("my frame");
		//2���Կ�����л�������
		f.setSize(500, 400);
		f.setLocation(400, 300);
		//���ò���
		f.setLayout(new FlowLayout());
		
		//������������
		Button but = new Button("my button");
		TextField tf = new TextField();
		tf.setSize(100, 10);
		
		//�������ӵ�������
		f.add(but);
		f.add(tf);
		
		/*
		 * ���󣺸������ť���Ч���������ӡһ�仰
		 * ˼·��1��ȷ���¼�Դ����ť
		 * 2��ȷ������������ť��Ӽ�����������ť�����в���
		 * 3�����崦��ʽ
		 * 
		 */
		//1����ť�������ļ�����
		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ť������..."+e);
				System.exit(0);
			}
			
		});
		
		/*
		 * ���󣺵���������Ͻǵ�x���˳�����
		 * ˼·��1���¼�Դ������
		 * 2���¼������������ô��ڶ��󷽷�
		 * 3���¼�����
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
		//���������ֻ����������һ������������WindowAdapter���򻯳���
//		f.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("window closing!");
//				System.exit(0);
//			}
//		});
		
		/*
		 * ��ʾ������
		 * ��ť�¼�Դ����������ע�ᵽ��ť��
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
		 * �����ı�����ֻ����������
		 * �¼�Դ���ı���
		 * �ı���ע����̼���
		 * �¼�����
		 */
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				//1����λ�ȡ¼�����ݣ�ͨ�������¼������ȡ
				char key = e.getKeyChar();
				int code = e.getKeyCode();
				System.out.println(code+"...."+KeyEvent.getKeyText(code));
			}
			
		});
		
		//3���ô�����ʾ
		f.setVisible(true);
		System.out.println("over!");
	}

}
