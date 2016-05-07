
public class Warrior extends Hero {
private static final int startStrength = 3;
private static final int startIntelligence = 1;
private static final int startSpirit = 1;
private static final int startSpeed = 2;
private static final int startDefense = 2;
private static final int startHealth = 25;
public static final String type = "Warrior";
	public Warrior(String name) {
		super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth);
	}
public void levelUp()
{
	int spirit = 0;
	int intelligence = 0;
	if(getLvl()%2==0)spirit++;
	else intelligence++;
	if(getXP()>getLvl()*coefficent)super.levelUP(5, 2, spirit, 1, intelligence,1);
}
}
