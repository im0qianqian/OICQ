/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		UserInfo.java
 * @Package:	com.oicq.config
 * @Description:主要是为服务端与客户端之间传输用户个人信息以及好友列表、群列表而创建的可序列化类(实现了 java.io.Serializable 接口)
 * @author:		千千
 * @date:		2016/11/20 14:29
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.config;

import java.io.Serializable;
import java.util.Vector;

/**
 * @ClassName: UserInfo
 * @Description:Mainly between the server and the client transmission of
 *                     personal information and friends list, group list and
 *                     create a java.io.Serializable class (to achieve the
 *                     java.io.Serializable interface).
 * @author: 千千
 * @date: 2016/11/20 14:29
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public class UserInfo implements Serializable {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 4146085358128616967L;

	/**
	 * @Fields userId : 用户 ID
	 */
	protected String userId;

	/**
	 * @Fields userName : 用户昵称
	 */
	protected String userName;

	/**
	 * @Fields userEmail : 用户E-mail
	 */
	protected String userEmail;

	/**
	 * @Fields userSex : 用户性别
	 */
	protected String userSex;

	/**
	 * @Fields userBirthday : 用户生日
	 */
	protected String userBirthday;

	/**
	 * @Fields userAvatar : 用户头像
	 */
	protected String userAvatar;

	/**
	 * @Fields userTrades : 用户个性签名
	 */
	protected String userTrades;

	/**
	 * @Fields userRegistertime : 用户注册时间
	 */
	protected String userRegistertime;

	/**
	 * @Fields friends : 用户好友列表
	 */
	protected Vector<FriendsOrGroups> friends = new Vector<FriendsOrGroups>();

	/**
	 * @Fields groups : 用户群列表
	 */
	protected Vector<FriendsOrGroups> groups = new Vector<FriendsOrGroups>();

	/**
	 * @ClassName: FriendsOrGroups
	 * @Description:对群或者一个好友所记录的信息是一个FriendsOrGroups对象，对象中包含它的id,name,avatar,trades,status.
	 * @author: 千千
	 * @date: 2016/11/20 14:50
	 * 
	 * @since: JDK 1.8
	 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
	 */
	public static class FriendsOrGroups implements Serializable {
		/**  */
		private static final long serialVersionUID = -1855195980029629286L;

		private String id;
		private String name;
		private String avatar;
		private String trades;
		private String status;

		/**
		 * @Title: FriendsOrGroups
		 * @Description: 创建一个群信息对象或好友信息对象
		 * @param: id
		 * @param: name
		 * @param: avatar
		 * @param: trades
		 * @param: status
		 */
		public FriendsOrGroups(String id, String name, String avatar, String trades, String status) {
			this.id = id;
			this.name = name;
			this.avatar = avatar;
			this.trades = trades;
			this.status = status;
		}

		/**
		 * @Title: getId
		 * @Description: 获取好友/群id
		 * @return: id String对象
		 */
		public String getId() {
			return id;
		}

		/**
		 * @Title: getName
		 * @Description: 获取好友/群Name
		 * @return: name String对象
		 */
		public String getName() {
			return name;
		}

		/**
		 * @Title: getAvatar
		 * @Description: 获取好友/群头像链接(url)
		 * @return: avatar String对象
		 */
		public String getAvatar() {
			return avatar;
		}

		/**
		 * @Title: getTrades
		 * @Description: 获取好友/群个性签名
		 * @return: trades String对象
		 */
		public String getTrades() {
			return trades;
		}

		/**
		 * @Title: getStatus
		 * @Description: 获取好友状态(在线/离线)
		 * @return: status String对象
		 */
		public String getStatus() {
			return status;
		}
	}
}
