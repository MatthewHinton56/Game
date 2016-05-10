package info.game;

public class BlackMage extends Hero {
	private static final int startStrength = 1;
	private static final int startIntelligence = 4;
	private static final int startSpirit = 1;
	private static final int startSpeed = 2;
	private static final int startDefense = 2;
	private static final int startHealth = 20;
	public static final String type = "Black Mage";
		public BlackMage(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id);
		}
	public void levelUp()
	{
		int spirit = 0;
		int strength = 0;
		if(getLvl()%2==0)spirit++;
		else strength++;
		if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, strength, spirit, 1, 2,1);
		//Health,strength,spirit,speed,intelligence,defense
	}}
