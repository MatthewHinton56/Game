
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.gui.*;
public class Charecter extends Actor{
private int x,y;
private PlayerGroup p;
private Inventory i;
	public Charecter(int x,int y,PlayerGroup p,Inventory i) {
		this.p=p;
		this.x=x;
		this.y=y;
		this.i=i;
	}

	@Override
	public void moveTo(Location loc) {
	Grid<Actor> g = getGrid();
	if(!(g.get(loc) instanceof Wall))
	{
		if(g.get(loc) instanceof EnemySpawn)
		{
			Combat com = new Combat(((EnemySpawn)g.get(loc)).getEnemy(),p,i);
			//if(com.execute())super.moveTo(loc);
		}
		super.moveTo(loc);
		
	}
	}
	

}
