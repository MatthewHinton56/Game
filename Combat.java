import java.util.ArrayList;
import java.util.Scanner;

public class Combat {
private EnemyGroup e;
private PlayerGroup p;
private Inventory i;
private ArrayList<Units> unit;
private int place;
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
	}
	public boolean execute()
	{
		Scanner in = new Scanner(System.in);
		while(!e.checkDead() && !p.checkDead())
		{
			for(int q = 0;q<unit.size();q++)System.out.println(unit.get(q).status());
			String move = "";
			Units u=null;
			if(unit.get(place) instanceof Hero)
			{
				System.out.print("Attack or Defend:a or d: ");
				switch (in.nextLine())
				{
				case "a":move = "attack";
				break;
				case "d":move = "defend";	
				break;
				}
				System.out.print("Select enemy: ");
				int test = in.nextInt();
				for(int i = 0;i<unit.size();i++)if(unit.get(i)instanceof Enemy && unit.get(i).id()==test)u=unit.get(i);
				in.nextLine();
				unit.get(place).play(u, move);
			}
			else
			{
				if(unit.get(place).getHP()<unit.get(place).getMaxHP()/2&& Math.random()>.5)move="defend";
				else move="attack";
				int i = ((int)(Math.random()*4));
				u = p.getHero(i);
				unit.get(place).play(u, move);
			}
			unit.get(place).reset();
			place++;
			if(place==6)place=0;
		}
		if(e.checkDead())
			{
			System.out.println("You win");
			i.addGold(e.getGold());
			int xpPerUnit = e.getXP()/4;
			for(int i = 0;i<p.size();i++)p.getHero(i).addXP(xpPerUnit);
			return true;
			}
			return false;
	}

}
