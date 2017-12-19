/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		DataCheck.java
 * @Package:	com.oicq.database
 * @Description:针对数据库的一些查询与更新函数，并对每种操作提供相应的SQL语句
 * @author:		千千
 * @date:		2016/11/21 12:27
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.oicq.config.UserInfo;
import com.oicq.config.UserInfo.FriendsOrGroups;
import com.oicq.server.ChatServer;
import com.oicq.user.User;

/**
 * @ClassName: DataCheck
 * @Description:For the database query and update some of the functions, and for
 *                  each operation to provide the appropriate SQL statement.
 * @author: 千千
 * @date: 2016/11/21 12:27
 *
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class DataCheck {

	/**
	 * @Title: isLoginSuccess
	 * @Description: 利用客户端发送来的用户名与MD5加密后的密码查询该用户是否存在于数据库
	 * @param: userId
	 *             用户名
	 * @param: userPassword
	 *             加密后的密码
	 * @return: Boolean 是否存在该用户
	 * @throws: SQLException
	 *              获取结果集失败抛出该异常
	 */
	public Boolean isLoginSuccess(String userId, String userPassword) {
		Boolean isSuccess = new Boolean(false);
		try {
			// 查询该用户是否存在
			DataBaseConnection dataCon = new DataBaseConnection();
			String sql = "select * from dw_user where user_id = " + userId + " and user_password = '" + userPassword
					+ "'";

			// 如果存在该用户，返回true
			isSuccess = dataCon.getFromDatabase(sql).next();

			// 关闭与服务器连接对象
			dataCon.close();
		} catch (SQLException e) {
			System.out.println("身份验证信息查询失败:" + e.getMessage());
		}
		return isSuccess;
	}

	/**
	 * @Title: getMemberFromId
	 * @Description: 通过ID与SQL获取最终结果集
	 * @param: sql
	 *             SQL语句
	 * @param: row
	 *             选择哪一个属性
	 * @return: Vector<String> 最终查询到的结果
	 * @throws: SQLException
	 *              获取结果失败抛出该异常
	 */
	private static Vector<String> getMemberFromId(String sql, String row) {
		// 与数据库创建连接
		DataBaseConnection dataCon = new DataBaseConnection();

		// 最终结果Vector数组
		Vector<String> member = new Vector<String>();

		// 利用该sql语句查询，返回ResultSet结果集
		ResultSet resultSet = dataCon.getFromDatabase(sql);
		try {
			while (resultSet.next()) {
				member.add(resultSet.getString(row));
			}
			// 关闭连接
			dataCon.close();
		} catch (SQLException e) {
			System.out.println("查询成员ID列表失败：" + e.getMessage());
		}
		return member;
	}

	/**
	 * @Title: getFriendMember
	 * @Description: 查询用户的所有好友ID
	 * @param myselfId
	 *            用户ID
	 * @return Vector<String> 好友列表Vector数组
	 */
	public static Vector<String> getFriendMember(String myselfId) {
		String sqlString = "select myfriend from dw_useruser where myself = " + myselfId;
		return getMemberFromId(sqlString, "myfriend");
	}

	/**
	 * @Title: getGroupMember
	 * @Description: 查询群中所有成员的ID
	 * @param groupId
	 *            群ID
	 * @return Vector<String> 返回群成员列表Vector数组
	 */
	public static Vector<String> getGroupMember(String groupId) {
		String sqlString = "select user_id from dw_usergroup where group_id = " + groupId;
		return getMemberFromId(sqlString, "user_id");
	}

	/**
	 * @Title: getUserFriends
	 * @Description: 获取用户好友信息
	 * @param userId
	 *            用户ID
	 * @param dataCon
	 *            与数据库连接对象
	 * @return Vector<FriendsOrGroups> 返回最终获取的好友信息列表Vector数组
	 * @throws: SQLException
	 *              查询结果集失败抛出该异常
	 */
	public Vector<FriendsOrGroups> getUserFriends(String userId, DataBaseConnection dataCon) {
		Vector<FriendsOrGroups> friends = new Vector<FriendsOrGroups>();

		// 查询好友信息
		String sqlString = "select * from view_useruser where myself = " + userId;
		ResultSet resultSet = dataCon.getFromDatabase(sqlString);
		try {
			while (resultSet.next()) {
				String fId = resultSet.getString("myfriend");
				String fName = resultSet.getString("user_name");
				String fAvatar = resultSet.getString("user_avatar");
				String fTrade = resultSet.getString("user_trades");
				String fStatus = ChatServer.getClientUser().containsKey(fId) ? "在线" : "离线";
				friends.add(new FriendsOrGroups(fId, fName, fAvatar, fTrade, fStatus));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("获取好友信息失败 " + e.getMessage());
		}
		return friends;
	}

	/**
	 * @Title: getUserGroups
	 * @Description: 获取用户群信息
	 * @param userId
	 *            用户ID
	 * @param dataCon
	 *            与数据库连接对象
	 * @return Vector<FriendsOrGroups> 返回最终获取的群信息列表Vector数组
	 * @throws: SQLException
	 *              查询结果集失败抛出该异常
	 */
	public Vector<FriendsOrGroups> getUserGroups(String userId, DataBaseConnection dataCon) {
		Vector<FriendsOrGroups> groups = new Vector<FriendsOrGroups>();

		// 查询群信息
		String sqlString = "select * from view_usergroup where user_id = " + userId;
		ResultSet resultSet = dataCon.getFromDatabase(sqlString);
		try {
			while (resultSet.next()) {
				String gId = resultSet.getString("group_id");
				String gName = resultSet.getString("group_name");
				String gTrades = resultSet.getString("group_trades");
				String gAvatar = resultSet.getString("group_avatar");
				String gStatus = resultSet.getString("user_id");
				groups.add(new FriendsOrGroups(gId, gName, gAvatar, gTrades, gStatus));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("DataCheck 获取好友群失败 " + e.getMessage());
		}
		return groups;
	}

	/**
	 * @Title: getUserInfo
	 * @Description: 获取用户信息(包括个人资料，群列表及资料，好友列表及资料)
	 * @param userId
	 *            需要获取的用户ID
	 * @return UserInfo 返回UserInfo用户信息对象
	 * @throws:SQLException 查询结果集失败抛出该异常
	 */
	public UserInfo getUserInfo(String userId) {
		// 用户个人信息
		String userName = "";
		String userEmail = "";
		String userSex = "";
		String userBirthday = "";
		String userAvatar = "";
		String userTrades = "";
		String userRegistertime = "";
		Vector<FriendsOrGroups> friends;
		Vector<FriendsOrGroups> groups;
		UserInfo userInfo = null;

		try {
			// 创建数据库连接
			DataBaseConnection dataCon = new DataBaseConnection();

			// 查询个人信息
			String sqlString = "select * from dw_user where user_id = " + userId;
			ResultSet resultSet = dataCon.getFromDatabase(sqlString);
			while (resultSet.next()) {
				userName = resultSet.getString("user_name");
				userEmail = resultSet.getString("user_email");
				userSex = resultSet.getString("user_sex");
				userBirthday = resultSet.getString("user_birthday");
				userAvatar = resultSet.getString("user_avatar");
				userTrades = resultSet.getString("user_trades");
				userRegistertime = resultSet.getString("user_registertime");
			}
			resultSet.close();

			// 查询好友列表信息与群列表信息
			friends = getUserFriends(userId, dataCon);
			groups = getUserGroups(userId, dataCon);

			// 关闭数据库连接
			dataCon.close();
			// 创建对象
			userInfo = new User(userId, userName, userEmail, userSex, userBirthday, userAvatar, userTrades,
					userRegistertime, friends, groups);
		} catch (SQLException e) {
			System.out.println("获取用户信息失败：" + e.getMessage());
		}
		return userInfo;
	}

	/**
	 * @Title: getChatRecord
	 * @Description: 获取聊天记录
	 * @param fromId
	 *            交互方1
	 * @param toId
	 *            交互方2
	 * @param isGroup
	 *            是否获取群聊天记录
	 * @return Vector<String> 返回聊天记录结果Vector数组
	 * @throws:SQLException 查询结果集失败抛出该异常
	 */
	public Vector<String> getChatRecord(String fromId, String toId, String isGroup) {
		Vector<String> all = new Vector<String>();

		// 创建数据库连接对象
		DataBaseConnection dataCon = new DataBaseConnection();
		String sqlString = "";
		if (isGroup.equals("true"))
			sqlString = "select gchat_uid fromid,gchat_gid toid,gchat_message message,gchat_datetime timer from dw_groupchat where gchat_gid = "
					+ toId;
		else
			sqlString = "select uchat_fromid fromid,uchat_toid toid,uchat_message message,uchat_datetime timer from dw_userchat where (uchat_fromid ="
					+ fromId + " and uchat_toid = " + toId + ") or (uchat_fromid = " + toId + " and uchat_toid = "
					+ fromId + ")";
		ResultSet resultSet = dataCon.getFromDatabase(sqlString);
		try {
			String tmp = "";
			while (resultSet.next()) {
				tmp = resultSet.getString("timer") + "```";
				tmp += resultSet.getString("fromid") + "```";
				tmp += resultSet.getString("toid") + "```";
				tmp += resultSet.getString("message");
				all.add(tmp);
			}

			// 关闭连接
			dataCon.close();
		} catch (SQLException e) {
			System.out.println("获取聊天记录信息失败：" + e.getMessage());
		}
		return all;
	}
}
