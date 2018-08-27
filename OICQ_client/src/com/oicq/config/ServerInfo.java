/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		ServerInfo.java
 * @Package:	com.oicq.config
 * @Description:记录一些与服务器有关的常量信息
 * @author:		千千
 * @date:		2016/11/20 18:00
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.config;

/**
 * @ClassName: ServerInfo
 * @Description:Record some constant information about the server.
 * @author: 千千
 * @date: 2016/11/20 18:00
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */

public final class ServerInfo {
	/**
	 * @Fields SERVER_IP : 服务器地址
	 */
	public final static String SERVER_IP = "127.0.0.1";

	/**
	 * @Fields CHAT_PORT : 聊天端口监听
	 */
	public final static int CHAT_PORT = 6666;

	/**
	 * @Fields VERIFY_PORT : 验证端口监听
	 */
	public final static int VERIFY_PORT = 7777;
}
