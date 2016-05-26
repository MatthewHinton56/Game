
import java.util.concurrent.TimeUnit;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class BattleGrid extends BoundedGrid<Actor> {
private static final int rows = 9;
private static final int cols = 10;
private Location locTemp;
private Combat c;
public static final Location[] enemyLoc = new Location[]{new Location(1,1),
		new Location(4,1),new Location(7,1),new Location(1,3),new Location(4,3),
		new Location(7,3),new Location(1,5),new Location(4,5),new Location(7,5)};
public static final Location[] playerLoc = new Location[]{new Location(1,8),
		new Location(3,8),new Location(5,8),new Location(7,8)};
public static final Location[] enemyStatLoc = new Location[]{new Location(2,1),
		new Location(5,1),new Location(8,1),new Location(2,3),new Location(5,3),
		new Location(8,3),new Location(2,5),new Location(5,5),new Location(8,5)};	
public static final Location[] playerStatLoc = new Location[]{new Location(2,8),
		new Location(4,8),new Location(6,8),new Location(8,8)};
public static final Location[] playerActiveLoc = new Location[]{new Location(1,7),
		new Location(3,7),new Location(5,7),new Location(7,7)};
public static final Location[] enemyActiveLoc = new Location[]{new Location(1,2),
		new Location(4,2),new Location(7,2),new Location(1,4),new Location(4,4),
		new Location(7,4),new Location(1,6),new Location(4,6),new Location(7,6)};
		
	public BattleGrid(Combat c) {
		super(rows, cols);
		for(int i = 0;i<c.getEnemies().size();i++){put(enemyLoc[i],new Actor());put(enemyStatLoc[i],new Stat(c.getEnemies().get(i)));}
		for(int q = 0;q<c.getPlayers().size();q++){put(playerLoc[q],new Actor());put(playerStatLoc[q],new Stat(c.getPlayers().getHero(q)));}
		this.c=c;
		//put(new Location(0,1),new Actor());
	}
	public Combat getCombat()
	{
		return c;
	}
	public void playerMove(Location loc,int i)
	{
		this.remove(playerLoc[i]);
		locTemp = new Location(loc.getRow(),loc.getCol()+1);
		this.put(locTemp, new Actor());
	}
	public void playerMoveBack(int i)
	{
		this.remove(locTemp);
		locTemp=null;
		this.put(playerLoc[i], new Actor());
	}
}
