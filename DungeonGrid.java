/**
 * @(#)DungeonGrid.java
 *
 *
 * @author 
 * @version 1.00 2016/5/12
 */
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
public class DungeonGrid extends BoundedGrid<Actor> {
public final static int CUBEDEM = 7;
    public DungeonGrid(Actor[][] a,int x1,int x2,int y1,int y2) {
    	super(CUBEDEM,CUBEDEM);
    	int count1=0,count2=0;
    	for(int i = y1;i<=y2;i++){for(int k = x1;k<=x2;k++){if(a[i][k]!=null)put(new Location(count1,count2),a[i][k]);count2++;}count1++;count2=0;}
    }
    
    
}