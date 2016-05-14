import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
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
		
	}
	private int count = 0;
	private JButton select;
	//private JFrame prompt;
	//private ButtonGroup radars;
	private void mainMenu()
	{	JFrame frame = new JFrame("Main Menu");
	JPanel panel = new JPanel();
		JButton reSelect= new JButton("Play");
		 reSelect.setSize(100, 50);
		reSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				count=0;
				prompt();
				frame.dispose();
			}
			
			
		});
		 JButton confirm= new JButton("High Scores");
		 confirm.setSize(100, 50);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		panel.add(reSelect);panel.add(confirm);
		frame.add(panel);
		frame.setSize(300, 75);
		frame.setVisible(true);
	}
	private void prompt()
	{
		JFrame frame = new JFrame("Select Heros");
		JPanel panel = new JPanel();
			
		
		JTextField name = new JTextField();
		JRadioButton rogue = new JRadioButton("Rogue");
		JRadioButton warrior = new JRadioButton("Warrior");
		JRadioButton monk = new JRadioButton("Monk");
		JRadioButton whiteMage = new JRadioButton("White Mage");
		JRadioButton blackMage = new JRadioButton("Black Mage");
		JRadioButton grayMage = new JRadioButton("Gray Mage");
		ButtonGroup group = new ButtonGroup();
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
				count++;
				if(count==3)select.setText("Finish");
				if(count==4){confirm();frame.dispose();}
			}
			
			
		});
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
		panel.add(name);
		panel.add(select);
		frame.add(panel);
		frame.setSize(500, 100);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}
	private void confirm()
	{
		JFrame frame = new JFrame("Confirm");
		JLabel hero1 = new JLabel(p.getHero(0).getName()+": "+p.getHero(0).getType()+" "+p.getHero(0).getMaxHP());
		JLabel hero2 = new JLabel(p.getHero(1).getName()+": "+p.getHero(1).getType()+" "+p.getHero(1).getMaxHP());
		JLabel hero3 = new JLabel(p.getHero(2).getName()+": "+p.getHero(2).getType()+" "+p.getHero(2).getMaxHP());
		JLabel hero4 = new JLabel(p.getHero(3).getName()+": "+p.getHero(3).getType()+" "+p.getHero(3).getMaxHP());
		JPanel panel = new JPanel();
		panel.add(hero1);panel.add(hero2);panel.add(hero3);panel.add(hero4);
		JButton reSelect= new JButton("ReSelect");
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
				new DungeonWorld(level,p,i,gm);
				frame.dispose();
			}
			
			
		});
		panel.add(reSelect);panel.add(confirm);
		frame.add(panel);
		frame.setSize(150, 200);
		frame.setVisible(true);
	}
	public int getLevel(){return level;}
	public void setLevel(int i){level=i;}
}
