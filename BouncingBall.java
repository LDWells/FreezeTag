//LaDarion Wells
import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.util.Random;


public class BouncingBall {

	private double x;
	private double y;
	private double xVel;
	private double yVel;
	private Color color;
	private double radius = 0.05;


	public BouncingBall() {
		x = 0.5;
		y = 0.5;
		xVel = 0.01;
		yVel = 0.01;
		color = StdDraw.BLACK;
	}

	public BouncingBall(double x, double y, double xv, double yv) {
		this.x = x;
		this.y = y;
		this.xVel = xv;
		this.yVel = yv;
		color = StdDraw.BLACK;
	}
	
	public BouncingBall(Color color) {
		Random rng = new Random();
		x = rng.nextDouble();
		y = rng.nextDouble();
		xVel = rng.nextDouble() * 0.05;
		yVel = rng.nextDouble() * 0.05;
		this.color = color;	
	}

	//getter (accessor)
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getXVel() {
		return xVel;
	}

	public double getYVel() {
		return yVel;
	}

	//setters (mutators)
	public void setX(double newX) {
		if(newX < 0 || newX > 1) {
			System.out.println("Invalid position");
			return;
		}
		x = newX; 
	}

	public void setY(double newY) {
		if(newY < 0 || newY > 1) {
			System.out.println("Invalid position");
			return;
		}
		x = newY;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}

	public void setYVel(double v) {
		yVel = v;
	}

	public void setXVel(double v) {
		xVel = v;
	}

	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
	}

	public void update() {
		x += xVel;
		y += yVel;

		if(x < radius) {
			xVel *= -1;
			x = radius;
		}
		if(y < radius) {
			yVel *= -1;
			y = radius;
		}
		if( x > 1-radius) {
			xVel *= -1;
			x = 1-radius;
		}
		if(y > 1-radius) {
			yVel *= -1;
			y = 1-radius;
		}
	}
	//direction will be up, down, left or right
	public void update(String direction) {
		switch(direction) {
		case "up":
			yVel += 0.002;
			break;
		case "down":
			yVel -= 0.002;
			break;
		case "right":
			xVel += 0.002;
			break;
		case "left":
			xVel -= 0.002;
			break;
		}

		update(); //execute code above, then calls update() method
	}

	public boolean isClicked(double x, double y) {
		if((this.x - x)*(this.x-x) + (this.y-y)*(this.y-y) < radius*radius)
			return true;
		else return false;
	}
}

