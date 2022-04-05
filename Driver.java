//LaDarion Wells
import edu.princeton.cs.introcs.StdDraw;
import javax.swing.JOptionPane;
public class Driver {

	public static void main(String[] args) {
		FreezeTag play = new FreezeTag();
		
		StdDraw.enableDoubleBuffering();
		while(play.checkGameEnd()==false) {
			play.animate();
			if(StdDraw.isMousePressed()) {
				play.freeze(StdDraw.mouseX(), StdDraw.mouseY());
			
		}
			
		
	}	
		JOptionPane.showMessageDialog(null, "You Win!");
		
	}

}
