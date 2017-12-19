/**  
 * All rights Reserved, Designed By www.ireson.cn
 * @Title:  Login.java
 * @Package com.oicq.frame   
 * @Description: 登录界面，获取用户登录信息使用户登录   
 * @author: 艾尔森 
 * @version V1.0 
 * @Copyright: 2016 www.irson.cn Inc. All rights reserved. 
 */  
package com.oicq.frame;

import java.awt.Color;

import java.awt.Image;

import java.awt.Insets;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;

import java.awt.event.FocusListener;
import java.io.FileInputStream;
import javax.swing.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
/**   
 * @ClassName:  Login  
 * @Description: 登录界面   
 * @author: 艾尔森 
 * @date: 2016-11
 *   
 * JFrame
 * @Copyright: 2016 www.irson.cn Inc. All rights reserved.  
 */  
public final class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userId;
	private JLabel /* logo, */ remeberPasswd, autoLogin, headPortrait;
	private JPasswordField passwd;
	private JButton login, findPasswd, register, close, minimize;
	private JCheckBox remeberPasswdCheckBox, autoLoginCheckBox;
	private JPanel upPanel, downPanel, textFiledPanel;
	private LoginListener l;
	private String username, userPasswd;

	private void init() {
		/**   
		 * @Title: init()  
		 * @Description: 初始化界面组件  
		 * @return: void
		 * @throws   
		 */  
		/*
		 * panel up
		 */
		// 1.
		upPanel = new JPanel();
		upPanel.setLayout(null);
		upPanel.setBounds(0, 0, 430, 183);
		upPanel.setBackground(new Color(6, 157, 214));
		/*
		 * button close
		 */
		close = new JButton();
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(402, 0, 28, 28);
		close.setContentAreaFilled(false); // set don't draw message area
		close.setBorderPainted(false); // set don't draw border
		close.setFocusPainted(false); // set don't draw focus painted
		close.setToolTipText("关闭");
		close.setIcon(new ImageIcon("./res/Misc/FileManager/closebutton_normal.png"));
		close.setRolloverIcon(new ImageIcon("./res/Misc/FileManager/closebutton_hover.png"));
		close.setPressedIcon(new ImageIcon("./res/Misc/FileManager/closebutton_down.png"));
		ExitListenter closeListenter = new ExitListenter();
		close.addActionListener(closeListenter);
		/*
		 * button minimize
		 */
		minimize = new JButton();
		minimize.setMargin(new Insets(0, 0, 0, 0));
		minimize.setBounds(374, 0, 28, 28);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.setFocusPainted(false);
		minimize.setToolTipText("最小化");
		minimize.setIcon(new ImageIcon("./res/Misc/FileManager/minbutton_normal.png"));
		minimize.setRolloverIcon(new ImageIcon("./res/Misc/FileManager/minbutton_hover.png"));
		minimize.setPressedIcon(new ImageIcon("./res/Misc/FileManager/minbutton_down.png"));
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		/*
		 * logo
		 */
		//
		// logo = new JLabel();
		// ImageIcon logoIcon = new ImageIcon("logo.png?");
		// logoIcon.setImage(logoIcon.getImage().getScaledInstance(154, 68,
		// Image.SCALE_DEFAULT));
		// logo.setIcon(logoIcon);
		// logo.setBounds(142, 65, 154, 68);
		/*
		 * panel down
		 */
		downPanel = new JPanel();
		downPanel.setLayout(null);
		downPanel.setBounds(0, 184, 430, 152);
		downPanel.setBackground(new Color(255, 255, 255));
		/*
		 * label headPortrait
		 */
		headPortrait = new JLabel();
		headPortrait.setBounds(44, 11, 82, 83);
		String headPortraitPostion = "./res/tempheadportrait.jpg";
		// Todo sometings get head portrait position
		Image headPic = (new ImageIcon(headPortraitPostion)).getImage().getScaledInstance(82, 83, Image.SCALE_DEFAULT);
		// ImageIcon headIcon = new ImageIcon(temp);
		headPortrait.setIcon(new ImageIcon(headPic));
		/*
		 * panel textfieldpanel
		 */
		textFiledPanel = new JPanel();
		textFiledPanel.setBounds(135, 11, 195, 62);
		textFiledPanel.setLayout(null);

		/*
		 * TextField userId
		 */
		userId = new JTextField("账号");
		userId.setBounds(0, 0, 195, 31);
		userId.setForeground(Color.GRAY);
		userId.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (userId.getText().trim().equals("")) {
					userId.setForeground(Color.GRAY);
					userId.setText("账号");
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (userId.getText().trim().equals("账号")) {
					userId.setText("");
					userId.setForeground(Color.BLACK);
				}
			}
		});
		/*
		 * PasswordField passwd
		 */
		passwd = new JPasswordField("密码");
		passwd.setBounds(0, 31, 195, 31);
		passwd.setEchoChar((char) 0);
		passwd.setForeground(Color.GRAY);
		passwd.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwd.getPassword()).trim().equals("")) {
					passwd.setEchoChar((char) 0);
					passwd.setForeground(Color.GRAY);
					passwd.setText("密码");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwd.getPassword()).trim().equals("密码")) {
					passwd.setEchoChar('•');
					passwd.setForeground(Color.BLACK);
					passwd.setText("");
				}
			}
		});
		/*
		 * Button register
		 */
		// 点击注册账号按钮，打开注册账号的网页
		register = new JButton();
		register.setMargin(new Insets(0, 0, 0, 0));
		register.setBounds(340, 19, 51, 16);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);
		register.setIcon(new ImageIcon("./res/Loginpanel2/zhuce.png"));
		register.setRolloverIcon(new ImageIcon("./res/Loginpanel2/zhuce_hover.png"));
		register.setPressedIcon(new ImageIcon("./res/Loginpanel2/zhuce_press.png"));
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				// TODO 自动生成的方法存根
				try {
					URI uri = new URI("http://www.dreamwings.cn/oicq");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
		/*
		 * Button findPasswd
		 */
		// 点击找回密码的按钮，打开找回密码的网页
		findPasswd = new JButton();
		findPasswd.setMargin(new Insets(0, 0, 0, 0));
		findPasswd.setBounds(340, 49, 51, 16);
		findPasswd.setContentAreaFilled(false);
		findPasswd.setBorderPainted(false);
		findPasswd.setIcon(new ImageIcon("./res/Loginpanel2/mima.png"));
		findPasswd.setRolloverIcon(new ImageIcon("./res/Loginpanel2/mima_hover.png"));
		findPasswd.setPressedIcon(new ImageIcon("./res/Loginpanel2/mima_press.png"));
		findPasswd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					URI uri = new URI("http://www.dreamwings.cn");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		/*
		 * JCheckBox isRemeberPasswd
		 */
		remeberPasswdCheckBox = new JCheckBox();
		remeberPasswdCheckBox.setMargin(new Insets(0, 0, 0, 0));
		remeberPasswdCheckBox.setBounds(133, 79, 17, 17);
		remeberPasswdCheckBox.setIcon(new ImageIcon("./res/Loginpanel2/checkbox_normal.png"));
		remeberPasswdCheckBox.setRolloverIcon(new ImageIcon("./res/Loginpanel2/checkbox_hover.png"));
		remeberPasswdCheckBox.setPressedIcon(new ImageIcon("./res/Loginpanel2/checkbox_press.png"));
		remeberPasswdCheckBox.setSelectedIcon(new ImageIcon("./res/loginui/checkbox_tick_normal1.png"));
		remeberPasswdCheckBox.setRolloverSelectedIcon(new ImageIcon("./res/loginui/checkbox_tick_highlight1.png"));
		/*
		 * JCheckBox isAutoLogin
		 */
		autoLoginCheckBox = new JCheckBox();
		autoLoginCheckBox.setMargin(new Insets(0, 0, 0, 0));
		autoLoginCheckBox.setBounds(263, 79, 17, 17);
		autoLoginCheckBox.setIcon(new ImageIcon("./res/Loginpanel2/checkbox_normal.png"));
		autoLoginCheckBox.setRolloverIcon(new ImageIcon("./res/Loginpanel2/checkbox_hover.png"));
		autoLoginCheckBox.setPressedIcon(new ImageIcon("./res/Loginpanel2/checkbox_press.png"));
		autoLoginCheckBox.setSelectedIcon(new ImageIcon("./res/loginui/checkbox_tick_normal1.png"));
		autoLoginCheckBox.setRolloverSelectedIcon(new ImageIcon("./res/loginui/checkbox_tick_highlight1.png"));
		/*
		 * label remeberPasswd
		 */
		remeberPasswd = new JLabel("记住密码");
		remeberPasswd.setForeground(Color.GRAY);
		remeberPasswd.setBounds(150, 79, 53, 15);
		/*
		 * label autoLogin
		 */
		autoLogin = new JLabel("自动登录");
		autoLogin.setForeground(Color.GRAY);
		autoLogin.setBounds(280, 79, 52, 15);
		/*
		 * Button login
		 */
		login = new JButton("登   录");
		login.setMargin(new Insets(0, 0, 0, 0));
		login.setBounds(135, 105, 195, 31);
		login.setFocusPainted(false);
		// login.setBorderPainted(false);
		login.setBackground(new Color(9, 163, 220));// there will be annotation
		/*
		 * init actionListener
		 */
		l = new LoginListener();
		l.setNow(this);
		l.setUserId(userId);
		l.setPasswd(passwd);
		l.setIsRemeberPasswd(remeberPasswdCheckBox);
		l.setIsAutoLogin(autoLoginCheckBox);
		userId.addActionListener(l);
		passwd.addActionListener(l);

		login.addActionListener(l);
		try {
			FileInputStream in = new FileInputStream("./Data/UserInfo.uif");
			int t;
			username = "";
			userPasswd = "";
			while ((t = in.read()) != -1) {
				if (t == '\n')
					break;
				t ^= 'I';
				username = username + (char) t;
			}
			if (!username.equals("")) {
				while ((t = in.read()) != -1) {
					if (t == '\n')
						break;
					t ^= 'P';
					userPasswd = userPasswd + (char) t;
				}
				userId.setForeground(Color.BLACK);
				userId.setText(username);
				passwd.setEchoChar('•');
				passwd.setForeground(Color.BLACK);
				passwd.setText(userPasswd);
				t = (char) in.read();
				remeberPasswdCheckBox.setSelected(true);
				if (t == '1') {
					autoLoginCheckBox.setSelected(true);
					// todo something auto login
				}
			}
			in.close();
		} catch (Exception e) {
//			System.out.println("No user Info");
		}
	}

	public Login() {
		// System.out.println("123456");
		setLayout(null);
		// 更改显示的小图标
		setIconImage(Toolkit.getDefaultToolkit().createImage("./res/mainpanel/qq_logo.png"));
		setTitle("登录窗口");
		init();
		upPanel.add(close);
		upPanel.add(minimize);
		// upPanel.add(logo);
		add(upPanel);
		downPanel.add(headPortrait);
		textFiledPanel.add(userId);
		textFiledPanel.add(passwd);
		downPanel.add(textFiledPanel);
		downPanel.add(register);
		downPanel.add(findPasswd);
		downPanel.add(remeberPasswdCheckBox);
		downPanel.add(autoLoginCheckBox);
		downPanel.add(remeberPasswd);
		downPanel.add(autoLogin);
		downPanel.add(login);
		add(downPanel);
		LoginMousemove adapter = new LoginMousemove();
		addMouseMotionListener(adapter);
		addMouseListener(adapter);
		setSize(430, 335);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		// setExtendedState(JFrame.MAXIMIZED_BOTH); //set Jframe size？
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
