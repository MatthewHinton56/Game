

public class Warrior extends Hero {
private static final int startStrength = 4;
private static final int startIntelligence = 1;
private static final int startSpirit = 1;
private static final int startSpeed = 2;
private static final int startDefense = 3;
private static final int startHealth = 25;
public static final String type = "Warrior";
	public Warrior(String name,int id) {
		super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id);
	}
public void levelUp()
{
	int spirit = 0;
	int intelligence = 0;
	if(getLvl()%2==0)spirit++;
	else intelligence++;
	if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, 2, spirit, 1, intelligence,1);
	//Health,strength,spirit,speed,intelligence,defense
}
}
