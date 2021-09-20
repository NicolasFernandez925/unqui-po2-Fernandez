package tp3_introAJava1.point;

public class Point {
	
	private float x;
	private float y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
	public void moverPunto(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Point sumarPunto(Point punto) {
		this.x += punto.getX();
		this.y += punto.getY();	
		return this;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
}
