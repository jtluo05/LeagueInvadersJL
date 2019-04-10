 import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	int currentState = MENU_STATE;
	final int GAME_STATE = 1;
	int enemiesKilled = 0;
	final int END_STATE = 2;
	Font titleFont;
	Font regularFont;
	int speed = 20;

	Rocketship rs = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(rs);
	Graphics g;

	GamePanel() {
		timer = new Timer(1000 / 20, this);
		titleFont = new Font("Arial", Font.PLAIN, 40);
		regularFont = new Font("Arial", Font.PLAIN, 30);
	}

	void startGame() {
		timer.start();
		System.out.println("start");

	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
om.manageEnemies();
om.checkCollision();
om.purgeObjects();
if(rs.isAlive==false) {
	currentState=END_STATE;
}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("LEAUGUE INVADERS", 45, 100);
		g.setFont(regularFont);
		g.drawString("Press ENTER to start", 100, 400);
		g.drawString("Press SPACE for instructions", 63, 600);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		om.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
enemiesKilled=om.getScore();
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(regularFont);
		g.drawString("You killed " + enemiesKilled + " enemies", 100, 400);
		g.drawString("Press ENTER to restart", 75, 600);

	}

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

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
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			if (currentState==END_STATE) {
			Rocketship rs=new Rocketship(250, 700, 50, 50);
				ObjectManager o=new ObjectManager(rs);
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.x -= speed;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.x += speed;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.y -= speed;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.y += speed;

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("pew pew");
			om.addProjectile(new Projectile(rs.xOfGun(), rs.y, 10, 10));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
