
public class Pants extends Armor{
	private String name;
    public Pants(int HP, int defense, String name) {
    	super(HP,defense);
    	this.name = name;
    }
    public String getName()
    {
    	return name;
    }
}
