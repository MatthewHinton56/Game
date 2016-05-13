/**
 * @(#)DungeonWorld.java
 *
 *
 * @author 
 * @version 1.00 2016/5/12
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.gui.WorldFrame;
import info.gridworld.grid.Location;
public class DungeonWorld extends ActorWorld{
private  Actor[][] floor;	
int x,y;
private static final String type = "Dungeon";
    public DungeonWorld() {
    	floor = new Actor[19][19];
		for(int i = 0;i<19;i+=6)for(int q =0;q<19;q++){floor[i][q]=new Wall(q,i);floor[q][i]=new Wall(i,q);}
		setFocus(3,9);	
			x=3;y=9;
    	System.setProperty("info.gridworld.gui.selection", "hide"); // doesn’t show cell selection
		System.setProperty("info.gridworld.gui.tooltips", "hide"); // doesn’t show tooltips
		System.setProperty("info.gridworld.gui.frametitle", "Dungeon"); // set your own title
    	show();
    }
	public String getType(){return type;}
    public void setFocus(int x,int y)
    {
    	int x1 = x-3;
    	int x2 = x+3;
    	if(x1<0){x2-=x1;x1=0;}
    	if(x2>18){x1-=(x2-=18);x2=18;}
    	int y1 = y-3;
    	int y2 = y+3;
    	if(y1<0){y2-=y1;y1=0;}
    	if(y2>18){y1-=(y2-=18);y2=18;}
    	System.out.println (""+y1+y2+x1+x2);
    	this.setGrid(new DungeonGrid(floor,x1,x2,y1,y2));
    	
    }
     public boolean keyPressed(String description, Location loc)
    {
        if(description.equals("RIGHT")){x++;setFocus(x,y);}
        return true;
    }
}
    
