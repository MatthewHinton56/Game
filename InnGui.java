import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InnGui extends JFrame {
	public InnGui(int floor,Inventory i,PlayerGroup p)
	{
		setTitle("INN");
		final int o = floor/9;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		final JLabel goldAmount = new JLabel("Gold: "+i.getGold()+"");
		JButton sleep = new JButton("Sleep");
		final JLabel confirm = new JLabel();
		sleep.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int goldRequired = 50 * o;
				if(i.getGold()>goldRequired)
				{
					i.removeGold(goldRequired);
					for(int q = 0;q<4;q++){p.getHero(q).maxHP();p.getHero(q).mana=p.getHero(q).manafull;}
					goldAmount.setText("Gold: "+i.getGold()+"");
					confirm.setText("You awake refreshed");
				}
				else 
				{			
					confirm.setText("insufficent funds");
				}
			}});
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}});;
			panel.add(exit);panel.add(goldAmount);panel.add(sleep);panel.add(confirm);
			add(panel);
			setSize(300,200);
			setResizable(false);
			setVisible(true);
	}
}
