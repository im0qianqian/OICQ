/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		User.java
 * @Package:	com.oicq.user
 * @Description:用户信息对象
 * @author:		千千
 * @date:		2016/11/20 17:44
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.user;

import java.util.Vector;

import com.oicq.config.UserInfo;

/**
 * @ClassName: User
 * @Description:User Info.
 * @author: 千千
 * @date: 2016/11/20 17:44
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class User extends UserInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2844611810327524136L;

	/**
	 * @Title: User
	 * @Description: 初始化用户信息内容
	 * @param userId
	 * @param userName
	 * @param userEmail
	 * @param userSex
	 * @param userBirthday
	 * @param userAvatar
	 * @param userTrades
	 * @param userRegistertime
	 * @param friends
	 * @param groups
	 */
	public User(String userId, String userName, String userEmail, String userSex, String userBirthday,
			String userAvatar, String userTrades, String userRegistertime, Vector<FriendsOrGroups> friends,
			Vector<FriendsOrGroups> groups) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userAvatar = userAvatar;
		this.userTrades = userTrades;
		this.userRegistertime = userRegistertime;
		this.friends = friends;
		this.groups = groups;
	}

	/**
	 * @Title: getUserId
	 * @Description: 获取用户ID
	 * @return: userId String对象
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @Title: getUserName
	 * @Description: 获取用户昵称
	 * @return: userName String对象
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @Title: getUserEmail
	 * @Description: 获取用户Email
	 * @return: userEmail String对象
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @Title: getUserSex
	 * @Description: 获取用户性别
	 * @return: userSex String对象
	 */
	public String getUserSex() {
		return userSex;
	}

	/**
	 * @Title: getUserBirthday
	 * @Description: 获取用户生日
	 * @return: userBirthday String对象
	 */
	public String getUserBirthday() {
		return userBirthday;
	}

	/**
	 * @Title: getUserAvatar
	 * @Description: 获取用户头像链接(url)
	 * @return: userAvatar String对象
	 */
	public String getUserAvatar() {
		return userAvatar;
	}

	/**
	 * @Title: getUserTrades
	 * @Description: 获取用户个性签名
	 * @return: userTrades String对象
	 */
	public String getUserTrades() {
		return userTrades;
	}

	/**
	 * @Title: getUserRegistertime
	 * @Description: 获取用户注册时间
	 * @return: userRegistertime String对象
	 */
	public String getUserRegistertime() {
		return userRegistertime;
	}

	/**
	 * @Title: getFriends
	 * @Description: 获取用户好友列表ID
	 * @return: friends String对象
	 */
	public Vector<FriendsOrGroups> getFriends() {
		return friends;
	}

	/**
	 * @Title: getGroups
	 * @Description: 获取用户群列表ID
	 * @return: groups String对象
	 */
	public Vector<FriendsOrGroups> getGroups() {
		return groups;
	}
}
