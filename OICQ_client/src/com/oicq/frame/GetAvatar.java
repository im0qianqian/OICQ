/**
 * Create at 2016.11.23 20.50
 * by qianqian
 * 利用头像URL获取ImageIcon对象
 */
package com.oicq.frame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;

public final class GetAvatar {

	private static void download(String urlString, String filename, String savePath) throws Exception {

		// 构造URL
		URL url = new URL(urlString);

		// 打开连接
		URLConnection con = url.openConnection();

		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);

		// 输入流
		InputStream in = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];

		// 读取到的数据长度
		int len;

		// 输出的文件流
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		OutputStream out = new FileOutputStream(file.getPath() + "\\" + filename);

		// 开始读取
		while ((len = in.read(bs)) != -1) {
			out.write(bs, 0, len);
		}

		// 完毕，关闭所有链接
		out.close();
		in.close();
	}

	public static ImageIcon getAvatarImage(String id, String relativePath, String avatarUrl) {
		ImageIcon avatar = null;
		try {
			String path = relativePath + id + ".jpg";
			if (!new File(path).exists()) {
				download(avatarUrl, id + ".jpg", relativePath);
			}
			avatar = new ImageIcon(path);
		} catch (Exception e) {
			avatar = new ImageIcon("./res/tempheadportrait.jpg");
			System.out.println("获取头像失败，改为默认头像：" + avatarUrl);
		}
		return avatar;
	}
}
