import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.trumpImg, x, y, width, height, null);
	}
}
