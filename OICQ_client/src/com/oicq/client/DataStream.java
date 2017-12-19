/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		DataStream.java
 * @Package:	com.oicq.client
 * @Description:与服务器聊天端口建立通讯，可以接收来自服务器的消息，也可以发送消息到服务器
 * @author:		千千
 * @date:		2016/11/22 21:45
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName: DataStream
 * @Description:Set up communication with the server chat port, can receive
 *                  messages from the server, you can also send messages to the
 *                  server.
 * @author: 千千
 * @date: 2016/11/22 21:45
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */

public final class DataStream implements Runnable {
	/**
	 * @Fields clientSocket : 与服务器连接的Socket对象
	 */
	private Socket clientSocket;

	/**
	 * @Fields in : 数据输入流，从服务器接收
	 */
	private DataInputStream in;

	/**
	 * @Fields out : 数据输出流，发送到服务器
	 */
	private DataOutputStream out;

	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;

	/**
	 * @Fields scMessage : 使用数据输入流所接收到的数据内容，可经过解析后展示到相应窗口
	 */
	private String scMessage;

	/**
	 * @Title: DataStream
	 * @Description: 初始化连接对象与用户ID，使用该连接对象创建数据输入输出流
	 * @param: clientSocket
	 *             连接对象
	 * @param: userId
	 *             用户ID
	 * @exception: IOException
	 *                 如果与服务端之间建立数据输入输出流失败，则产生IOException.
	 */
	public DataStream(Socket clientSocket, String userId) {
		this.clientSocket = clientSocket;
		this.userId = userId;
		try {
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println("创建聊天数据流失败：" + e.getMessage());
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @Description: 因为数据输入流读取时候会阻塞，所以将其单独分配在一个线程里面
	 * 
	 * @see java.lang.Runnable#run()
	 * 
	 * @exception: IOException 如果与服务器连接中断导致数据输入流读取异常，产生IOException.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				// 读取消息内容
				scMessage = in.readUTF();

				// 解析处理消息
				ChatExecute.execute(scMessage);
			}
		} catch (IOException e) {
			/* 如果程序执行到这里，可能是因为与服务器断开连接，所以需要关闭这些流 */
			try {
				in.close();
			} catch (Exception e2) {
				System.out.println("数据输入流关闭失败：" + e.getMessage());
			}
			try {
				out.close();
			} catch (Exception e2) {
				System.out.println("数据输出流关闭失败：" + e.getMessage());
			}
			try {
				clientSocket.close();
			} catch (IOException e1) {
				System.out.println("服务器连接关闭失败：" + e.getMessage());
			}
			System.out.println("与服务端失去联系 " + e.getMessage());
		}
	}

	/**
	 * @Title: send
	 * @Description:发送消息到服务器
	 * @param: message
	 *             消息内容
	 * @param: toId
	 *             发送对象ID
	 * @param: isGroup
	 *             是否发送给群
	 * @return: void
	 * @exception: IOException
	 *                 如果与服务器连接中断导致数据输出流写入异常，产生IOException.
	 */
	public void send(String message, String toId, boolean isGroup) {
		// 对发送内容进行特定编码
		message = (isGroup ? "toGroup```" : "toFriend```") + userId + "```" + toId + "```" + message;

		try {
			out.writeUTF(message);
		} catch (IOException e) {
			System.out.println("发送消息失败：" + e.getMessage());
		}
	}
}
