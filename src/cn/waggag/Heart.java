package cn.waggag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 *  七夕  3D爱心
 * @author waggag
 * 2018年8月17日 下午6:38:34
 */
@SuppressWarnings("all")
public class Heart extends JFrame {

	// 定义窗口,为了实现高可用,这里抽离出公共的成员
	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;

	// 屏幕大小
	private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;


	// 构造器
	public Heart() {
		super("刚好遇见你,余生都是你");
		// 各项属性
		this.setLayout(getLayout());
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLocation((WINDOW_WIDTH - WIDTH) / 2, (WINDOW_HEIGHT - HEIGHT) / 2);
		this.setSize(WIDTH, HEIGHT);
		// 关闭窗口即结束进程
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		System.out.println(WINDOW_HEIGHT+"="+WINDOW_WIDTH+"");
	}

	public void paint(Graphics g) {
		// 横纵坐标和半径
		double x, y, r;
		Image image = this.createImage(500, 600);
		Graphics graphics = image.getGraphics();
		// 画图
		for (int i = 0; i < 90; i++) {
			for (int j = 0; j < 90; j++) {

				r = Math.PI / 45 + Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
				x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + WIDTH / 2;
				y = -r * Math.sin(Math.PI / 45 * j) + HEIGHT / 2;

				graphics.setColor(Color.red);
				graphics.fillOval((int) x, (int) y, 3, 3);
			}
			g.drawImage(image, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		new Heart();
	}

}


