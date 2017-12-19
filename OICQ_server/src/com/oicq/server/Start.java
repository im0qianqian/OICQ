/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		Start.java
 * @Package:	com.oicq.server
 * @Description:服务端启动，同时监听两个端口(验证端口与聊天端口)，当用户登录时会发送
 * 				一个已序列化的ChatVerify对象(其中包括用户名和加密后的密码)到验证端口，
 * 				查询数据库如果该用户存在则返回登录成功，然后允许该用户接入聊天端口，在聊
 * 				天时，用户所发送的聊天内容都会经过聊天端口被服务器接收，并且发送的内容
 * 				经过某种特定标识处理(这样可以告诉服务端该消息是谁发出的，发送给谁等)，
 * 				服务端对消息内容识别之后找到发送的目标，并转发给该用户。
 * 				
 * 				关于如何找到发送的目标，在服务端有一个静态哈希映射，它是以用户的ID为键，
 * 				和为该用户连接到服务器所创建的数据交换流对象为值。所以我们可以通过一个ID
 * 				找到相应的输出流，然后就可以转发数据，对于群聊天来说，需要转发的目标则是
 * 				这个群的所有成员。而在用户登录成功之后，服务端会自动将其所拥有的数据交换流
 * 				对象加入到哈希映射中，用户离线后则删除它。
 * 
 * 				在一个用户登录或离线时，同时也会在服务端生成一个标识字串发送给该用户的所有
 * 				好友以通知当前的上线/离线情况。
 * 
 * 				在验证端口所实现的功能主要是用户的登录验证，信息等数据的请求与更新，比如
 * 				在更新用户个性签名时会发送来一个标识字串，其中包括一个验证标识(属于哪种操作)，
 * 				需要修改的目标ID(固定，不可自定义)，与新的个性签名，然后针对这种标识字串处理
 * 				之后得出所要执行的操作，完成任务。
 * 
 * 				整个服务端用到了多线程处理机制，在采用并行处理的同时也可以保证服务端的正常
 * 				运作。
 * 
 * @author:		千千
 * @date:		2016/11/26 15:29
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.server;

/**
 * @ClassName: Start
 * @Description:The server starts and listens for both ports (authentication and
 *                  chat), which are sent when the user logs in A serialized
 *                  ChatVerify object (which includes the user name and the
 *                  encrypted password) to the authentication port, Query the
 *                  database if the user returns a successful login, and then
 *                  allow the user to access the chat port, chat Day, the user
 *                  sends the chat content will be through the chat port by the
 *                  server to receive, and send the content Through a specific
 *                  identification process (so you can tell the server who sent
 *                  the message, sent to, etc.), After the server identifies the
 *                  content of the message to find the target to send, and
 *                  forwarded to the user.
 * 
 *                  On how to find the target to send in the service side has a
 *                  static hash map, which is the user's ID key, And the value
 *                  of the data exchange stream object created for the user to
 *                  connect to the server. So we can pass an ID Find the
 *                  corresponding output stream, and then you can forward the
 *                  data, for group chat, the need to forward the target is All
 *                  members of this group. After the user logs in successfully,
 *                  the server will automatically have the data exchange flow
 *                  The object is added to the hash map, and when the user is
 *                  offline, it is deleted.
 * 
 *                  In a user login or offline, but also in the server generates
 *                  an identity string sent to the user all Friends to inform
 *                  the current on-line / offline situation.
 * 
 *                  In the verification port to achieve the main functions of
 *                  the user's login authentication, information and other data
 *                  requests and updates, such as An identity string is sent
 *                  when the user's personal signature is updated, including a
 *                  validation identity (which action it belongs to) Need to
 *                  modify the target ID (fixed, can not be customized), and the
 *                  new personality signature, and then deal with this identity
 *                  string And then come to the implementation of the operation
 *                  to complete the task.
 * 
 *                  The server uses a multi-threaded processing mechanism,
 *                  parallel processing can be used in the same time to ensure
 *                  the normal server Operation.
 * 
 * @author: 千千
 * @date: 2016/11/26 15:29
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public class Start {
	public static void main(String[] args) {
		new Thread(new VerifyThread()).start();
		System.out.println("服务端已成功创建,当前在线人数：0");
	}
}
