
public class Pants extends Armor{
	public static final String type = "Pants";
    public Pants(int HP, int defense,int price, String name) {
    	super(HP,defense,price,name,type);

    }
    public Object clone()
   	{
   		return new Pants(getHP(),getDefense(),getPrice(),getName());
   	}
}
