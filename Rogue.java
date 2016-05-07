
public class Rogue extends Hero {
	private static final int startStrength = 2;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 1;
	private static final int startSpeed = 4;
	private static final int startDefense = 1;
	private static final int startHealth = 20;
	public static final String type = "Rogue";
		public Rogue(String name) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth);
		}
	public void levelUp()
	{
		int spirit = 0;
		int intelligence = 0;
		if(getLvl()%2==1)spirit++;
		else intelligence++;
		if(getXP()>getLvl()*coefficent)super.levelUP(5, 1, spirit, 2, intelligence,1);
	}

	}


