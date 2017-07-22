import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Alien extends GameObject {


	public Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		super.update();
		y = y + 10;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.cnnImg, x, y, width, height, null);
	}
}