import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		speed = 10;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		super.update();
		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
