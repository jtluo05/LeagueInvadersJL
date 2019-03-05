import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
JFrame frame;
static final int width=500;
static final int height=800;
	public static void main(String[] args) {
		LeagueInvaders li=new LeagueInvaders();
	li.setup();
	
	
}
LeagueInvaders(){
		frame=new JFrame();
		}	
void setup() {
		frame.add(new GamePanel());
	frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));

        frame.pack();
		
	}

}
