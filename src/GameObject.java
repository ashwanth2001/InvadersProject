import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;

	void update() {
		collisionBox.setBounds(x,y,width,height);
	}

	void draw(Graphics g) {
		// g.setColor(Color.BLUE);
		// g.fillRect(x, y, 100, 100);
	}
	public GameObject(){
		//System.out.println(x);
		//System.out.println(y);
		collisionBox = new Rectangle(x,y,width,height);
	}
}