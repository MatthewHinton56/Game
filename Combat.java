
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.gui.WorldFrame;

public class Combat {
private EnemyGroup e;
private PlayerGroup p;
private Inventory i;
private ArrayList<Units> unit;
private int place,level,x,y;
private Actor[][] floor;
public boolean over;
private DungeonWorld dW;
public CombatWorld cw;
	public Combat(EnemyGroup e,PlayerGroup p,Inventory io, DungeonWorld dW) {
		floor=dW.getConfig();
		x=dW.getX();
		y=dW.getY();
		level = dW.getLevel();
		this.dW=dW;
		over = false;
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
		cw.frame.setEnabled(true);
		if(unit.get(0) instanceof Hero){cw.getGrid().remove(BattleGrid.playerLoc[unit.get(place).id()]);cw.getGrid().put(BattleGrid.playerActiveLoc[unit.get(place).id()], new Actor());}
		if(unit.get(0) instanceof Enemy)execute();
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
			if(!move.equals("d"))cw.setMessage(((Hero)unit.get(place)).getName()+" deals "+damage+" damage to "+u.getName());
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
			for(int i = 0;i<p.size();i++){p.getHero(i).addXP(xpPerUnit);p.getHero(i).levelUpCheck();}
			over = true;
			new DungeonWorld(level,p,i,floor,x,y,dW.gm);
			cw.frame.setEnabled(false);
			cw.frame.dispose();
			}
			cw.getGrid().remove(BattleGrid.playerActiveLoc[unit.get(place).id()]);
			cw.getGrid().put(BattleGrid.playerLoc[unit.get(place).id()], new Actor());
			place++;
			if(place==unit.size())place=0;
			while(unit.get(place).checkDead()){place++;
			if(place==unit.size())place=0;}
			if(unit.get(place) instanceof Enemy && !unit.get(place).checkDead())execute();
			else {cw.getGrid().remove(BattleGrid.playerLoc[unit.get(place).id()]);cw.getGrid().put(BattleGrid.playerActiveLoc[unit.get(place).id()], new Actor());}
	}
	public void execute(String move,int index,String magic)
	{
			//for(int q = 0;q<unit.size();q++)System.out.println(unit.get(q).status());
			if(Magic.attacksAll(magic))
			{
				int damage = Magic.blackAttackAll((Hero)unit.get(place), e, magic);
				cw.setMessage(unit.get(place).getName()+" casts "+magic+" for "+damage+" damage to all enemies");
			}
			else if(Magic.whiteAll(magic))
			{
				int heal  = Magic.whiteHealAll((Hero)unit.get(place), p, magic);
				cw.setMessage(unit.get(place).getName()+" casts "+magic+" and heals all allies for "+heal);
			}
			else if(Magic.whiteAttack(magic))
			{
				int damage = Magic.whiteAttackAll((Hero)unit.get(place), e);
				cw.setMessage(unit.get(place).getName()+" casts "+magic+" for "+damage+" damage to all enemies");
			}
			else if(Magic.isWhite(magic))
			{
				int heal  = Magic.whiteSolo((Hero)unit.get(place), p.getHero(index), magic);
				cw.setMessage(unit.get(place).getName()+" casts "+magic+" on "+p.getHero(index).getName());	
			}
			else
			{
				int damage = Magic.blackAttackSolo((Hero)unit.get(place), e.get(index), magic);
				cw.setMessage(unit.get(place).getName()+" casts "+magic+" for "+damage+" damage to "+e.get(index).getName());
			}
			//int damage = unit.get(place).play(u, move);
			//if(!move.equals("d"))cw.setMessage(((Hero)unit.get(place)).getName()+" deals "+damage+" damage");
			unit.get(place).reset();
			for(int q = 0;q<e.size();q++)
			{
			if(e.get(q).checkDead())
			{
				cw.getGrid().remove(BattleGrid.enemyLoc[q]);
			}
			}
			if(e.checkDead())
			{
			cw.setMessage("You win");
			i.addGold(e.getGold());
			int xpPerUnit = e.getXP()/4;
			for(int i = 0;i<p.size();i++){p.getHero(i).addXP(xpPerUnit);p.getHero(i).levelUpCheck();p.getHero(i).heroReset();}
			over = true;
			new DungeonWorld(level,p,i,floor,x,y,dW.gm);
			cw.frame.setEnabled(false);
			cw.frame.dispose();
			}
			cw.remove(BattleGrid.playerActiveLoc[unit.get(place).id()]);
			cw.add(BattleGrid.playerLoc[unit.get(place).id()], new Actor());
			place++;
			if(place==6)place=0;
			while(unit.get(place).checkDead()){place++;
			if(place==unit.size())place=0;}
			if(unit.get(place) instanceof Enemy && !unit.get(place).checkDead())execute();
			else {cw.getGrid().remove(BattleGrid.playerLoc[unit.get(place).id()]);cw.getGrid().put(BattleGrid.playerActiveLoc[unit.get(place).id()], new Actor());}
	}
	private static final ArrayList<Integer> enemies = new ArrayList<Integer>();
	private static final ArrayList<String> moves = new ArrayList<String>();
	private static final ArrayList<String> textes = new ArrayList<String>();
	private static final ArrayList<Units> enemy = new ArrayList<Units>();
	private static final ArrayList<Units> targets = new ArrayList<Units>();
	public void execute()
	{	
		Units u;String move;
		//int index = unit.get(place).id();
		if(unit.get(place).getHP()<unit.get(place).getMaxHP()/2&& Math.random()>.5)move="defend";
		else move="attack";
		int i = ((int)(Math.random()*4));
		u = p.getHero(i);
		targets.add(u);
		moves.add(move);
		while(u.checkDead())
		{
			 i = ((int)(Math.random()*4));
			u = p.getHero(i);
		}
		enemy.add(unit.get(place));
		//int damage = unit.get(place).play(u, move);
		//String text = unit.get(place).getName()+" defended";
		//if(move.equals("attack"))text = ((Enemy)unit.get(place)).getName()+" deals "+damage+" damage to "+p.getHero(i).getName();
		//textes.add(text);
		int index = unit.get(place).id();
		enemies.add(index);
		System.out.println(unit.get(place).id());
		//cw.add(new Location(0,unit.get(place).id()),new DisplayController(cw,text,index));
		//System.out.println(((Enemy)unit.get(place)).getName()+" deals "+damage+" damage to"+p.getHero(i).getName());
		if(p.getHero(i).checkDead())cw.getGrid().remove(BattleGrid.playerLoc[i]);
		if(p.checkDead())
		{
			JOptionPane.showMessageDialog(null, "You died on floor "+dW.getLevel());
			cw.frame.dispose();		
		}
		else
		{
		place++;
		if(place==unit.size())place=0;
		while(unit.get(place).checkDead()){place++;
		if(place==unit.size())place=0;}
		if(unit.get(place) instanceof Enemy){execute();}
		else {cw.getGrid().remove(BattleGrid.playerLoc[unit.get(place).id()]);cw.getGrid().put(BattleGrid.playerActiveLoc[unit.get(place).id()], new Actor());}
		if(index == enemies.get(0))
		{
		System.out.println(enemies);
		cw.add(new Location(0,0),new DisplayController(cw,enemies,enemy,targets,moves));
		enemies.clear();
		moves.clear();
		textes.clear();
		enemy.clear();
		targets.clear();
		}
		}
		//System.out.println(text);
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
	public static int fibonnaci(int n)
	{
		if(n==1 || n == 2)return 1;
		return fibonnaci(n-1)+fibonnaci(n-2);
	}
	//public static void main(String args[])
	//{
	//	System.out.println(fibonnaci(10));
	//}
}
