import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		frame.add(makeMain());
		frame.setVisible(true);
	}
	public JPanel makeMain()
	{	
		JLabel hero1a = new JLabel(p.getHero(0).getName());
		JLabel hero1b = new JLabel(p.getHero(0).getHP()+"/"+p.getHero(0).getMaxHP());
		JLabel hero2a = new JLabel(p.getHero(1).getName());
		JLabel hero2b = new JLabel(p.getHero(1).getHP()+"/"+p.getHero(1).getMaxHP());
		JLabel hero3a = new JLabel(p.getHero(2).getName());
		JLabel hero3b = new JLabel(p.getHero(2).getHP()+"/"+p.getHero(2).getMaxHP());
		JLabel hero4a = new JLabel(p.getHero(3).getName());
		JLabel hero4b = new JLabel(p.getHero(3).getHP()+"/"+p.getHero(3).getMaxHP());
		JButton status = new JButton("Status");
		JButton inventory = new JButton("Inventory");
		status.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
			try
        	{
        	
        	}
        	catch(Exception i){}

            }
        });
        inventory.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
  			try
        	{
        	
        	}
        	catch(Exception i){}
   
            }
        });
		JPanel panel = new JPanel();
		panel.add(hero1a);
		panel.add(hero1b);
		panel.add(hero2a);
		panel.add(hero2b);
		panel.add(status);
		panel.add(hero3a);
		panel.add(hero3b);
		panel.add(hero4a);
		panel.add(hero4b);
		panel.add(inventory);
		return panel;
	}

}
