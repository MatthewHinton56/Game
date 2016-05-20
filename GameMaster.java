import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
public class GameMaster {
private PlayerGroup p;
private Inventory i;
private int level;
private GameMaster gm;
private boolean complete;
	public static void main(String args[])
	{
		new GameMaster();
	}
	public GameMaster()
	{
		gm= this;
		i = new Inventory();
		p = new PlayerGroup();
		complete = true;
		level = 0;
		mainMenu();
//		i.addItem(new Chest(0,0,0, "test1"));
//		i.addItem(new Chest(0,0,0, "test2"));
//		i.addItem(new Pants(0,0,0, "test3"));
//		i.addItem(new Pants(0,0,0, "test4"));
//		i.addItem(new Gloves(0,0,0, "test5"));
//		i.addItem(new Gloves(0,0,0, "test6"));
//		i.addItem(new Helmet(0,0,0, "test7"));
//		i.addItem(new Helmet(0,0,0, "test8"));
//		i.addItem(new Weapon(0,"test9", 0));
//		i.addItem(new Weapon(0,"test10", 0));
	}
	public void Load() 
	{
		
		try{
		JFileChooser fileC = new JFileChooser();
		fileC.setCurrentDirectory(new File("GameMaster.java"));
		File file = null;
	if (fileC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
   	  {
   	  	file= fileC.getSelectedFile();
   	  	
   	  }
   	  Scanner in = new Scanner(file);
   	  while(in.hasNextLine())
   	  {
		level = Integer.parseInt(in.nextLine());
		for(int i = 0;i<4;i++)
		{
			Chest c = null;
			Pants p = null;
			Weapon w = null;
			Gloves g = null;
			Helmet h = null;
			ArrayList<String> spells = new ArrayList<String>();
			String type = in.nextLine();
			String name = in.nextLine();
			System.out.println(type);
			int hp = in.nextInt();
			int maxhp = in.nextInt();
			int mana = in.nextInt();
			int manafull = in.nextInt();
			int lvl = in.nextInt();
			int xp = in.nextInt();
			int strength = in.nextInt();
			int spirit = in.nextInt();
			int intelligence = in.nextInt();
			int speed = in.nextInt();
			int defense = in.nextInt();
			System.out.println(defense);
			in.nextLine();
			for(int q = 0;q<5;q++)
			{
				String temp = in.nextLine();
				System.out.println(temp);
				Scanner item = new Scanner(temp);
				String typeI = item.next();
				if(typeI!= null)
				{
					switch(q)
					{
				
					case 0:	c = new Chest(item.nextInt(),item.nextInt(),item.nextInt(),item.next());break;
					case 1:	g = new Gloves(item.nextInt(),item.nextInt(),item.nextInt(),item.next());break;
					case 2:	p = new Pants(item.nextInt(),item.nextInt(),item.nextInt(),item.next());break;
					case 3:	h = new Helmet(item.nextInt(),item.nextInt(),item.nextInt(),item.next());break;
					case 4:	w = new Weapon(item.nextInt(),item.next(),item.nextInt());break;
					}
				}
			}
			if(in.nextInt()>0)
			{
				Scanner item = new Scanner(in.nextLine());
				while(item.hasNext())spells.add(item.next());
			}
			switch(type)
			{
				case Warrior.type: this.p.addHero(new Warrior(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
				case Rogue.type: this.p.addHero(new Rogue(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
				case WhiteMage.type: this.p.addHero(new WhiteMage(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
				case Monk.type: this.p.addHero(new Monk(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
				case GrayMage.type: this.p.addHero(new GrayMage(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
				case BlackMage.type: this.p.addHero(new BlackMage(hp,maxhp,mana,manafull,lvl,xp,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,i,name));break;
			}
			System.out.print(this.p.getHero(i).save());
			System.out.println(in.nextLine());
		}
		this.i.addGold(Integer.parseInt(in.nextLine()));
		int count = in.nextInt();
		in.nextLine();
		for( int k = 0;k<count;k++)
		{
		Scanner item1 = new Scanner(in.nextLine());
		String type2 = item1.next();	
		switch(type2)
			{
				case Pants.type: this.i.addItem(new Pants(item1.nextInt(),item1.nextInt(),item1.nextInt(),item1.next()));break;
				case Gloves.type: this.i.addItem(new Gloves(item1.nextInt(),item1.nextInt(),item1.nextInt(),item1.next()));break;
				case Chest.type: this.i.addItem(new Chest(item1.nextInt(),item1.nextInt(),item1.nextInt(),item1.next()));break;
				case Helmet.type: this.i.addItem(new Helmet(item1.nextInt(),item1.nextInt(),item1.nextInt(),item1.next()));break;
				case Weapon.type: this.i.addItem(new Weapon(item1.nextInt(),item1.next(),item1.nextInt()));break;
			}	
		}
   	  }
   	  in.close();
	}
	catch(IOException e){}
	}
	private int count = 0;
	private JButton select;
	//private JFrame prompt;
	//private ButtonGroup radars;
	private void mainMenu()
	{	final JFrame frame = new JFrame("Main Menu");
final	JPanel panel = new JPanel();
final		JButton reSelect= new JButton("Play");
		 reSelect.setSize(100, 50);
		reSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				count=0;
				prompt();
				frame.dispose();
			}
			
			
		});
final		 JButton confirm= new JButton("High Scores");
		 confirm.setSize(100, 50);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		JButton load = new JButton("Load");
		load.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gm.Load();
				makeDungeonWorld();
				frame.dispose();
				
			}});
		panel.add(reSelect);panel.add(confirm);panel.add(load);
		frame.add(panel);
		frame.setSize(300, 75);
		frame.setVisible(true);
	}
	private void prompt()
	{
final		JFrame frame = new JFrame("Select Heros");
final		JPanel panel = new JPanel();
			
		
final		JTextField name = new JTextField();
final		JRadioButton rogue = new JRadioButton("Rogue");
final		JRadioButton warrior = new JRadioButton("Warrior");
		warrior.setSelected(true);
final		JRadioButton monk = new JRadioButton("Monk");
final		JRadioButton whiteMage = new JRadioButton("White Mage");
final		JRadioButton blackMage = new JRadioButton("Black Mage");
final		JRadioButton grayMage = new JRadioButton("Gray Mage");
final		ButtonGroup group = new ButtonGroup();
		 select= new JButton("Next");
		 select.setSize(100, 50);
		 name.setColumns(10);
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rogue.isSelected())p.addHero(new Rogue(name.getText(),count));
				if(warrior.isSelected())p.addHero(new Warrior(name.getText(),count));
				if(monk.isSelected())p.addHero(new Monk(name.getText(),count));
				if(whiteMage.isSelected())p.addHero(new WhiteMage(name.getText(),count));
				if(blackMage.isSelected())p.addHero(new BlackMage(name.getText(),count));
				if(grayMage.isSelected())p.addHero(new GrayMage(name.getText(),count));
				name.setText("");
				group.clearSelection();
				warrior.setSelected(true);
				count++;
				if(count==3)select.setText("Finish");
				if(count==4){confirm();frame.dispose();}
			}
			
			
		});
		JLabel label1 = new JLabel("Enter unit name ->");
		group.add(rogue);
		group.add(warrior);
		group.add(monk);
		group.add(blackMage);
		group.add(whiteMage);
		group.add(grayMage);
		panel.add(rogue);
		panel.add(warrior);
		panel.add(monk);
		panel.add(blackMage);
		panel.add(whiteMage);
		panel.add(grayMage);
		panel.add(label1);
		panel.add(name);
		panel.add(select);
		frame.add(panel);
		frame.setSize(500, 100);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}
	private void confirm()
	{
final		JFrame frame = new JFrame("Confirm");
final		JLabel hero1 = new JLabel(p.getHero(0).getName()+": "+p.getHero(0).getType()+" HP: "+p.getHero(0).getMaxHP());
final		JLabel hero2 = new JLabel(p.getHero(1).getName()+": "+p.getHero(1).getType()+" HP: "+p.getHero(1).getMaxHP());
final		JLabel hero3 = new JLabel(p.getHero(2).getName()+": "+p.getHero(2).getType()+" HP: "+p.getHero(2).getMaxHP());
final		JLabel hero4 = new JLabel(p.getHero(3).getName()+": "+p.getHero(3).getType()+" HP: "+p.getHero(3).getMaxHP());
final		JPanel panel = new JPanel();
final		GridLayout layout = new GridLayout(3,2);
		//layout.addLayoutComponent("Hero1", hero1);
		//layout.addLayoutComponent("Hero1a", hero1a);
		//layout.addLayoutComponent("Hero2", hero2);
		//layout.addLayoutComponent("Hero2a", hero2a);
		//layout.addLayoutComponent("Hero3", hero3);
		//layout.addLayoutComponent("Hero3a", hero3a);
		//layout.addLayoutComponent("Hero4", hero4);
		//layout.addLayoutComponent("Hero4a", hero4a);
		panel.setLayout(layout);
		panel.add(hero1);panel.add(hero2);panel.add(hero3);panel.add(hero4);
final		JButton reSelect= new JButton("ReSelect");
		 reSelect.setSize(100, 50);
		reSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				p.clear();
				prompt();
				frame.dispose();
			}
			
			
		});
		 JButton confirm= new JButton("Confirm");
		 confirm.setSize(100, 50);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				makeDungeonWorld();
				frame.dispose();
			}
			
			
		});
		panel.add(reSelect);panel.add(confirm);
		//layout.addLayoutComponent("reselect", reSelect);
		//layout.addLayoutComponent("confirm", confirm);
		frame.add(panel);
		frame.setSize(400, 150);
		frame.setVisible(true);
	}
	public int getLevel(){return level;}
	public void setLevel(int i){level=i;}
	public void makeDungeonWorld()
	{
		new DungeonWorld(1,p,i,this);
	}
}
