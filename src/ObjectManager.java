import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ObjectManager(Rocketship r) {
this.r=r;
	
	}
	
	void update() {
		r.update();
		for( Projectile p: projectiles) {
			p.update();
			}
	}
	void draw(Graphics g) {
		r.draw(g);
		for( Projectile p: projectiles) {
			p.draw(g);
			
			}
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
}
