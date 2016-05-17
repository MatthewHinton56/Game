import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShopGui extends JFrame {
	private static final Inventoriable[] items0 = new Inventoriable[]{StandardItems.loinclothC,
			StandardItems.loinclothH,
			StandardItems.loinclothP,
			StandardItems.loinclothG,
			StandardItems.woodenStick};
	
	public ShopGui(int level,Inventory i)
	{
		int o = level/9;
		DefaultListModel model1 = new DefaultListModel();
		JList list1 = new JList(model1);
		DefaultListModel model2 = new DefaultListModel();
		JList list2 = new JList(model2);
		JScrollPane pane1 = new JScrollPane(list1);
		JScrollPane pane2 = new JScrollPane(list2);
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		final JLabel goldAmount = new JLabel("Gold: "+i.getGold()+"");
		final ArrayList<Inventoriable> temp = new ArrayList<Inventoriable>();
		switch(o)
		{
		case 1: 
		for(Inventoriable io: items0){temp.add((Inventoriable)io.clone());model1.addElement(io);}
		break;
		}
		for(int q = 0;q<i.getInventorySize();q++)model2.addElement(i.getItem(q));
		JPanel panel = new JPanel(new GridLayout(4,2));
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}});;
		JButton buy = new JButton("Buy");
		buy.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				int index = list1.getSelectedIndex();
				if(temp.get(index).getPrice()<i.getGold())
				{
					i.removeGold(temp.get(index).getPrice());
					i.addItem(temp.get(index));
					temp.remove(index);
					model1.clear();
					for(Inventoriable io: temp){model1.addElement(io);}
					label1.setText("Purchase succsessful");
					goldAmount.setText("Gold: "+i.getGold()+"");
				}
				else
				{label1.setText("Insufficent funds");
				}
			}});
		JButton sell = new JButton("Sell");
		sell.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				int index = list2.getSelectedIndex();
				temp.add(i.getItem(index));
				i.removeItem(i.getItem(index));
					model2.clear();
					for(Inventoriable io: temp){model2.addElement(io);}
					label2.setText("Sold");
					goldAmount.setText("Gold: "+i.getGold()+"");
			}});
		panel.add(exit);panel.add(goldAmount);panel.add(buy);panel.add(sell);
		panel.add(pane1);panel.add(pane2);panel.add(label1);panel.add(label2);
		add(panel);
		setSize(600,200);
		setResizable(false);
		setVisible(true);
	}
}
