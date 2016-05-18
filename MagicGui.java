import java.awt.BorderLayout;
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

public class MagicGui extends JFrame{
private JList list1,list2;
private DefaultListModel model1,model2;
private JLabel label1;
private JButton ret,selectBlack,selectWhite;
private JPanel panel,panel2;
private JScrollPane scroll1,scroll2;
private ArrayList<String> magicList;
private Hero h;
private CombatWorld c;
		public MagicGui(Hero hi,CombatWorld ci)
		{
			
			h=hi;
			c=ci;
			setTitle("Magic");
			panel = new JPanel();
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(1,2));
			magicList = h.spellList;
			model1 = new DefaultListModel();
			model2 = new DefaultListModel();
			panel.setLayout(new GridLayout(2,2));
			list1 = new JList(model1);
			list2 = new JList(model2);
			label1 = new JLabel("Mana: "+h.mana);
			scroll1 = new JScrollPane(list1);
			scroll2 = new JScrollPane(list2);
			ret = new JButton("Return");
			for(String s:h.spellList)
			{
				if(Magic.isBlack(s))model1.addElement(s);
				else model2.addElement(s);
			}
			ret.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
				dispose();
					
				}});
			selectBlack = new JButton("Cast");
			selectBlack.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(list1.getSelectedIndex()>-1)
					{
						if(h.mana>Magic.getManaB((String)list1.getSelectedValue()))
						{
						h.mana-=Magic.getManaB((String)list1.getSelectedValue());if(h.mana<0)h.mana=0;	
						c.setMagic((String)list1.getSelectedValue());
						dispose();
						}
						else
						{
							label1.setText("insufficent");
						}
					}
					
				}});
			selectWhite = new JButton("Cast");
			selectWhite.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(list2.getSelectedIndex()>-1)
					{
						if(h.mana>Magic.getManaW((String)list2.getSelectedValue()))
						{
						h.mana-=Magic.getManaW((String)list2.getSelectedValue());if(h.mana<0)h.mana=0;	
						c.setMagic((String)list2.getSelectedValue());
						dispose();
						}
						else
						{
							label1.setText("insufficent");
						}
					}
					
				}});
			setSize(400,300);
			setResizable(false);
			panel.add(ret);panel.add(label1);panel2.add(scroll1);panel2.add(scroll2);panel.add(selectBlack);panel.add(selectWhite);
			setLayout(new BorderLayout());
			
			add(panel,BorderLayout.NORTH);add(panel2,BorderLayout.CENTER);
			setVisible(true);
		}
}
