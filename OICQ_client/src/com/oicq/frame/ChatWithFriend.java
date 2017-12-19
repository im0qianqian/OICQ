/**  
 * All rights Reserved, Designed By www.ireson.cn
 * @Title:  ChatWithFriend.java
 * @Package com.oicq.frame   
 * @Description: 存放聊天窗口类 
 * @author: 艾尔森 
 * @version V1.0 
 * @Copyright: 2016 www.irson.cn Inc. All rights reserved. 
 */  
package com.oicq.frame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import com.oicq.client.InteractWithServer;
/**   
 * @ClassName:  ChatWithFriend  
 * @Description: 显示聊天窗口  
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
public final class ChatWithFriend extends JFrame {
	/**
	 * 
	 */
	//
	private static final long serialVersionUID = 1L;
	private JButton minimize, close, maximize, closeButton, sendButton;
	private LoginMousemove adapter;
	private JPanel upPanel, inputPanel;
	private JLabel friendAvatar, friendName, friendTrades;
	private String friendAvatarString, friendNameString, friendTradesString, fid, mid, mName;
	private Box showBox, groupPeopleBox;
	private JScrollPane showPanel, inputScroll, groupPeopleScrollPanel;
	private JTextArea input;
	private Image headPic;
	private int messageNum = 0;
	private boolean isGroup = false;

	public ChatWithFriend(String mid, String mName, String fid, String friendAvatarString, String friendNameString,
			String friendTradesString, boolean isGroup) {
		this.mid = mid;
		this.mName = mName;
		this.fid = fid;
		this.friendAvatarString = friendAvatarString;
		this.friendNameString = friendNameString;
		this.friendTradesString = friendTradesString;
		this.isGroup = isGroup;

		setTitle(friendNameString);

		setLayout(null);
		// 更改显示的小图标
		headPic = (GetAvatar.getAvatarImage(fid, isGroup ? "./Data/Avatar/Group/" : "./Data/Avatar/User/",
				friendAvatarString)).getImage().getScaledInstance(41, 37, Image.SCALE_DEFAULT);
		setIconImage(headPic);
		setSize(665, 534);// 526 + 139
		init();
		this.add(close);
		this.add(maximize);
		this.add(minimize);
		this.add(upPanel);
		this.add(showPanel);
		this.add(inputPanel);
		if (isGroup)
			add(groupPeopleScrollPanel);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void init() {
		/**
		 * Button close
		 */
		// 关闭按钮
		close = new JButton("");
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(639, 0, 26, 27);
		close.setContentAreaFilled(false); // set don't draw message area
		close.setBorderPainted(false); // set don't draw border
		close.setFocusPainted(false);
		close.setToolTipText("关闭");
		close.setIcon(new ImageIcon("./res/chat/sysbtn_close_normal.png"));
		close.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_close_hover.png"));
		close.setPressedIcon(new ImageIcon("./res/chat/sysbtn_close_down.png"));
		close.addActionListener(new ExitNowFrameListenter(this));
		/**
		 * Button maxmize
		 */
		// 最大化按钮，界面最大化
		maximize = new JButton();
		maximize.setMargin(new Insets(0, 0, 0, 0));
		maximize.setBounds(474 + 139, 0, 26, 27);
		maximize.setContentAreaFilled(false);
		maximize.setFocusPainted(false);
		maximize.setBorderPainted(false);
		maximize.setToolTipText("最大化");
		maximize.setIcon(new ImageIcon("./res/chat/sysbtn_max_normal.png"));
		maximize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_max_hover.png"));
		maximize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_max_down.png"));
		maximize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getExtendedState() == JFrame.NORMAL) {
					maximize.setIcon(new ImageIcon("./res/chat/sysbtn_restore_normal.png"));
					maximize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_restore_hover.png"));
					maximize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_restore_down.png"));
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					close.setBounds(getWidth() - 26, 0, 26, 27);
					maximize.setBounds(getWidth() - 52, 0, 26, 27);
					minimize.setBounds(getWidth() - 78, 0, 26, 27);
					upPanel.setBounds(0, 0, getWidth(), 85);
					friendTrades.setBounds(51, 31, upPanel.getWidth() - 415, 15);
					showPanel.setBounds(0, 85, getWidth() - 139, getHeight() - 223);

					inputPanel.setBounds(0, getHeight() - 138, getWidth() - 139, 138);
					input.setBounds(0, 0, inputPanel.getWidth(), 106);
					inputScroll.setBounds(0, 0, inputPanel.getWidth(), 106);
					closeButton.setBounds(inputPanel.getWidth() - 165, inputPanel.getHeight() - 35, 70, 24);
					sendButton.setBounds(inputPanel.getWidth() - 91, inputPanel.getHeight() - 35, 70, 24);
					System.out.println(getWidth());
					adapter.setCanMove(false);
				} else if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
					maximize.setIcon(new ImageIcon("./res/chat/sysbtn_max_normal.png"));
					maximize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_max_hover.png"));
					maximize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_max_down.png"));
					setExtendedState(JFrame.NORMAL);
					close.setBounds(getWidth() - 26, 0, 26, 27);
					maximize.setBounds(getWidth() - 52, 0, 26, 27);
					minimize.setBounds(getWidth() - 78, 0, 26, 27);
					upPanel.setBounds(0, 0, getWidth(), 85);
					friendTrades.setBounds(55, 31, getWidth() - 115, 15);
					showPanel.setBounds(0, 85, getWidth() - 139, getHeight() - 223);
					inputPanel.setBounds(0, getHeight() - 138, getWidth() - 139, 138);
					input.setBounds(0, 0, inputPanel.getWidth(), 106);
					inputScroll.setBounds(0, 0, inputPanel.getWidth(), 106);
					closeButton.setBounds(inputPanel.getWidth() - 165, inputPanel.getHeight() - 35, 70, 24);
					sendButton.setBounds(inputPanel.getWidth() - 91, inputPanel.getHeight() - 35, 70, 24);
					adapter.setCanMove(true);
				}
			}
		});
		/**
		 * Button minimize
		 */
		// 最小化按钮
		minimize = new JButton();
		minimize.setMargin(new Insets(0, 0, 0, 0));
		minimize.setBounds(448 + 139, 0, 26, 27);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.setFocusPainted(false);
		minimize.setToolTipText("最小化");
		minimize.setIcon(new ImageIcon("./res/chat/sysbtn_min_normal.png"));
		minimize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_min_hover.png"));
		minimize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_min_down.png"));
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		/**
		 * upPanel
		 */
		upPanel = new JPanel();
		upPanel.setLayout(null);
		upPanel.setBounds(0, 0, 665, 85);
		upPanel.setBackground(new Color(224, 223, 241));
		adapter = new LoginMousemove();
		upPanel.addMouseMotionListener(adapter);
		upPanel.addMouseListener(adapter);
		upPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if (e.getClickCount() == 2) {
					// maximize
					if (getExtendedState() == JFrame.NORMAL) {
						maximize.setIcon(new ImageIcon("./res/chat/sysbtn_restore_normal.png"));
						maximize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_restore_hover.png"));
						maximize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_restore_down.png"));
						setExtendedState(JFrame.MAXIMIZED_BOTH);
						close.setBounds(getWidth() - 26, 0, 26, 27);
						maximize.setBounds(getWidth() - 52, 0, 26, 27);
						minimize.setBounds(getWidth() - 78, 0, 26, 27);
						upPanel.setBounds(0, 0, getWidth(), 85);
						friendTrades.setBounds(51, 31, upPanel.getWidth() - 415, 15);
						showPanel.setBounds(0, 85, getWidth() - 139, getHeight() - 223);

						inputPanel.setBounds(0, getHeight() - 138, getWidth() - 139, 138);
						input.setBounds(0, 0, inputPanel.getWidth(), 106);
						inputScroll.setBounds(0, 0, inputPanel.getWidth(), 106);
						closeButton.setBounds(inputPanel.getWidth() - 165, inputPanel.getHeight() - 35, 70, 24);
						sendButton.setBounds(inputPanel.getWidth() - 91, inputPanel.getHeight() - 35, 70, 24);
						System.out.println(getWidth());
						adapter.setCanMove(false);
					} else if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
						maximize.setIcon(new ImageIcon("./res/chat/sysbtn_max_normal.png"));
						maximize.setRolloverIcon(new ImageIcon("./res/chat/sysbtn_max_hover.png"));
						maximize.setPressedIcon(new ImageIcon("./res/chat/sysbtn_max_down.png"));
						setExtendedState(JFrame.NORMAL);
						close.setBounds(getWidth() - 26, 0, 26, 27);
						maximize.setBounds(getWidth() - 52, 0, 26, 27);
						minimize.setBounds(getWidth() - 78, 0, 26, 27);
						upPanel.setBounds(0, 0, getWidth(), 85);
						friendTrades.setBounds(55, 31, getWidth() - 115, 15);
						showPanel.setBounds(0, 85, getWidth() - 139, getHeight() - 223);
						inputPanel.setBounds(0, getHeight() - 138, getWidth() - 139, 138);
						input.setBounds(0, 0, inputPanel.getWidth(), 106);
						inputScroll.setBounds(0, 0, inputPanel.getWidth(), 106);
						closeButton.setBounds(inputPanel.getWidth() - 165, inputPanel.getHeight() - 35, 70, 24);
						sendButton.setBounds(inputPanel.getWidth() - 91, inputPanel.getHeight() - 35, 70, 24);
						adapter.setCanMove(true);
					}
				}
			}
		});
		/**
		 * Avatar
		 */
		friendAvatar = new JLabel(new ImageIcon(friendAvatarString));
		friendAvatar.setBounds(10, 6, 41, 37);
		friendAvatar.setIcon(new ImageIcon(headPic));
		upPanel.add(friendAvatar);
		/**
		 * Name
		 */

		friendName = new JLabel(friendNameString);
		friendName.setBounds(55, 6, 70, 22);
		upPanel.add(friendName);
		/**
		 * Trades
		 */
		friendTrades = new JLabel(friendTradesString);
		friendTrades.setBounds(55, 31, 400, 15);
		upPanel.add(friendTrades);
		/**
		 * show
		 */
		showBox = Box.createVerticalBox();
		showBox.setBackground(new Color(0, 0, 0));
		showPanel = new JScrollPane(showBox);
		showPanel.getVerticalScrollBar().setUI(new com.oicq.frame.ScrollBarUI());
		showPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// 设置滚动速率
		showPanel.getVerticalScrollBar().setUnitIncrement(20);
		showPanel.setBounds(0, 85, 526, 311);

		/*
		 * 获取聊天记录
		 */
		Vector<String> record = InteractWithServer.getChatRecord(mid, fid, isGroup);
		for (int i = 0; i < record.size(); i++) {
			/*
			 * res[0] 消息发送时间 res[1] fromId res[2] toId res[3] message
			 */
			String res[] = record.get(i).split("```", 4);
			// 聊天面板显示用户昵称
			String fromName = res[1].equals(mid) ? mName
					: MainInterface.getFriend().containsKey(res[1]) ? MainInterface.getFriend().get(res[1]).getfName()
							: ("陌生人:" + res[1]);
			if (res.length == 4) {
				addMessage(fromName, res[0], res[3], true);
			}
		}

		// showPanel.getVerticalScrollBar().setValue(showPanel.getVerticalScrollBar().getMaximum());
		showPanel.getViewport().setViewPosition(new Point(0, showPanel.getHeight() + 100));
		// System.out.println(showPanel.getVerticalScrollBar().getMaximum());

		/**
		 * input
		 */
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBounds(0, 396, 526, 138);
		input = new JTextArea();
		input.setBounds(0, 0, 526, 106);
		input.setLineWrap(true);
		inputScroll = new JScrollPane(input);
		inputScroll.setBounds(0, 0, 526, 106);
		inputScroll.getVerticalScrollBar().setUI(new com.oicq.frame.ScrollBarUI());
		inputScroll.getVerticalScrollBar().setUnitIncrement(15);
		inputPanel.add(inputScroll);

		closeButton = new JButton("<html>关闭(<u>C</u>)</html>");
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setMargin(new Insets(0, 0, 0, 0));
		closeButton.setBackground(new Color(58, 77, 195));
		closeButton.addActionListener(new ExitNowFrameListenter(this));
		closeButton.setBounds(361, 106, 70, 24);
		inputPanel.add(closeButton);

		sendButton = new JButton("<html>发送(<u>S</u>)</html>");
		sendButton.setBorderPainted(false);
		sendButton.setFocusPainted(false);
		sendButton.setMargin(new Insets(0, 0, 0, 0));
		sendButton.setBackground(new Color(58, 77, 195));
		sendButton.setBounds(435, 106, 70, 24);
		SendFriend l = new SendFriend(mName, fid, isGroup);
		l.setMessage(input);
		l.setNow(this);
		sendButton.addActionListener(l);

		inputPanel.add(sendButton);

		// 获取群成员部分
		if (isGroup) {
			groupPeopleBox = Box.createVerticalBox();
			Vector<String> members = InteractWithServer.getGroupMembers(fid);
			Box myBox = Box.createHorizontalBox();
			myBox.add(new JLabel(new ImageIcon(GetAvatar.getAvatarImage(mid, "./Data/Avatar/User/", "").getImage()
					.getScaledInstance(20, 20, Image.SCALE_DEFAULT))));
			myBox.add(new JLabel("☆我☆(" + mid + ")"));
			groupPeopleBox.add(myBox);
			for (String i : members) {
				if (i.equals(mid))
					continue;
				Box peopleBox = Box.createHorizontalBox();
				ImageIcon icon = new ImageIcon("./res/tempheadportrait.jpg");
				String content = "陌生人(" + i + ")";
				if (MainInterface.getFriend().containsKey(i)) {
					icon = GetAvatar.getAvatarImage(i, "./Data/Avatar/User/",
							MainInterface.getFriend().get(i).getfAvatar());
					content = MainInterface.getFriend().get(i).getfName() + "("
							+ MainInterface.getFriend().get(i).getFid() + ")";
				}
				icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
				peopleBox.add(new JLabel(icon));
				peopleBox.add(new JLabel(content));
				groupPeopleBox.add(peopleBox);
			}
			groupPeopleScrollPanel = new JScrollPane(groupPeopleBox);

			groupPeopleScrollPanel.getVerticalScrollBar().setUI(new com.oicq.frame.ScrollBarUI());
			groupPeopleScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			// 设置滚动速率
			groupPeopleScrollPanel.getVerticalScrollBar().setUnitIncrement(16);
			groupPeopleScrollPanel.setBounds(524, 85, 141, 449);
		} else {
			close.setBounds(500, 0, 26, 27);
			maximize.setBounds(474, 0, 26, 27);
			minimize.setBounds(448, 0, 26, 27);
			setSize(526, 534);
		}

	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messagenum) {
		this.messageNum = messagenum;
	}

	public void addMessage(String userName, String sendTime, String message, boolean isOld) {
		userName = "<html><p style =\"font-size:10px;color:#0000ff\">" + userName;
		sendTime = "<span style=\"color:#cc9966\"> " + sendTime + "</span></p></html>";
		message = "<html><p style =\"font-size:14px;" + (isOld ? "color:#969696" : "") + "\">" + message
				+ "</p><br/></html>";
		showBox.add(new JLabel(userName + sendTime));
		showBox.add(new JLabel(message));
		// showPanel.getVerticalScrollBar().setValue(showPanel.getVerticalScrollBar().getMaximum());
		showPanel.getViewport().setViewPosition(new Point(0, showPanel.getHeight() + 100000));
	}
}