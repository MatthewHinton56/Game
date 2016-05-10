package info.game;
import java.util.concurrent.TimeUnit;

import info.gridworld.actor.ActorWorld.*;
import info.gridworld.grid.*;
import info.gridworld.world.World;
public class CombatWorld<Actor> extends World {
private Combat c;
private String selection;
private static final String type = "Combat";
private BattleGrid g;
    public CombatWorld(Combat c) {
    	super(new BattleGrid(c),type);	
    	g = (BattleGrid)this.getGrid();
    	this.c=c;
    	show();
    	selection="";
    }
    public boolean locationClicked(Location loc)
    {	this.setMessage("Hello");	
    	int index = 0;
        for(int i = 0;i<c.getEnemies().size();i++)if(BattleGrid.enemyLoc[i].equals(loc))index=i;
        //if(c.getUnits().get(c.getPlace()) instanceof Hero)
       	int hero = ((Hero)c.getUnits().get(c.getPlace())).id();
        if(selection.equals("a"))g.playerMove(loc,hero);
        c.execute(selection,index);
        if(selection.equals("a"))((BattleGrid)g).playerMoveBack(hero);
        return true;
    }
    public void setSelection(String s)
    {
    	selection=s;
    }
    public Combat getCombat()
    {
    	return c;
    }
    
}