//LaDarion Wells
import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class FreezeTag {

	private BouncingBall[] balls;
	
	// a constructor that creates 5 ball objects with random colors
	public FreezeTag(){
		StdDraw.enableDoubleBuffering();
		balls = new BouncingBall[5];
		Random rng = new Random();
		for (int i = 0; i < balls.length; i++) {
			Color color = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			balls[i] = new BouncingBall(color);
		}	
	}
	
	public void animate() {
		StdDraw.clear();
		for (int i = 0; i < balls.length; i++) {
			balls[i].draw();
			balls[i].update();
		}
		StdDraw.show();
		StdDraw.pause(10);
	}
	
	// method that freezes ball once clicked
	public void freeze(double x, double y) { 
		for(int i = 0; i< balls.length; ++i) {
			if(balls[i].isClicked(x, y)) {
				balls[i].setXVel(0);
				balls[i].setYVel(0);
			}
		}
	}
	
	
	//method that returns true if all of the ball objects are true
	public boolean checkGameEnd() {
		for(int i=0; i<balls.length;++i) {
			if(balls[0].getXVel() == 0 && balls[1].getXVel() == 0
					&& balls[2].getXVel() == 0 && balls[3].getXVel() == 0) {
			
				return true;
			}
		}
		return false;
	}
	

}
	