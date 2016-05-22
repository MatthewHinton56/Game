import info.gridworld.actor.Actor;

public class DisplayController extends Actor {
	private CombatWorld cw;
	private String text;
	private int count,index;
	private boolean finished;
	public DisplayController(CombatWorld cw, String text,int index)
	{
		this.cw=cw;
		this.text = text;
		count = 0;
		this.index = index;
		finished = false;
		
	}
	public void act()
	{
		if(count == 0){cw.getGrid().remove(BattleGrid.enemyLoc[index]);cw.getGrid().put(BattleGrid.enemyActiveLoc[index], new Actor());}
		if(count == 1)cw.setMessage(text);
		if(count == 3){cw.getGrid().remove(BattleGrid.enemyActiveLoc[index]);cw.getGrid().put(BattleGrid.enemyLoc[index], new Actor());}
		if(count == 4){this.removeSelfFromGrid();finished=true;}
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
