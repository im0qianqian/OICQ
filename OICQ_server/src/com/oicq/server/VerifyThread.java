/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		VerifyConnection.java
 * @Package:	com.oicq.server
 * @Description:在服务器创建验证端口的ServerSocket对象，并等待用户连接，连接成功后为该用户分配一个线程单独处理他所发出的请求
 * @author:		千千
 * @date:		2016/11/20 16:34
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.oicq.config.ServerInfo;

/**
 * @ClassName: VerifyThread
 * @Description:The server creates the ServerSocket object for the
 *                  authentication port and waits for the user to connect. After
 *                  the connection is made, the user is assigned a thread to
 *                  process the request.
 * @author: 千千
 * @date: 2016/11/20 16:34
 *
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class VerifyThread implements Runnable {

	/**
	 * @Fields serverSocket : 验证端口监听者对象
	 */
	private static ServerSocket serverSocket;

	static {
		serverSocket = new ChatServer(ServerInfo.VERIFY_PORT).getServerSocket();
	}

	/**
	 * @Title: run
	 * @Description: 等待用户连接，如果连接成功为其单独分配线程处理
	 * @see java.lang.Runnable#run()
	 * @throws: IOException
	 */
	@Override
	public void run() {
		try {
			while (true) {
				// 等待用户连接
				Socket userSocket = serverSocket.accept();

				System.out.println(userSocket.getInetAddress() + " 发送来的新的验证");

				// 为用户接入创建一个验证线程
				new Thread(new VerifyConnection(userSocket)).start();
			}
		} catch (IOException e) {
			System.out.println("验证端口服务异常 ：" + e.getMessage());
		}
	}
}
