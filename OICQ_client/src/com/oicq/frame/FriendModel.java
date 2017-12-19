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

import javax.swing.JLabel;
/**   
 * @ClassName:  FriendModel  
 * @Description: 继承自GroupModel 用于主界面显示好友模块 
 * @author: 艾尔森 
 * @date:   2016-12-8  
 *   
 * class
 * @Copyright: 2016 www.ireson.cn Inc. All rights reserved.  
 */  
public class FriendModel extends GroupModel {
	private String fOnline;
	private JLabel fOnlineLabel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FriendModel(String fAvatar, String fName, String fTrades, String fid, String fOnline) {
		super(fAvatar, fName, fTrades, fid, "./Data/Avatar/User/");
		this.fOnline = fOnline;
		fOnlineLabel = new JLabel(fOnline);
		fOnlineLabel.setBounds(232, 4, 42, 22);
		this.add(fOnlineLabel);
	}

	public String getOnline() {
		return fOnline;
	}

	public String getfOnline() {
		return fOnline;
	}

	public void setfOnline(String fOnline) {
		this.fOnline = fOnline;
		fOnlineLabel.setText(fOnline);
	}
}