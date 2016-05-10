package info.game;
import java.util.ArrayList;

public class PlayerGroup {
private ArrayList<Hero> heroes;
	public PlayerGroup() {
		heroes = new ArrayList<Hero>();
	}
	public void addHero(Hero h)
	{
		heroes.add(h);
	}
	public boolean checkDead()
	{
		boolean dead = true;
		for(Hero h:heroes)if(!h.checkDead())dead=false;
		return dead;
	}
	public Hero getHero(int i)
	{
		return heroes.get(i);
	}
	public int size(){return heroes.size();}
	public Hero search(int id)
	{
		for(Hero h:heroes)if(h.id()==id)return h;
		return null;
	}
}
