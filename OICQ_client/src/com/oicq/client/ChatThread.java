/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		ChatThread.java
 * @Package:	com.oicq.client
 * @Description:连接到服务器聊天端口
 * @author:		千千
 * @date:		2016/11/23 13:31
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.client;

import java.io.IOException;
import java.net.Socket;

import com.oicq.config.ServerInfo;

/**
 * @ClassName: ChatThread
 * @Description:Connect to the server chat port
 * @author: 千千
 * @date: 2016/11/23 13:31
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */

public final class ChatThread implements Runnable {
	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;

	/**
	 * @Fields dataStream : 聊天数据流传输对象，主要通过它发送消息或者接收消息
	 */
	private static DataStream dataStream;

	/**
	 * @Title: ChatThread
	 * @Description: 初始化用户ID
	 * @param: userId
	 */
	public ChatThread(String userId) {
		this.userId = userId;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Runnable#run()
	 * 
	 * @Description: 创建与服务器聊天端口的通讯，并创建线程开始(接收/发送)数据
	 * 
	 * @exception: IOException 如果与服务端建立Socket连接失败，则产生IOException.
	 */
	@Override
	public void run() {
		Socket myHost = null;
		try {
			// 创建与服务端的连接
			myHost = new Socket(ServerInfo.SERVER_IP, ServerInfo.CHAT_PORT);

			// 聊天数据信息流，用来接收或者发送信息
			dataStream = new DataStream(myHost, userId);
			new Thread(dataStream).start();
		} catch (IOException e) {
			System.out.println("创建与服务端的连接出错：" + e.getMessage());
		}
	}

	/**
	 * @Title: getDataStream
	 * @Description: 返回与服务器聊天端口创建的信息数据流对象
	 * @return: dataStream 流对象
	 */
	public static DataStream getDataStream() {
		return dataStream;
	}
}
