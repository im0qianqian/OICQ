/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		MailUtil.java
 * @Package:	com.oicq.email
 * @Description:利用SMTP邮件发送协议发送邮件
 * @author:		千千
 * @date:		2016/11/22 12:10
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @ClassName: MailUtil
 * @Description:Send mail using the SMTP mail delivery protocol.
 * @author: 千千
 * @date: 2016/11/22 12:10
 *
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class MailUtil {
	/**
	 * @Fields PROTOCOL : 邮件发送协议 
	 */
	private final static String PROTOCOL = "smtp";

	/**
	 * @Fields MAIL_HOST : SMTP邮件服务器
	 */
	private final static String MAIL_HOST = "smtp.exmail.qq.com";

	/**
	 * @Fields IS_AUTH : 是否要求身份认证
	 */
	private final static String IS_AUTH = "true";

	/**
	 * @Fields PORT : SMTP邮件服务器默认端口
	 */
	private final static String PORT = "25";

	/**
	 * @Fields SEND_USER : 发件人用户名
	 */
	private String SEND_USER = "";

	/**
	 * @Fields SEND_UNAME : 发件人邮箱
	 */
	private String SEND_UNAME = "";

	/**
	 * @Fields SEND_PWD : 发件人密码
	 */
	private String SEND_PWD = "";

	/**
	 * @Fields message : 建立会话
	 */
	private MimeMessage message;

	/**
	 * @Fields session
	 */
	private Session session;

	/**
	 * @Title: MailUtil
	 * @Description: 初始化方法
	 * @throws:
	 */
	public MailUtil() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", PROTOCOL);
		props.setProperty("mail.smtp.host", MAIL_HOST);
		props.setProperty("mail.smtp.port", PORT);
		props.setProperty("mail.smtp.auth", IS_AUTH);
		session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
			}
		});
		// 是否启用调试模式
		// s.setDebug(true);
		message = new MimeMessage(session);
	}

	public void sendHtmlEmail(String emailTitle, String emailContent, String toUser) {
		try {
			// 发件人
			InternetAddress from = new InternetAddress(SEND_USER);
			message.setFrom(from);

			// 收件人
			InternetAddress to = new InternetAddress(toUser);
			message.setRecipient(Message.RecipientType.TO, to);

			// 邮件标题
			message.setSubject(emailTitle);

			// 邮件内容
			message.setContent(emailContent, "text/html;charset=GBK");
			message.saveChanges();

			// SMTP 验证
			Transport transport = session.getTransport("smtp");
			transport.connect(MAIL_HOST, SEND_UNAME, SEND_PWD);

			// 开始发送
			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
		} catch (Exception e) {
			System.out.println("邮件发送失败：" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		MailUtil se = new MailUtil();
		String titleString = "这只是一个普通的邮件";
		String contentString = "你好的，我是一只小小鸟<hr/><b>123456</b>";
		se.sendHtmlEmail(titleString, contentString, "qian1335661317@qq.com");
		System.out.println("END");
	}
}
