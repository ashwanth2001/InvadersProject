import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel b;
	final static int width = 500;
	final int height = 800;

	public static void main(String[] args) {
		LeagueInvaders a = new LeagueInvaders();
		a.setup();
	}

	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(width, height);
		b.startGame();
	}

	public LeagueInvaders() {
		frame = new JFrame();
		b = new GamePanel();
		frame.add(b);
		frame.addKeyListener(b);
	}
}
