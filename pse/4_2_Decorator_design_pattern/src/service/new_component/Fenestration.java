package service.new_component;

abstract class Fenestration {
	private int height;
	private int width;
	
	public Fenestration(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {return this.height;}
	public int getWidth() { return this.width;}
}
