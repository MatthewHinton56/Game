import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class Character extends Actor {
	public Character()
	{
		
	}
	public void Move(int y,int x)
	{
		moveTo(new Location(y,x));
	}
	public String toString(){return "p";}
}
