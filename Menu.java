import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	public void makeMagic(int o)
	{
		frame.setTitle("Magic");
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		ArrayList<String>magicList = p.getHero(o).spellList;
		DefaultListModel model1 = new DefaultListModel();
		DefaultListModel model2 = new DefaultListModel();
		panel.setLayout(new GridLayout(3,2));
		JList list1 = new JList(model1);
		JList list2 = new JList(model2);
		JLabel label1 = new JLabel("Mana: "+p.getHero(o).mana);
		JScrollPane scroll1 = new JScrollPane(list1);
		JScrollPane scroll2 = new JScrollPane(list2);
		JButton ret = new JButton("Return");
		for(String s:p.getHero(o).spellList)
		{
			if(Magic.isBlack(s))model1.addElement(s);
			else model2.addElement(s);
		}
		ret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			frame.remove(panel);frame.remove(panel2);	
			makeMain();
				
			}});
		JButton selectBlack = new JButton("Cast");
		selectBlack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list1.getSelectedIndex()>-1)
				{
					if(p.getHero(o).mana>Magic.getManaB((String)list1.getSelectedValue()))
					{
					label1.setText("N/A");
					}
				}
				
			}});
		JButton selectWhite = new JButton("Cast");
		selectWhite.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list2.getSelectedIndex()>-1)
				{
					
					if(Magic.nonCombat((String)list2.getSelectedValue()))
					{
					if(Magic.whiteAll((String)list2.getSelectedValue())) 
					{
						if(p.getHero(o).mana>Magic.getManaW((String)list2.getSelectedValue()))	{p.getHero(o).mana-=Magic.getManaW((String)list2.getSelectedValue());if(p.getHero(o).mana<0)p.getHero(o).mana=0;
						Magic.whiteHealAll(p.getHero(o), p, (String)list2.getSelectedValue());}	
						else label1.setText("insufficent");
					}
					else 
					{
						JOptionPane prompt = new JOptionPane();
						int i = Integer.parseInt(prompt.showInputDialog("Choose from 1 to 4"))-1;
						if(p.getHero(o).mana>Magic.getManaW((String)list2.getSelectedValue()))	{p.getHero(o).mana-=Magic.getManaW((String)list2.getSelectedValue());if(p.getHero(o).mana<0)p.getHero(o).mana=0;
						Magic.whiteSolo(p.getHero(o), p.getHero(i), (String)list2.getSelectedValue());}	
						else label1.setText("insufficent");
					}
					}
					else label1.setText("N/A");
				}
				
			}});
		JButton back = new JButton("<-");
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int iO = o-1;
				if(iO==-1)iO=3;
				frame.remove(panel);
				frame.remove(panel2);
				makeMagic(iO);
			}});
	
	JButton forward = new JButton("->");
	forward.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			int iO = o+1;
			if(iO==4)iO=0;
			frame.remove(panel);
			frame.remove(panel2);
			makeMagic(iO);
		}});
		frame.setSize(400,300);
		frame.setResizable(false);
		panel.add(ret);panel.add(label1);panel2.add(scroll1);panel2.add(scroll2);panel.add(selectBlack);panel.add(selectWhite);panel.add(back);panel.add(forward);
		frame.setLayout(new BorderLayout());
		
		frame.add(panel,BorderLayout.NORTH);frame.add(panel2,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	public void makeEquip(int o)
	{	JLabel label1a = new JLabel("Chest:");
		JLabel label2a = new JLabel("Pants:");
		JLabel label3a = new JLabel("Gloves:");
		JLabel label4a = new JLabel("Helmet:");
		JLabel label5a = new JLabel("Weapon");
		
		JLabel label1 = new JLabel(p.getHero(o).getChest().getStat());
		JLabel label2 = new JLabel(p.getHero(o).getPants().getStat());
		JLabel label3 = new JLabel(p.getHero(o).getGloves().getStat());
		JLabel label4 = new JLabel(p.getHero(o).getHelmet().getStat());
		JLabel label5 = new JLabel(p.getHero(o).getWeapon().getStat());
		frame.setTitle("Equip");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,4));
		DefaultListModel model1 = new DefaultListModel();
		JList list1 = new JList(model1);
		DefaultListModel model2 = new DefaultListModel();
		JList list2 = new JList(model2);
		DefaultListModel model3 = new DefaultListModel();
		JList list3 = new JList(model3);
		DefaultListModel model4 = new DefaultListModel();
		JList list4 = new JList(model4);
		DefaultListModel model5 = new DefaultListModel();
		JList list5 = new JList(model5);
		ArrayList<Inventoriable> chests = new ArrayList<Inventoriable>();
		chests = i.getItemByType("Chest");
		ArrayList<Inventoriable> pantss = new ArrayList<Inventoriable>();
		pantss = i.getItemByType("Pants");
		ArrayList<Inventoriable> glovess = new ArrayList<Inventoriable>();
		glovess = i.getItemByType("Gloves");
		ArrayList<Inventoriable> helmets = new ArrayList<Inventoriable>();
		helmets = i.getItemByType("Helmet");
		ArrayList<Inventoriable> weapons = new ArrayList<Inventoriable>();
		weapons = i.getItemByType("Weapon");
		JButton unEquip1 = new JButton("unequip");
		unEquip1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Chest c = p.getHero(o).equipChest(null);
				if(c!=null)i.addItem(c);
				ArrayList<Inventoriable>chests = i.getItemByType("Chest");
				model1.clear();
				for(Inventoriable c1:chests)model1.addElement(c1.getStat());
				if(p.getHero(o).getChest()!=null)label1.setText(p.getHero(o).getChest().getStat());
				else label1.setText("Nothing");
			}});
		JButton unEquip2 = new JButton("unequip");
		unEquip2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Pants c = p.getHero(o).equipPants(null);
				if(c!=null)i.addItem(c);
				ArrayList<Inventoriable>pants = i.getItemByType("Pants");
				model2.clear();
				for(Inventoriable c1:pants)model2.addElement(c1.getStat());
				if(p.getHero(o).getPants()!=null)label2.setText(p.getHero(o).getPants().getStat());
				else label2.setText("Nothing");
			}});
		JButton unEquip3 = new JButton("unequip");
		unEquip3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Gloves c = p.getHero(o).equipGloves(null);
				if(c!=null)i.addItem(c);
				ArrayList<Inventoriable>gloves = i.getItemByType("Gloves");
				model3.clear();
				for(Inventoriable c1:gloves)model3.addElement(c1.getStat());
				if(p.getHero(o).getGloves()!=null)label3.setText(p.getHero(o).getGloves().getStat());
				else label3.setText("Nothing");
			}});
		JButton unEquip4 = new JButton("unequip");
		unEquip4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Helmet c = p.getHero(o).equipHelmet(null);
				if(c!=null)i.addItem(c);
				ArrayList<Inventoriable>helmets = i.getItemByType("Helmet");
				model4.clear();
				for(Inventoriable c1:helmets)model4.addElement(c1.getStat());
				if(p.getHero(o).getHelmet()!=null)label4.setText(p.getHero(o).getHelmet().getStat());
				else label4.setText("Nothing");
			}});
		JButton unEquip5 = new JButton("unequip");
		unEquip5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Weapon c = p.getHero(o).equipWeapon(null);
				if(c!=null)i.addItem(c);
				ArrayList<Inventoriable>gloves = i.getItemByType("Weapon");
				model5.clear();
				for(Inventoriable c1:gloves)model5.addElement(c1.getStat());
				if(p.getHero(o).getWeapon()!=null)label5.setText(p.getHero(o).getWeapon().getStat());
				else label5.setText("Nothing");
			}});
		JButton ret = new JButton("return");
		ret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				makeMain();		
			}});
		JButton back = new JButton("<-");
		JButton forward = new JButton("->");
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int iO = o-1;
				if(iO==-1)iO=3;
				frame.remove(panel);
				makeEquip(iO);
			}});
	
	forward.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			int iO = o+1;
			if(iO==4)iO=0;
			frame.remove(panel);
			makeEquip(iO);
		}});
		JButton equip1 = new JButton("Equip");
		equip1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list1.getSelectedIndex();
				ArrayList<Inventoriable> chests = new ArrayList<Inventoriable>();
				chests = i.getItemByType("Chest");
				Chest c = p.getHero(o).equipChest((Chest)chests.get(index));
				i.removeItem(chests.get(index));if(c!=null)i.addItem(c);
				chests = i.getItemByType("Chest");
				model1.clear();
				for(Inventoriable c1:chests)model1.addElement(c1.getStat());
				if(p.getHero(o).getChest()!=null)label1.setText(p.getHero(o).getChest().getStat());
				else label1.setText("Nothing");
			}});
		JButton equip2 = new JButton("Equip");
		equip2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list2.getSelectedIndex();
				ArrayList<Inventoriable> pants = new ArrayList<Inventoriable>();
				pants = i.getItemByType("Pants");
				Pants c = p.getHero(o).equipPants((Pants)pants.get(index));
				i.removeItem(pants.get(index));if(c!=null)i.addItem(c);
				pants = i.getItemByType("Pants");
				model2.clear();
				for(Inventoriable c1:pants)model2.addElement(c1.getStat());
				if(p.getHero(o).getPants()!=null)label2.setText(p.getHero(o).getPants().getStat());
				else label2.setText("Nothing");
			}});
		JButton equip3 = new JButton("Equip");
		equip3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list3.getSelectedIndex();
				ArrayList<Inventoriable> glovess = new ArrayList<Inventoriable>();
				glovess = i.getItemByType("Gloves");
				Gloves c = p.getHero(o).equipGloves((Gloves)glovess.get(index));
				i.removeItem(glovess.get(index));if(c!=null)i.addItem(c);
				glovess = i.getItemByType("Gloves");
				model3.clear();
				for(Inventoriable c1:glovess)model3.addElement(c1.getStat());
				if(p.getHero(o).getGloves()!=null)label3.setText(p.getHero(o).getGloves().getStat());
				else label3.setText("Nothing");
			}});
		JButton equip4 = new JButton("Equip");
		equip4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list4.getSelectedIndex();
				ArrayList<Inventoriable> helmets = new ArrayList<Inventoriable>();
				helmets = i.getItemByType("Helmet");
				Helmet c = p.getHero(o).equipHelmet((Helmet)helmets.get(index));
				i.removeItem(helmets.get(index));if(c!=null)i.addItem(c);
				helmets = i.getItemByType("Helmet");
				model4.clear();
				for(Inventoriable c1:helmets)model4.addElement(c1.getStat());
				if(p.getHero(o).getHelmet()!=null)label4.setText(p.getHero(o).getHelmet().getStat());
				else label4.setText("Nothing");
			}});
		JButton equip5 = new JButton("Equip");
		equip5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list5.getSelectedIndex();
				ArrayList<Inventoriable> weapons = new ArrayList<Inventoriable>();
				weapons = i.getItemByType("Weapon");
				Weapon c = p.getHero(o).equipWeapon((Weapon)weapons.get(index));
				i.removeItem(weapons.get(index));if(c!=null)i.addItem(c);
				weapons = i.getItemByType("Weapon");
				model5.clear();
				for(Inventoriable c1:weapons)model5.addElement(c1.getStat());
				if(p.getHero(o).getWeapon()!=null)label5.setText(p.getHero(o).getWeapon().getStat());
				else label5.setText("Nothing");
			}});
		for(Inventoriable c:chests)model1.addElement(c.getStat());
		for(Inventoriable p:pantss)model2.addElement(p.getStat());
		for(Inventoriable g:glovess)model3.addElement(g.getStat());
		for(Inventoriable h:helmets)model4.addElement(h.getStat());
		for(Inventoriable w:weapons)model5.addElement(w.getStat());
		JScrollPane scroll1 = new JScrollPane(list1);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll2 = new JScrollPane(list2);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll3 = new JScrollPane(list3);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll4 = new JScrollPane(list4);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll5 = new JScrollPane(list5);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(label1a);panel.add(label1);panel.add(unEquip1);panel.add(scroll1);panel.add(equip1);
		panel.add(label2a);panel.add(label2);panel.add(unEquip2);panel.add(scroll2);panel.add(equip2);
		panel.add(label3a);panel.add(label3);panel.add(unEquip3);panel.add(scroll3);panel.add(equip3);
		panel.add(label4a);panel.add(label4);panel.add(unEquip4);panel.add(scroll4);panel.add(equip4);
		panel.add(label5a);panel.add(label5);panel.add(unEquip5);panel.add(scroll5);panel.add(equip5);
		panel.add(back);panel.add(new JLabel());panel.add(ret);panel.add(new JLabel());panel.add(forward);
		frame.add(panel);
		frame.setVisible(true);
	}
	public void makeInventory()
	{
		frame.setTitle("Inventory");
		//frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(panel,BorderLayout.NORTH);
		JTextArea tx = new JTextArea();
		tx.setVisible(true);
		tx.setEditable(false);
		//JScrollPane scrPane = new JScrollPane(tx);
		GridLayout layout = new GridLayout(2,3);
		panel.setLayout(layout);
		ArrayList<Inventoriable> items = new ArrayList<Inventoriable>();
		for(int k = 0;k<i.getInventorySize();k++)
		{
		items.add(i.getItem(k));
		}
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
				frame.remove(panel2);
				makeMain();		
			}});
		JScrollPane scroll = new JScrollPane(tx);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(ret);
		panel.add(new JLabel("Gold: "));
		panel.add(new JLabel(""+i.getGold()));
		panel.add(sortName);
		panel.add(sortPrice);
		panel.add(sortType);
		setInventoryContents(items,tx);
		//frame.add(panel,BorderLayout.NORTH);
		panel2.add(scroll,BorderLayout.CENTER);
		frame.add(panel2);
		frame.setVisible(true);
	}
	public void makeStatus(int i)
	{ Hero h = p.getHero(i);
		frame.setTitle("Status");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(16,2);
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
		JLabel hero15a = new JLabel("Mana: ");
		JLabel hero15b = new JLabel(h.mana+"/"+h.manafull);
		
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
	panel.add(hero15a);
	panel.add(hero15b);
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
		magic.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				 makeMagic(0);
				
			}});
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
        equip.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            frame.remove(panel);	
  			makeEquip(0);
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
