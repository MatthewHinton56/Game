import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class BattleGrid extends BoundedGrid<Actor> {
private static final int rows = 9;
private static final int cols = 10;
private static final Location[] enemyLoc = new Location[]{new Location(1,1),
		new Location(4,1),new Location(7,1),new Location(1,3),new Location(4,3),
		new Location(7,3),new Location(1,5),new Location(4,5),new Location(7,5)};
private static final Location[] playerLoc = new Location[]{new Location(1,8),
		new Location(3,8),new Location(5,8),new Location(7,8)};
	public BattleGrid(PlayerGroup p,EnemyGroup e) {
		super(rows, cols);
		for(int i = 0;i<e.size();i++)put(enemyLoc[i],new Actor());
		for(int q = 0;q<p.size();q++)put(playerLoc[q],new Actor());
	}

}
