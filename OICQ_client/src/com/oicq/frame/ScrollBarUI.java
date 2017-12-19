/**
 * All rights Reserved, Designed By www.dreamwings.cn
 * @Title:		ScrollBarUI.java
 * @Package:	com.oicq.frame
 * @Description:美化 JScrollPane 滚动条，为其添加自定义样式
 * @author:		千千
 * @date:		2016/11/22 17:39
 * @version:	V1.0
 * @Copyright:	2016 www.dreamwings.cn Inc. All rights reserved.
 */

package com.oicq.frame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @ClassName: ScrollBarUI
 * @Description:Beautify the JScrollPane Scrollbar to add a custom style to it.
 * @author: 千千
 * @date: 2016/11/22 17:39
 * 
 * @since: JDK 1.8
 * @Copyright: 2016 www.dreamwings.cn Inc. All rights reserved.
 */
public final class ScrollBarUI extends BasicScrollBarUI {

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#configureScrollBarColors()
	 * 
	 * @Description:更改滑道颜色与滚动条宽度
	 */
	@Override
	protected void configureScrollBarColors() {
		// 滑道
		trackColor = new Color(0, 0, 0, 0);

		// 滚动条宽度
		scrollBarWidth = 10;
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		super.paintTrack(g, c, trackBounds);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * javax.swing.plaf.basic.BasicScrollBarUI#paintThumb(java.awt.Graphics,
	 * javax.swing.JComponent, java.awt.Rectangle)
	 * 
	 * @Description:更改滚动条内部样式(滑块颜色,滑块宽度,把手颜色等)
	 */
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		// 重写父类方法，如果不加这一句无法拖动滑动条
		g.translate(thumbBounds.x, thumbBounds.y);

		// 设置把手颜色
		g.setColor(Color.black);

		// 消除锯齿
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.addRenderingHints(rh);

		// 设置半透明效果
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));

		// 填充圆角矩形
		g2.fillRoundRect(0, 0, 10, thumbBounds.height - 1, 15, 15);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createIncreaseButton(int)
	 * 
	 * @Description:隐藏向下点击的按钮
	 * 
	 */
	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton();

		// 使按钮不显示
		button.setVisible(false);
		return button;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createIncreaseButton(int)
	 * 
	 * @Description:隐藏向上点击的按钮
	 * 
	 */
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton();
		button.setVisible(false);
		return button;
	}
}
