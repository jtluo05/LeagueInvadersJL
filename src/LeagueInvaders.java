import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

static final int WIDTH=500;
static final int HEIGHT=800;
JFrame frame;
GamePanel gp;
	public static void main(String[] args) {
		
		LeagueInvaders li=new LeagueInvaders();
	li.setup();
	


	
}

LeagueInvaders(){
		frame=new JFrame();
		gp=new GamePanel();
		}	
void setup() {
	
	frame.add(gp);
	frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));

		frame.pack();
		frame.addKeyListener(gp);
	
  
       
		gp.startGame();
	}

}
