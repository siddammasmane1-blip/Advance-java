package javalab;


	package Swings;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.*;
	public class ButtonEample {
	JLabel l1;
	ButtonExample(){
	JFrame f=new JFrame(&quot;Button Example&quot;);
	l1=new JLabel();
	l1.setBounds(50,50, 700,100);
	l1.setFont(new Font(&quot;Lucida Calligraphy&quot;,Font.BOLD,60));
	JButton b1=new JButton(&quot; India &quot;);
	JButton b2=new JButton(&quot; Srilanka &quot;);

	b1.setBounds(100,200,100, 100);
	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	l1.setText(&quot;India is pressed&quot;);
	}
	});
	b2.setBounds(400,200,100, 100);
	b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	l1.setText(&quot;SriLanka is pressed&quot;);
	}
	});
	f.add(b1);
	f.add(b2);
	f.add(l1);
	f.setSize(300,400);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
	new ButtonExample();
	}
	}
	
