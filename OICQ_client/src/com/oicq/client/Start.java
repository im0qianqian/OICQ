/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		Start.java
 * @Package:	com.oicq.client
 * @Description:聊天端建立，首先启动登录窗口，填入登录等信息之后会与服务端验证端口建立
 * 				连接，发送一个序列化对象ChatVerify到服务端，返回处理结果之后判断如果
 * 				成功登录则进入主界面，并接入服务器聊天端口，发送获取个人信息资料等请求，
 * 				服务端返回结果之后将其更改到主界面，好友列表里面每一个用户面板都对应该
 * 				好友/群的ID信息(这样可以在发送信息的时候判断是发送给谁的)，在聊天界面中，
 * 				首先向服务器请求聊天记录信息，并展示原有的聊天记录，发送新消息时会首先对
 * 				这个消息内容进行预处理(添加标识发送给谁与是谁发送的)，然后通过数据输出流
 * 				发出。
 * 
 * 				在更改个性签名中，也是通过连接的验证端口发送出请求，后续步骤交给服务器处理。
 * 				
 * 				在客户端实现中，用到了多线程处理机制，一方面保持主界面的流畅(不会因为线程
 * 				处理而卡顿)，另一方便也提高了聊天时与服务端的通讯效率。
 * 
 * @author:		千千
 * @date:		2016/11/26 15:49
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.client;

import com.oicq.frame.Login;

/**
 * @ClassName: Start
 * @Description:Chat-side establishment, first start the login window, fill in
 *                        the login and other information will be established
 *                        with the server-side authentication port Connection,
 *                        send a serialized object ChatVerify to the server,
 *                        return the results after processing to determine if
 *                        Successful login is to enter the main interface, and
 *                        access to the server chat port, send requests for
 *                        personal information and other information, Server to
 *                        return to the results after the change to the main
 *                        interface, buddy list inside each user panel should be
 *                        the Friends / group ID information (so you can send
 *                        information to determine who is sent to), in the chat
 *                        interface, First request to the server chat log
 *                        information, and display the original chat records,
 *                        send new messages will be the first to The content of
 *                        this message is preprocessed (with the identity sent
 *                        to and with whom) and then through the data output
 *                        stream issue.
 * 
 *                        In the change of personality signature, but also
 *                        through the connection to send a request to verify the
 *                        port, the next step to the server.
 * 
 *                        In the client implementation, the use of
 *                        multi-threaded processing mechanism, on the one hand
 *                        to maintain the smooth interface (not because the
 *                        thread Processing and Caton), another convenience also
 *                        improves the chat with the server-side communication
 *                        efficiency.
 * 
 * @author: 千千
 * @date: 2016/11/26 15:49
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */

public class Start {
	public static void main(String[] args) {
		new Login();
	}
}
