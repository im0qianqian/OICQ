/**  
 * @Title:  Listenter.java
 * @Package com.oicq.frame   
 * @Description: 存放各种监听类 
 * @author: 艾尔森 
 * @version V1.0 
 * @Copyright: 2016 www.irson.cn Inc. All rights reserved. 
 */  
package com.oicq.frame;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.util.Date;

import javax.swing.*;

import com.oicq.client.ChatThread;
import com.oicq.client.InteractWithServer;

/**   
 * @ClassName:  ExitListenter  
 * @Description: 用于登录界面和主界面的退出按钮 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
class ExitListenter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
/**   
 * @ClassName:  ExitNoeFrameListenter  
 * @Description: 用于推出当前frame窗口 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
class ExitNowFrameListenter implements ActionListener {
	private JFrame now;

	public ExitNowFrameListenter(JFrame now) {
		this.now = now;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		now.dispose();
	}
}

/**   
 * @ClassName:  LoginMouseMove
 * @Description: 用于使窗口可以点击任意位置移动 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
class LoginMousemove extends MouseAdapter {
	private int offsetX, offsetY;
	private boolean isCanMove;

	public LoginMousemove() {
		isCanMove = true;
	}

	public void setCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	public void mouseDragged(MouseEvent e) {
		// requires JDK 1.6 or above
		if (isCanMove) {
			SwingUtilities.getRoot((Component) e.getSource()).setLocation(e.getXOnScreen() - offsetX,
					e.getYOnScreen() - offsetY);
		}
	}

	public void mousePressed(MouseEvent e) {
		offsetX = e.getX();
		offsetY = e.getY();
	}
}

/**   
 * @ClassName:  LoginListener
 * @Description: 获得登录信息并创建主界面 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
class LoginListener implements ActionListener {
	JFrame now;
	JTextField userId;
	JPasswordField passwd;
	JCheckBox isRemeberPasswd, isAutoLogin;

	public void setNow(JFrame now) {
		this.now = now;
	}

	public void setUserId(JTextField userId) {
		this.userId = userId;
	}

	public void setPasswd(JPasswordField passwd) {
		this.passwd = passwd;
	}

	public void setIsRemeberPasswd(JCheckBox isRemeberPasswd) {
		this.isRemeberPasswd = isRemeberPasswd;
	}

	public void setIsAutoLogin(JCheckBox isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 点击登录按钮
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("try login");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 获取文本框内容
				String userIdString = userId.getText().trim();
				String userPasswordString = String.valueOf(passwd.getPassword()).trim();
				// 获取登录设置
				boolean isAutoLog = isAutoLogin.isSelected();
				boolean isRemeber = isRemeberPasswd.isSelected();
				if (isAutoLog) {
					isRemeber = true;
				}

				// 验证用户或密码是否正确
				Object isLoginSuccess = InteractWithServer.isLogin(userIdString, userPasswordString);

				System.out.println("当前登录状态：" + isLoginSuccess);
				if (isLoginSuccess != null) {
					String loginResult = isLoginSuccess.toString();
					if (loginResult.equals("true")) {
						if (isRemeber) {
							try {
								FileOutputStream out = new FileOutputStream("./Data/UserInfo.uif");
								for(int i=0;i<userIdString.length();i++){
									char t = userIdString.charAt(i);
									t ^= 'I';
									out.write(t);
								}
								//out.write(userIdString.getBytes());
								out.write('\n');
								for(int i=0;i<userPasswordString.length();i++){
									char t = userPasswordString.charAt(i);
									t ^= 'P';
									out.write(t);
								}
								//out.write(userPasswordString.getBytes());
								out.write('\n');
								if (isAutoLog) {
									out.write('1');
								} else {
									out.write('0');
								}
								out.close();
							} catch (Exception e) {
								System.out.println("ListenterClass/actionPerformed Error " + e);
							}
						} else {
							// try {
							// FileOutputStream out = new
							// FileOutputStream("./Data/UserInfo.uif");
							// } catch (FileNotFoundException e) {
							// // TODO 自动生成的 catch 块
							// e.printStackTrace();
							// }
						}
						now.dispose();

						// 创建线程接入聊天端口
						new Thread(new ChatThread(userIdString)).start();

						new MainInterface(userIdString);
					} else if (loginResult.equals("Repeat_login")) {
						JOptionPane.showMessageDialog(now, "重复登录");
					} else {
						JOptionPane.showMessageDialog(now, "您的登陆信息有误", "登陆失败", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(now, "与服务器建立连接失败");
				}
			}
		}).start();
	}
}
/**   
 * @ClassName:  SendFriend  
 * @Description: 对好友发送信息   
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
class SendFriend implements ActionListener {
	private JTextArea message;
	private String mName;
	private String fid;
	private ChatWithFriend now;
	private boolean isGroup;

	public SendFriend(String mName, String fid, boolean isGroup) {
		this.mName = mName;
		this.fid = fid;
		this.isGroup = isGroup;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 发送消息
		if(this.message.getText().trim().length()!=0){
		now.addMessage(mName, new Date().toString(), this.message.getText(), false);
		ChatThread.getDataStream().send(this.message.getText(), fid, isGroup);
		this.message.setText("");
		}
		else
			{JOptionPane.showMessageDialog(now, "发送消息不能为空，请重新输入");}
	}

	public void setMessage(JTextArea message) {
		this.message = message;
	}

	public void setNow(ChatWithFriend now) {
		this.now = now;
	}
}