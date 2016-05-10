package info.game;
import java.util.ArrayList;

public class EnemyGroup {
private ArrayList<Enemy> enemies;
	public EnemyGroup() {
		enemies = new ArrayList<Enemy>();
	}
	public EnemyGroup(Enemy[] e){
		enemies = new ArrayList<Enemy>();
		addEnemies(e);
	}
	public boolean checkDead()
	{
		boolean dead = true;
		for(Enemy e:enemies)if(!e.checkDead())dead=false;
		return dead;
	}
	public int getGold()
	{
	int gold = 0;
	for(Enemy e: enemies)gold+=e.getGold();
	return gold;
	}
	public int getXP()
	{
	int XP = 0;
	for(Enemy e: enemies)XP+=e.getXP();
	return XP;
	}
	public void addEnemy(Enemy e){enemies.add(e);}
	private void addEnemies(Enemy[] es)
	{
		for(Enemy e:es)enemies.add((Enemy)e.clone());
	}
	public Enemy getEnemy(int i){return enemies.get(i);}
	public Object clone()
	{
		EnemyGroup eG = new EnemyGroup();
		for(Enemy e:enemies)eG.addEnemy((Enemy)e.clone());
		return eG;
	}
	public int size(){return enemies.size();}
	public Enemy get(int i){return enemies.get(i);}
}
