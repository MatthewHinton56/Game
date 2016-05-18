
public class Magic {

	public static final String[] blackMagicSpell = new String[]{
			"RAIN",
			"MAGIC_MISSLE",
			"FIREBALL",
			"ZAP",
			"SNOWBALL",
			"PAIN",
			"FIREWALL",
			"LIGHTNING_STORM",
			"BLIZZARD",
			"DEATH",
			"IMMOLATE",
		 	"LIGHTNING_BOLT",
			"DEEP_FREEZE",
			"ARMAGGEDON"};
	public static final int[] blackMagicCost = new int[]{1,3,5,8,11,14,17,19,21,25, 30,33,36,40};
	public static final int[] whiteMagicCost = new int[]{1,3,5,8,11,14,17,19,21,25, 30,33,36,40};
	public static final String[] whiteMagicSpell = new String[]{
			"MEND",
			"DEFEND",
			"WEAK_HEAL",
			"QUICKEN",
			"STRENGTHEN",
			"CURE",
			"REVIVE",
			"DEFENSE_PLUS",
			"HEAL",
			"ENHANCE",
			"LIGHT_OF_HEAVENS",
			"HEAL_PLUS",
			"RESTORE",
			"FULL_CURE"
	};
	public static boolean isRevive(String m){return (m.equals("REVIVE")||m.equals("RESTORE"));}
	public static boolean nonCombat(String m)
	{
		return (!m.equals("DEFEND")&& !m.equals("QUICKEN")&& !m.equals("STRENGTHEN") && !m.equals("DEFENSE_PLUS") && 
				!m.equals("ENHANCE") && !m.equals("LIGHT_OF_HEAVENS"));
	}
	public static int getManaB(String s){for(int i = 0;i<14;i++)if(blackMagicSpell[i].equals(s))return blackMagicCost[i];return -1;}
	public static int getManaW(String s){for(int i = 0;i<14;i++)if(whiteMagicSpell[i].equals(s))return whiteMagicCost[i];return -1;}
	public static boolean isWhite(String magic )
	{
		for(String m:whiteMagicSpell)if(m.equals(magic))return true;
		return false;
	}
	public static boolean isBlack(String magic )
	{
		for(String m:blackMagicSpell)if(m.equals(magic))return true;
		return false;
	}
	public static int whiteHealAll(Hero h,PlayerGroup p,String m)
	{ int heal = 0;
		switch(m)
		{
		case "WEAK_HEAL": heal=h.getSpirit()*2;
		case "HEAL":heal=h.getSpirit()*5;
		case "FULL_HEAL":heal=h.getSpirit()*8;
		}
		for(int i = 0;i<4;i++)if(!p.getHero(i).checkDead())p.getHero(i).addHealth(heal);
		return heal;
	}
	public static int whiteSolo(Hero h, Hero t,String m)
	{
		int heal = 0;
		switch(m)
		{
		case "MEND": if(!t.checkDead())heal = h.getSpirit()*2;t.addHealth(heal);break;
		case "DEFEND": if(!t.checkDead())t.addDefense(h.getSpirit());break;
		case "QUICKEN": if(!t.checkDead())t.addSpeed(h.getSpirit());break;
		case "STRENGTHEN": if(!t.checkDead())t.addStrength(h.getSpirit());break;
		case "CURE": if(!t.checkDead())heal = h.getSpirit() * 5;t.addHealth(heal);break;
		case "REVIVE": t.addHealth(1);break;
		case "ENHANCE":if(!t.checkDead())t.addDefense(h.getSpirit()*2);if(!t.checkDead())t.addSpeed(h.getSpirit()*2);if(!t.checkDead())t.addStrength(h.getSpirit()*2);break;
		case "RESTORE":t.addHealth(h.getSpirit()*3);break;
		case "FULL_CURE":t.maxHP();heal = t.getMaxHP();t.addHealth(heal);break;
		}
		return heal;
	}
	public static int blackAttackAll(Hero h, EnemyGroup e,String m)
	{
		int damage = 1;
		switch(m)
		{
		case "FIREWALL": damage = h.getIntelligence()*3;break;
		case "RAIN": damage =  h.getIntelligence();;break;
		case "LIGHTNING_STORM": damage = h.getIntelligence() * 4; break;
		case "BLIZZARD": damage = h.getIntelligence()*5;break;
		case "ARMAGGEDON": damage = h.getIntelligence()*8;break;
		}
		for(int i = 0;i<e.size();i++)if(!e.get(i).checkDead())e.get(i).takeDamage(damage);
		return damage;
	}
	public static int blackAttackSolo(Hero h,Enemy e,String m)
	{	int damage = 0;
		switch(m)
		{
		case "MAGIC_MISSLE":damage=h.getIntelligence() * 3;
		case "FIREBALL": damage=h.getIntelligence() * 4;
		case "ZAP":damage=h.getIntelligence() * 5;
		case "SNOWBALL":damage=h.getIntelligence() * 6;
		case "PAIN":damage=h.getIntelligence() * 7;
		case "DEATH":damage=h.getIntelligence() * 8;
		case "IMMOLATE":damage=h.getIntelligence() * 9;
		case "LIGHTNING_BOLT":damage=h.getIntelligence() * 10;
		case "DEEP_FREEZE":damage=h.getIntelligence() * 11;
		}
		return damage;
	}
	public static int whiteAttackAll(Hero h,EnemyGroup e)
	{
		for(int i = 0;i<4;i++)if(!e.get(i).checkDead())e.get(i).takeDamage(h.getSpirit()*6);
		return h.getSpirit()*6;
	}
	public static boolean attacksAll(String magic)
	{
		return (magic.equals(blackMagicSpell[0]) || magic.equals(blackMagicSpell[6]) ||magic.equals(blackMagicSpell[7]) ||magic.equals(blackMagicSpell[8]) ||magic.equals(blackMagicSpell[13]) );
	}
	public static boolean whiteAll(String magic)
	{
		return (magic.equals(whiteMagicSpell[2]) || magic.equals(whiteMagicSpell[13])|| magic.equals(whiteMagicSpell[8])|| magic.equals(whiteMagicSpell[11]));
	}
	public static boolean whiteAttack(String magic){return magic.equals(whiteMagicSpell[10]);}
}