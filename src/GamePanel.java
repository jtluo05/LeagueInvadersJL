import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
Timer timer;
final int MENU_STATE = 0;
int currentState= MENU_STATE;
final int GAME_STATE = 1;

final int END_STATE = 2;

Graphics g;
GamePanel(){
	timer=new Timer(1000/60,this);


}

void startGame() {
	timer.start();
	System.out.println("start");
	
}
void updateMenuState() {
	
	
}
void updateGameState() {
	
	
}
void updateEndState() {
	
	
}
void drawMenuState() {
	g.setColor(Color.BLUE);

	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);    


	
}
void drawGameState() {
	g.setColor(Color.BLACK);

	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);    


	
}
void drawEndState() {
	g.setColor(Color.RED);

	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);    


	
}
@Override

public void paintComponent(Graphics g){
	 g.fillRect(10, 10, 100, 100);
	 if(currentState == MENU_STATE){

         drawMenuState();

 }else if(currentState == GAME_STATE){

        drawGameState();

 }else if(currentState == END_STATE){

       drawEndState();

 }

        }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
repaint();
if(currentState == MENU_STATE){

    updateMenuState();

}else if(currentState == GAME_STATE){

    updateGameState();

}else if(currentState == END_STATE){

    updateEndState();

}
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hello");
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hello");	
	if (e.getKeyCode()== KeyEvent.VK_ENTER) {
	currentState++;
	if(currentState > END_STATE){

            currentState = MENU_STATE;

    }
	}

}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hello");	
}
}
