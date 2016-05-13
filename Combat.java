
import java.util.ArrayList;
import java.util.Scanner;

public class Combat {
private EnemyGroup e;
private PlayerGroup p;
private Inventory i;
private ArrayList<Units> unit;
private int place;
private CombatWorld cw;
	public Combat(EnemyGroup e,PlayerGroup p,Inventory io) {
		this.e=e;
		this.p=p;
		this.i=io;
		unit =  new ArrayList<Units>();
		for(int i = 0;i<4;i++)unit.add(p.getHero(i));
		for(int j = 0;j<e.size();j++)unit.add(e.getEnemy(j));
		for(int k = unit.size()-1;k>0;k--)
		{
			int i = 0;
			for(int q = 1;q<=k;q++)
			{
				if(unit.get(i).getSpeed()>unit.get(q).getSpeed())i=q;
			}
			Units temp = unit.get(k);
			unit.set(k,unit.get(i));
			unit.set(i, temp);
		}
		for(Units u: unit)System.out.println(u.getSpeed());
		place = 0;
		cw = new CombatWorld(this);
		
		
	}
	public void execute(String move,int index)
	{
	
			//for(int q = 0;q<unit.size();q++)System.out.println(unit.get(q).status());
			Units u=null;
				switch (move)
				{
				case "a":move = "attack";
				break;
				case "d":move = "defend";	
				break;
				}
				u=e.get(index);
			int damage = unit.get(place).play(u, move);
			if(!move.equals("d"))cw.setMessage(((Hero)unit.get(place)).getName()+" deals "+damage+" damage");
			unit.get(place).reset();
			if(u.checkDead())
			{
				cw.getGrid().remove(BattleGrid.enemyLoc[index]);
			}
			if(e.checkDead())
			{
			cw.setMessage("You win");
			i.addGold(e.getGold());
			int xpPerUnit = e.getXP()/4;
			for(int i = 0;i<p.size();i++)p.getHero(i).addXP(xpPerUnit);
			
			}
			place++;
			if(place==6)place=0;
			if(unit.get(place) instanceof Enemy && !unit.get(place).checkDead())execute();
	}
	public void execute()
	{
		Units u;String move;
		if(unit.get(place).getHP()<unit.get(place).getMaxHP()/2&& Math.random()>.5)move="defend";
		else move="attack";
		int i = ((int)(Math.random()*4));
		u = p.getHero(i);
		int damage = unit.get(place).play(u, move);
		if(move.equals("attack"))cw.setMessage(((Enemy)unit.get(place)).getName()+" deals "+damage+" damage");
		place++;
		if(place==6)place=0;
		if(unit.get(place) instanceof Enemy)execute();
	}
	public PlayerGroup getPlayers() {
		return p;
	}
	public EnemyGroup getEnemies() {
		return e;
	}
	public int getPlace()
	{
		return place;
	}
	public ArrayList<Units> getUnits()
	{
		return unit;
	}
}
