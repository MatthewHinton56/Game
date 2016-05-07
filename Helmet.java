
public class Helmet extends Armor{
	private String name;
    public Helmet(int HP, int defense, String name) {
    	super(HP,defense);
    	this.name = name;
    }
    public String getName()
    {
    	return name;
    }
}
