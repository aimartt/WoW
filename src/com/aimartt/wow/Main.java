/**
 * 
 */
package com.aimartt.wow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author aimartt
 * @date 2013-03-13
 */
public class Main extends JFrame {

	private static final long	serialVersionUID	= 3857672863030698961L;
	
	/** 随机生成器 */
	private static final Random RANDOM = new Random();
	
	/** 窗体的默认宽度 */
	private static final int WIDTH = 390;
	/** 窗体的默认高度 */
	private static final int HEIGHT = 180;
	
	/** 默认字体 */
	private static final Font FONT_OF_DEFAULT = new Font("微软雅黑", Font.PLAIN, 13);
	/** 结果框的默认字体 */
	private static final Font FONT_OF_FIELD = new Font("微软雅黑", Font.PLAIN, 20);
	
	/** Panel */
	private JPanel panel = new JPanel();
	
	/** 职业标签 */
	private JLabel classLabel = new JLabel("职  业");
	/** 日常标签 */
	private JLabel goalLabel = new JLabel("日  常");
	
	/** 职业结果框 */
	private JTextField classField = new JTextField();
	/** 日常结果框 */
	private JTextField goalField = new JTextField();
	
	//两个按钮
	private JButton classButton = new JButton("生  成");
	private JButton goalButton = new JButton("生  成");
	
	public Main() {
		//获取屏幕的大小
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		panel.setLayout(null);
		//设置标签的字体、位置和大小，添加到 Panel 中
		classLabel.setFont(FONT_OF_DEFAULT);
		goalLabel.setFont(FONT_OF_DEFAULT);
		classLabel.setBounds(75, 15, 40, 15);
		goalLabel.setBounds(250, 15, 40, 15);
		panel.add(classLabel);
		panel.add(goalLabel);
		//设置结果框的字体、位置和大小，添加到 Panel 中
		classField.setEditable(false);
		goalField.setEditable(false);
		classField.setFont(FONT_OF_FIELD);
		goalField.setFont(FONT_OF_FIELD);
		classField.setHorizontalAlignment(JTextField.CENTER);
		goalField.setHorizontalAlignment(JTextField.CENTER);
		classField.setBounds(25, 47, 135, 38);
		goalField.setBounds(175, 47, 185, 38);
		panel.add(classField);
		panel.add(goalField);
		//设置按钮的字体、位置、大小和监听，添加到 Panel 中
		classButton.setFont(FONT_OF_DEFAULT);
		goalButton.setFont(FONT_OF_DEFAULT);
		classButton.setBounds(55, 110, 75, 20);
		goalButton.setBounds(230, 110, 75, 20);
		classButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				classField.setText(Classes.classes.get(RANDOM.nextInt(Classes.classes.size())));
			}
		});
		goalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goalField.setText(Area.areas.get(RANDOM.nextInt(Area.areas.size())));
			}
		});
		panel.add(classButton);
		panel.add(goalButton);
		add(panel);
		setBounds(winSize.width / 2 - WIDTH / 2, winSize.height / 2 - HEIGHT / 2, WIDTH, HEIGHT);		//窗体居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}