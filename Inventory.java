
import java.util.*;
public class Inventory {
private ArrayList<Inventoriable> inventory;
private int gold;
	public Inventory() {
		inventory =  new ArrayList<Inventoriable>();
		gold = 0;
	}
	public String save()
	{
		String temp = ""+gold+"\n";
		temp+=inventory.size();
		for(Inventoriable i:inventory){temp+="\n"+i.save();}
		return temp;
	}
	public void addGold(int gold)
	{
		this.gold+=gold;
	}
	public void removeGold(int amount)
	{
		gold-=amount;
	}
	public boolean checkAmount(int gold)
	{
		return (gold<=this.gold);
	}
	public int getGold(){return gold;}
	public void addItem(Inventoriable i)
	{
		inventory.add(i);
	}
	public void removeItem(Inventoriable i)
	{
		 inventory.remove(i);
	}
	public Inventoriable getItem(String name,String type)
	{
		for(Inventoriable i: inventory)if(i.getName().equals(name)&&i.getType().equals(type))return i;
		return null;
	}
	public Inventoriable getItem(int i)
	{
		return inventory.get(i);
	}
	public ArrayList<Inventoriable> getItemByType(String type)
	{	ArrayList<Inventoriable> temp = new ArrayList<Inventoriable>();
	for(Inventoriable i: inventory)
	{
		if(i.getType().equals(type))temp.add(i);
	}
	return temp;	
	}
	public ArrayList<Inventoriable> getItemByName(String name)
	{	ArrayList<Inventoriable> temp = new ArrayList<Inventoriable>();
	for(Inventoriable i: inventory)
	{
		if(i.getName().equals(name))temp.add(i);
	}
	return temp;	
	}
	public  void sortByName()
	{
		for(int k = inventory.size()-1;k>0;k--)
		{
			int i = 0;
			for(int q = 1;q<=k;q++)
			{
				if(inventory.get(i).getName().compareTo(inventory.get(q).getName())<0)i=q;
			}
			Inventoriable temp = inventory.get(k);
			inventory.set(k,inventory.get(i));
			inventory.set(i, temp);
		}
	}
	public  void sortByType()
	{
		for(int k = inventory.size()-1;k>0;k--)
		{
			int i = 0;
			for(int q = 1;q<=k;q++)
			{
				if(inventory.get(i).getType().compareTo(inventory.get(q).getType())<0)i=q;
			}
			Inventoriable temp = inventory.get(k);
			inventory.set(k,inventory.get(i));
			inventory.set(i, temp);
		}
	}
	public  void sortByPrice()
	{
		for(int k = inventory.size()-1;k>0;k--)
		{
			int i = 0;
			for(int q = 1;q<=k;q++)
			{
				if(inventory.get(i).getPrice()<inventory.get(q).getPrice())i=q;
			}
			Inventoriable temp = inventory.get(k);
			inventory.set(k,inventory.get(i));
			inventory.set(i, temp);
		}
	}
	public String toString()
	{
		String ret = "";
		ret+="Gold: "+gold+"\n";
		for(Inventoriable i: inventory)ret+=i.getStat();
		return ret;
	}
	public int getInventorySize(){return inventory.size();}
}
