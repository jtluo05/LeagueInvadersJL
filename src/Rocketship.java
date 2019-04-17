import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
boolean isMoving=false;
int direction ;
int speed=22;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
super.update();
if (isMoving) {
	 if (direction== KeyEvent.VK_LEFT) {
			x-=speed;
		} else if (direction== KeyEvent.VK_RIGHT) {
			x+=speed;
		} else if (direction == KeyEvent.VK_UP) {
			y-=speed;
		} else if (direction == KeyEvent.VK_DOWN) {
			y+=speed;
		} 
}
	if (x<=0) {
		x=1;
	}
	if (y<=0) {
		y=1;
	}
	if (x>=450) {
		x=450;
	}
	if (y>=750) {
		y=750;
	}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	
	int xOfGun() {
		int loc=x+width/2-5;
		return loc;
	}
}
