import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	int repeat = 17;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Rocketship ship;
	ObjectManager manager;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage cnnImg;
	public static BufferedImage trumpImg;
	public static BufferedImage johnnyImg;

	// GameObject object;
	public void updateMenuState() {

	}

	public void updateGameState() {
		// ship.update();
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (ship.isAlive) {
		} else {
			currentState = END_STATE;
			manager.reset();
			ship = new Rocketship(ship.x, ship.y, ship.width, ship.height, ship.speed);
			manager.addObject(ship);
		}
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 100);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		// ship.draw(g);
		manager.draw(g);
		int score = manager.getScore();
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString(new Integer(score).toString(), 50, 50);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		// object.update();
	}

	public GamePanel() {
		timer = new Timer(repeat, this);
		// object = new GameObject();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		ship = new Rocketship(250, 700, 50, 50, 20);
		manager = new ObjectManager();
		manager.addObject(ship);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			cnnImg = ImageIO.read(this.getClass().getResourceAsStream("Cnn.png"));
			trumpImg = ImageIO.read(this.getClass().getResourceAsStream("trump.png"));
			johnnyImg = ImageIO.read(this.getClass().getResourceAsStream("HeresJohnny.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		// object.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// object.y = object.y - 100;
			ship.y = ship.y - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// object.y = object.y + 20;
			ship.y = ship.y + ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// object.x = object.x - 20;
			ship.x = ship.x - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// object.x = object.x + 20;
			ship.x = ship.x + ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END_STATE) {
				currentState = MENU_STATE;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addObject(new Projectile(ship.x + 20, ship.y - 10, 10, 10, 10));
		}
		revalidate();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// object.y = object.y - 100;
			ship.y = ship.y - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// object.y = object.y + 20;
			ship.y = ship.y + ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// object.x = object.x - 20;
			ship.x = ship.x - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// object.x = object.x + 20;
			ship.x = ship.x + ship.speed;
		}
		revalidate();
		repaint();
	}
}
