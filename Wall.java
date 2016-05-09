import info.gridworld.actor.*;
public class Wall extends Actor {
int x,y;
	public Wall(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
