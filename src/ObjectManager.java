import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship r) {
		this.r = r;

	}

	int getScore() {
		return score;
	}

	void update() {
		r.update();
		for (Projectile p : projectiles) {
			p.update();
		}
		for (Alien a : aliens) {
			a.update();
		}
		getScore();
	}

	void draw(Graphics g) {
		r.draw(g);
		for (Projectile p : projectiles) {
			p.draw(g);
		}
		for (Alien a : aliens) {
			a.draw(g);
		}

	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAliens(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAliens(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}

	}

	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			

			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {

			if (r.collisionBox.intersects(a.collisionBox)) {
				a.isAlive = false;
				r.isAlive = false;
break;
			}

			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					score++;
					p.isAlive = false;
					a.isAlive = false;

				}
			}
		}

	}
}