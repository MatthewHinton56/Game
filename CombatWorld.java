
import java.util.concurrent.TimeUnit;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.*;
import info.gridworld.world.World;
public class CombatWorld<Actor> extends ActorWorld {
private Combat c;
private String selection;
private static final String type = "Combat";
private BattleGrid g;
    public CombatWorld(Combat c) {
    	super(new BattleGrid(c));	
    	g = (BattleGrid)this.getGrid();
    	this.c=c;
    	show();
    	selection="";
    }
    public boolean locationClicked(Location loc)
    {	//this.setMessage("Hello");
    		
    	int index = 0;
        for(int i = 0;i<c.getEnemies().size();i++)if(BattleGrid.enemyLoc[i].equals(loc))index=i;
        //if(c.getUnits().get(c.getPlace()) instanceof Hero)
       	int hero = ((Hero)c.getUnits().get(c.getPlace())).id();
        //if(selection.equals("a"))g.playerMove(loc,hero);
        c.execute(selection,index);
        //if(selection.equals("a"))((BattleGrid)g).playerMoveBack(hero);
        return true;
    }
    public boolean keyPressed(String description,Location loc)
    {int index = 0;
    	switch(description)
    	{
    	case "1": if(g.get(g.enemyLoc[0])!=null)c.execute(selection,0);break;
    	case "2": if(g.get(g.enemyLoc[1])!=null)c.execute(selection,1);break;
    	case "3": if(g.get(g.enemyLoc[2])!=null)c.execute(selection,2);break;
    	case "4": if(g.get(g.enemyLoc[3])!=null)c.execute(selection,3);break;
    	case "5": if(g.get(g.enemyLoc[4])!=null)c.execute(selection,4);break;
    	case "6": if(g.get(g.enemyLoc[5])!=null)c.execute(selection,5);break;
    	case "7": if(g.get(g.enemyLoc[6])!=null)c.execute(selection,6);break;
    	case "8": if(g.get(g.enemyLoc[7])!=null)c.execute(selection,7);break;
    	case "9": if(g.get(g.enemyLoc[8])!=null)c.execute(selection,8);break;
    	case "A": setSelectionA();break;
    	case "D": setSelectionD();break;
    	}
    	return true;
    }
    public void setSelectionA()
    {
    	selection="a";
    	setMessage("a");
    }
    public void setSelectionD()
    {
    	selection="d";
    	setMessage("d");
    }
    public Combat getCombat()
    {
    	return c;
    }
    public String getType()
    {
    	return type;
    }
}