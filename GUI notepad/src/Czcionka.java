import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Czcionka {

	JTextArea area;
	JMenu font;
	
	public Czcionka(JTextArea area, JMenu font) {
		super();
		this.area = area;
		this.font = font;
	}
		
	public void getCzcionka() {
		
		ArrayList<JMenuItem> czcionki = new ArrayList<>();
		
		for(int i=8; i<=32; i++)
			czcionki.add(new JMenuItem(i + " pts"));
		
		for(JMenuItem czcionka : czcionki) {
			
			czcionka.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					area.setFont(new Font("Dialog", Font.PLAIN, czcionki.indexOf(czcionka)));
				
				}
			});
			
		}
		for(int i =0; i < czcionki.size(); i++)
			font.add(czcionki.get(i));
	}



}
