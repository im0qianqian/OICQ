/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		ChatThread.java
 * @Package:	com.oicq.server
 * @Description:服务器聊天端口的监听，等待用户连接
 * @author:		千千
 * @date:		2016/11/20 14:59
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.server;

import java.io.IOException;
import java.net.Socket;

import com.oicq.config.ServerInfo;

/**
 * @ClassName: ChatThread
 * @Description:Server chat port monitoring, waiting for users to connect.
 * @author: 千千
 * @date: 2016/11/20 14:59
 *
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class ChatThread implements Runnable {

	/**
	 * @Fields userId : 该线程内用户ID
	 */
	private String userId;

	/**
	 * @Fields userSocket : 该用户连接所生成的Socket对象
	 */
	private Socket userSocket;

	/**
	 * @Fields chatServerInfo : 聊天端口监听者对象
	 */
	private static ChatServer chatServerInfo;

	static {
		chatServerInfo = new ChatServer(ServerInfo.CHAT_PORT);
	}

	/**
	 * @Title: ChatThread
	 * @Description: 初始化用户ID
	 * @param userId
	 */
	public ChatThread(String userId) {
		this.userId = userId;
	}

	/**
	 * @Title: run
	 * @Description:等待客户端连接，成功连接之后为其创建一个聊天数据流对象
	 * @see java.lang.Runnable#run()
	 * @throws:IOException
	 */
	@Override
	public void run() {
		// 先与客户端建立聊天端口的连接
		try {
			userSocket = chatServerInfo.getServerSocket().accept();
		} catch (IOException e) {
			System.out.println("未能与客户端成功建立连接：" + e.getMessage());
			return;
		}

		// 成功接入之后建立数据流
		DataStream dataStream = new DataStream(userSocket, userId);

		// 加入到在线人员映射里面
		ChatServer.getClientUser().put(userId, dataStream);

		System.out.println("用户 " + userId + " 已成功登录 ,Info: " + userSocket.getInetAddress());
		System.out.println("当前在线人数： " + ChatServer.getClientUser().size());

		dataStream.run();
	}
}
