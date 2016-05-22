import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class DisplayController extends Actor {
	private CombatWorld cw;
	private String text;
	private int count;
	private ArrayList<Integer> indexes;
	private boolean finished;
	public DisplayController(CombatWorld cw, String text,ArrayList<Integer> indexes)
	{
		this.indexes = new ArrayList<Integer>();
		this.cw=cw;
		this.text = text;
		count = 0;
		for(int i:indexes)this.indexes.add(i);
		System.out.println(this.indexes);
		finished = false;
		
	}
	public void act()
	{System.out.println(this.indexes);
		if(count == 0){for(int i:indexes){cw.getGrid().remove(BattleGrid.enemyLoc[i]);cw.getGrid().put(BattleGrid.enemyActiveLoc[i], new Actor());}}
		if(count == 1)cw.setMessage(text);
		if(count == 2){for(int q:indexes){cw.getGrid().remove(BattleGrid.enemyActiveLoc[q]);cw.getGrid().put(BattleGrid.enemyLoc[q], new Actor());}}
		if(count == 3){this.removeSelfFromGrid();finished=true;}
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
