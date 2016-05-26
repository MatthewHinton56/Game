import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class DisplayController extends Actor {
	private CombatWorld cw;
	//private String text;
	private int count,place;
	private ArrayList<Integer> indexes;
	private ArrayList<String> textes,moves;
	private ArrayList<Units> enemies,targets;
	private boolean finished;
	public DisplayController(CombatWorld cw/*, ArrayList<String> text*/,ArrayList<Integer> indexes,ArrayList<Units> enemies,ArrayList<Units> targets,
			ArrayList<String> move)
	{
		place = 0;
		this.indexes = new ArrayList<Integer>();
		this.enemies = new ArrayList<Units>();
		this.targets = new ArrayList<Units>();
		this.textes = new ArrayList<String>();
		this.moves = new ArrayList<String>();
		this.cw=cw;
		//this.text = text;
		count = 0;
		for(int i:indexes)this.indexes.add(i);
		for(Units u:enemies)this.enemies.add(u);
		for(Units o:targets)this.targets.add(o);
		for(String s:move)this.moves.add(s);
		System.out.println(this.indexes+"\n"+this.enemies+"\n"+this.targets+"\n"+this.moves);
		finished = false;
		
	}
	public void act()
	{System.out.println(this.indexes);
		if(count == 0){{cw.getGrid().remove(BattleGrid.enemyLoc[indexes.get(place)]);cw.getGrid().put(BattleGrid.enemyActiveLoc[indexes.get(place)], new Actor());}}
		if(count == 1)
		{
			int damage = enemies.get(place).play(targets.get(place), moves.get(place));
			String text = enemies.get(place).getName()+" defended";
			if(moves.get(place).equals("attack"))text = ((Enemy)enemies.get(place)).getName()+" deals "+damage+" damage to "+targets.get(place).getName();	
			cw.setMessage(text);
		}
		if(count == 2){for(int q:indexes){cw.getGrid().remove(BattleGrid.enemyActiveLoc[indexes.get(place)]);cw.getGrid().put(BattleGrid.enemyLoc[indexes.get(place)], new Actor());}}
		
		
		if(count == 3 && place==indexes.size()-1){this.removeSelfFromGrid();finished=true;}
		else if(count==3){count=-1;place++;}
		count++;
	}
	public boolean isFinished()
	{
		return finished;
	}
	public int getCount()
	{
		return count;
	}
}
