import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu {
	private PlayerGroup p;
	private Inventory i;
	private JFrame frame;
	public Menu(PlayerGroup p,Inventory i)
	{
		this.p=p;
		this.i=i;
		frame = new JFrame("Menu");
		frame.setSize(100, 200);
		makeMain();
		frame.setVisible(true);
	}
	private void setInventoryContents(ArrayList<Inventoriable> io, JTextArea tx)
	{
		tx.setText("");
		String temp = "";
		for(Inventoriable i: io)temp+=i+"\n";
		tx.setText(temp);
	}
	public void makeInventory()
	{
		frame.setTitle("Inventory");
		JPanel panel = new JPanel();
		JScrollPane scrPane = new JScrollPane(panel);
		GridLayout layout = new GridLayout(3,3);
		panel.setLayout(layout);
		ArrayList<Inventoriable> items = new ArrayList<Inventoriable>();
		for(int k = 0;k<i.getInventorySize();k++)
		{
		items.add(i.getItem(k));
		}
		JTextArea tx = new JTextArea();
		JButton sortName = new JButton("Sort by Name");
		sortName.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				items.clear();
				i.sortByName();
				for(int k = 0;k<i.getInventorySize();k++)
				{
				items.add(i.getItem(k));
				}
				setInventoryContents(items,tx);
			}});
		JButton sortPrice = new JButton("Sort by Price");
		sortPrice.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				items.clear();
				i.sortByPrice();
				for(int k = 0;k<i.getInventorySize();k++)
				{
				items.add(i.getItem(k));
				}
				setInventoryContents(items,tx);	
			}});
		JButton sortType = new JButton("Sort by Type");
		sortType.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				items.clear();
				i.sortByType();
				for(int k = 0;k<i.getInventorySize();k++)
				{
				items.add(i.getItem(k));
				}
				setInventoryContents(items,tx);		
			}});
		JButton ret = new JButton("Return");
		ret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				makeMain();		
			}});
		JScrollPane scroll = new JScrollPane(tx);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tx.setEditable(false);
		panel.add(ret);
		panel.add(new JLabel("Gold: "));
		panel.add(new JLabel(""+i.getGold()));
		panel.add(sortName);
		panel.add(sortPrice);
		panel.add(sortType);
		panel.add(scroll);
		setInventoryContents(items,tx);
		frame.add(panel);
		frame.setVisible(true);
	}
	public void makeStatus(int i)
	{ Hero h = p.getHero(i);
		frame.setTitle("Status");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(15,2);
		panel.setLayout(layout);
		JLabel hero1a = new JLabel("   "+h.getName());
		JLabel hero2a = new JLabel("Class: ");
		JLabel hero2b = new JLabel(h.getType());
		JLabel hero3a = new JLabel("Health: ");
		JLabel hero3b = new JLabel(h.getHP()+"/"+h.getMaxHP());
		JLabel hero4a = new JLabel("XP: ");
		JLabel hero4b = new JLabel(h.getXP()+"/"+(Math.pow(2,h.getLvl())*Hero.coefficent));
		JLabel hero5a = new JLabel("Strength: ");
		JLabel hero5b = new JLabel(""+h.getStrength());
		JLabel hero6a = new JLabel("Speed: ");
		JLabel hero6b = new JLabel(""+h.getSpeed());
		JLabel hero7a = new JLabel("Intelligence: ");
		JLabel hero7b = new JLabel(""+h.getIntelligence());
		JLabel hero8a = new JLabel("Spirit: ");
		JLabel hero8b = new JLabel(""+h.getSpirit());
		JLabel hero9a = new JLabel("Defense: ");
		JLabel hero9b = new JLabel(""+h.getDefense());
		JLabel hero10a = new JLabel("Chest: ");
		JLabel hero10b = new JLabel(h.getChest().getName());
		JLabel hero11a = new JLabel("Gloves: ");
		JLabel hero11b = new JLabel(h.getGloves().getName());
		JLabel hero12a = new JLabel("Pants: ");
		JLabel hero12b = new JLabel(h.getPants().getName());
		JLabel hero13a = new JLabel("Helmet: ");
		JLabel hero13b = new JLabel(h.getHelmet().getName());
		JLabel hero14a = new JLabel("Weapon: ");
		JLabel hero14b = new JLabel(h.getWeapon().getName());
		
		JButton ret = new JButton("Return");
		ret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				makeMain();		
			}});
		JButton back = new JButton("<-");
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int iO = i-1;
				if(iO==-1)iO=3;
				frame.remove(panel);
				makeStatus(iO);
			}});
	
	JButton forward = new JButton("->");
	forward.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			int iO = i+1;
			if(iO==4)iO=0;
			frame.remove(panel);
			makeStatus(iO);
		}});
	panel.add(ret);
	panel.add(hero1a);
	panel.add(hero2a);
	panel.add(hero2b);
	panel.add(hero3a);
	panel.add(hero3b);
	panel.add(hero3a);
	panel.add(hero3b);
	panel.add(hero4a);
	panel.add(hero4b);
	panel.add(hero5a);
	panel.add(hero5b);
	panel.add(hero6a);
	panel.add(hero6b);
	panel.add(hero7a);
	panel.add(hero7b);
	panel.add(hero8a);
	panel.add(hero8b);
	panel.add(hero9a);
	panel.add(hero9b);
	panel.add(hero10a);
	panel.add(hero10b);
	panel.add(hero11a);
	panel.add(hero11b);
	panel.add(hero12a);
	panel.add(hero12b);
	panel.add(hero13a);
	panel.add(hero13b);
	panel.add(hero14a);
	panel.add(hero14b);
	panel.add(back);
	panel.add(forward);
	frame.add(panel);
	frame.setVisible(true);
}
	public void makeMain()
	{	frame.setTitle("Main Menu");
		JPanel panel = new JPanel();
		JLabel hero1a = new JLabel(p.getHero(0).getName());
		JLabel hero1b = new JLabel(p.getHero(0).getHP()+"/"+p.getHero(0).getMaxHP()+" HP");
		JLabel hero1c = new JLabel(p.getHero(0).getXP()+"/"+(Math.pow(2,p.getHero(0).getLvl())*Hero.coefficent)+" XP");
		JLabel hero1d = new JLabel(p.getHero(0).getLvl()+" lvl");
		JLabel hero2a = new JLabel(p.getHero(1).getName());
		JLabel hero2b = new JLabel(p.getHero(1).getHP()+"/"+p.getHero(1).getMaxHP()+" HP");
		JLabel hero2c = new JLabel(p.getHero(1).getXP()+"/"+(Math.pow(2,p.getHero(1).getLvl())*Hero.coefficent)+" XP");
		JLabel hero2d = new JLabel(p.getHero(1).getLvl()+" lvl");
		JLabel hero3a = new JLabel(p.getHero(2).getName());
		JLabel hero3b = new JLabel(p.getHero(2).getHP()+"/"+p.getHero(2).getMaxHP()+" HP");
		JLabel hero3c = new JLabel(p.getHero(2).getXP()+"/"+(Math.pow(2,p.getHero(2).getLvl())*Hero.coefficent)+" XP");
		JLabel hero3d = new JLabel(p.getHero(2).getLvl()+" lvl");
		JLabel hero4a = new JLabel(p.getHero(3).getName());
		JLabel hero4b = new JLabel(p.getHero(3).getHP()+"/"+p.getHero(3).getMaxHP()+" HP");
		JLabel hero4c = new JLabel(p.getHero(3).getXP()+"/"+(Math.pow(2,p.getHero(3).getLvl())*Hero.coefficent)+" XP");
		JLabel hero4d = new JLabel(p.getHero(3).getLvl()+" lvl");
		JButton status = new JButton("Status");
		JButton inventory = new JButton("Inventory");
		JButton equip = new JButton("Equip");
		JButton magic = new JButton("Magic");
		status.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	frame.remove(panel);
			makeStatus(0);
			
            }
        });
        inventory.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            frame.remove(panel);	
  			makeInventory();
            }
        });
		GridLayout layout = new GridLayout(5,4);
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}});
		file.add(save);
		menu.add(file);
		frame.setJMenuBar(menu);
		panel.setLayout(layout);
		panel.add(hero1a);
		panel.add(hero1b);
		panel.add(hero1c);
		panel.add(hero1d);
		panel.add(hero2a);
		panel.add(hero2b);
		panel.add(hero2c);
		panel.add(hero2d);
		panel.add(hero3a);
		panel.add(hero3b);
		panel.add(hero3c);
		panel.add(hero3d);
		panel.add(hero4a);
		panel.add(hero4b);
		panel.add(hero4c);
		panel.add(hero4d);
		panel.add(status);
		panel.add(inventory);
		panel.add(equip);
		panel.add(magic);
		frame.setSize(800, 600);
		frame.add(panel);
		frame.setVisible(true);
	}

}
