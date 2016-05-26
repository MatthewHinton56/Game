
import java.util.concurrent.TimeUnit;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.*;
import info.gridworld.world.World;
import info.gridworld.actor.Actor;
public class CombatWorld<Actor> extends ActorWorld {
private Combat c;
private String selection,magic;
private static final String type = "Combat";
private BattleGrid g;
    public CombatWorld(Combat c) {
    	super(new BattleGrid(c));	
    	g = (BattleGrid)this.getGrid();
    	this.c=c;
    	show();
    	selection="";
    	magic = "";
    	//this.add(new Location(0,0),(info.gridworld.actor.Actor) new info.gridworld.actor.Actor());
    }
    public boolean locationClicked(Location loc)
    {	//this.setMessage("Hello");
    		
    	int index = 0;
        for(int i = 0;i<c.getEnemies().size();i++)if(BattleGrid.enemyLoc[i].equals(loc))index=i;
        for(int q = 0;q<c.getPlayers().size();q++)if(BattleGrid.playerLoc[q].equals(loc))index=q;
        //if(c.getUnits().get(c.getPlace()) instanceof Hero)
       	int hero = ((Hero)c.getUnits().get(c.getPlace())).id();
        //if(selection.equals("a"))g.playerMove(loc,hero);
        if(selection.equals("a")||selection.equals("d"))c.execute(selection,index);
        else if(selection.equals("m"))c.execute(selection, index, magic);
        //if(selection.equals("a"))((BattleGrid)g).playerMoveBack(hero);
        return true;
    }
    public boolean keyPressed(String description,Location loc)
    {int index = 0;
    	switch(description)
    	{
    	case "1": if(g.get(g.enemyLoc[0])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,0);
    		else
    		c.execute(selection,0,magic);}break;
    	case "2": if(g.get(g.enemyLoc[1])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,1);
    		else
    		c.execute(selection,1,magic);}break;
    	case "3": if(g.get(g.enemyLoc[2])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,2);
    		else
    		c.execute(selection,2,magic);}break;
    	case "4": if(g.get(g.enemyLoc[3])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,3);
    		else
    		c.execute(selection,3,magic);}break;
    	case "5": if(g.get(g.enemyLoc[4])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,4);
    		else
    		c.execute(selection,4,magic);}break;
    	case "6": if(g.get(g.enemyLoc[5])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,5);
    		else
    		c.execute(selection,5,magic);}break;
    	case "7": if(g.get(g.enemyLoc[6])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,6);
    		else
    		c.execute(selection,6,magic);}break;
    	case "8": if(g.get(g.enemyLoc[7])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,7);
    		else
    		c.execute(selection,7,magic);}break;
    	case "9": if(g.get(g.enemyLoc[8])!=null){
    		if(!selection.equals("m"))
    		c.execute(selection,8);
    		else
    		c.execute(selection,8,magic);}break;
    	case "A": setSelectionA();break;
    	case "D": setSelectionD();break;
    	case "M": setSelectionM();new MagicGui((Hero)c.getUnits().get(c.getPlace()), this);break;
    	}
    	return true;
    }
    public void setSelectionA()
    {
    	selection="a";
    	setMessage("Attack");
    }
    public void setSelectionD()
    {
    	selection="d";
    	setMessage("Defend");
    }
    public void setSelectionM()
    {
    	selection = "m";
    	setMessage("Magic");		
    }
    
    public Combat getCombat()
    {
    	return c;
    }
    public void setMagic(String m){magic=m;}
    public String getType()
    {
    	return type;
    }
}