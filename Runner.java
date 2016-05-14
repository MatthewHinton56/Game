
public class Runner {
	public static void main(String args[])
	{
		Hero unit1 = new Warrior("Matthew",0);
		//System.out.println(unit1.getName()+" "+unit1.getType());
		Hero unit2 = new Rogue("Matthew",1);
		//System.out.println(unit2.getName()+" "+unit2.getType());
		Hero unit3 = new Monk("Matthew",2);
		//System.out.println(unit3.getName()+" "+unit3.getType());
		Hero unit4 = new WhiteMage("Matthew",3);
		//System.out.println(unit4.getName()+" "+unit4.getType());
		PlayerGroup p = new PlayerGroup();
		p.addHero(unit1);
		p.addHero(unit2);
		p.addHero(unit3);
		p.addHero(unit4);
		Inventory inventory = new Inventory();
		//new DungeonWorld(1,p,inventory, new GameMaster());
	}
}
