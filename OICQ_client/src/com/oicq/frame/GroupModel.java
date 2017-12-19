/**  
 * All rights Reserved, Designed By www.ireson.cn
 * @Title:  GroupModel.java
 * @Package com.oicq.frame   
 * @Description: 存放GroupModel类
 * @author: 艾尔森 
 * @version V1.0 
 * @Copyright: 2016 www.irson.cn Inc. All rights reserved. 
 */  
package com.oicq.frame;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
/**   
 * @ClassName:  GroupModel 
 * @Description: 用于主界面显示群的相关信息 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
public class GroupModel extends JRadioButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fAvatar, fName, fTrades, fid;
	private JLabel fAvatarLabel, fNameLabel, fTradesLabel;

	public GroupModel(String fAvatar, String fName, String fTrades, String fid, String avatarPath) {
		this.fAvatar = fAvatar;
		this.fName = fName;
		this.fTrades = fTrades;
		this.fid = fid;
		this.setMargin(new Insets(0, 0, 0, 0));
		this.setIcon(new ImageIcon("./res/mainpanel/friend_normal.png"));
		this.setRolloverIcon(new ImageIcon("./res/mainpanel/friend_hover.png"));
		this.setPressedIcon(new ImageIcon("./res/mainpanel/friend_selected.png"));
		this.setSelectedIcon(new ImageIcon("./res/mainpanel/friend_selected.png"));
		this.setLayout(null);
		fAvatarLabel = new JLabel();

		// ImageIcon headIcon = new ImageIcon(temp);
		fAvatarLabel.setIcon(new ImageIcon((GetAvatar.getAvatarImage(fid, avatarPath, fAvatar)).getImage()
				.getScaledInstance(41, 41, Image.SCALE_DEFAULT)));

		fAvatarLabel.setBounds(8, 4, 41, 41);
		this.add(fAvatarLabel);
		fNameLabel = new JLabel(fName);
		fNameLabel.setBounds(56, 4, 176, 22);
		this.add(fNameLabel);
		fTradesLabel = new JLabel(fTrades);
		fTradesLabel.setBounds(56, 56, 218, 19);
		fTradesLabel.setToolTipText(fTrades);
		this.add(fTradesLabel);
	}

	public String getfAvatar() {
		return fAvatar;
	}

	public String getfName() {
		return fName;
	}

	public String getfTrades() {
		return fTrades;
	}

	public String getFid() {
		return fid;
	}

	public void setfAvatar(String fAvatar) {
		this.fAvatar = fAvatar;
		fAvatarLabel.setIcon(new ImageIcon((GetAvatar.getAvatarImage(fid, "./Data/Avatar/Group/", fAvatar)).getImage()
				.getScaledInstance(41, 41, Image.SCALE_DEFAULT)));
	}

	public void setfName(String fName) {
		this.fName = fName;
		fNameLabel.setText(fName);
	}

	public void setfTrades(String fTrades) {
		this.fTrades = fTrades;
		fTradesLabel.setText(fTrades);
	}
}
