import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MapaKolor {

	
	ArrayList<JMenuItem> arl = new ArrayList<>();
	int size;
	JTextArea area;
	JMenu back,fore;
	public MapaKolor(JTextArea area, JMenu back, JMenu fore) {
		this.area = area;
		this.fore = fore;
		this.back = back;
	}
	
	public void getMapa() {
		
		HashMap<String, MyColor> kolory = new HashMap<>();
		kolory.put("Green", new MyColor(Color.GREEN));
		kolory.put("Yellow", new MyColor(Color.YELLOW));
		kolory.put("Blue", new MyColor(Color.BLUE));
		kolory.put("Cyan", new MyColor(Color.CYAN));
		kolory.put("Grey", new MyColor(Color.GRAY));
		kolory.put("White", new MyColor(Color.WHITE));
		kolory.put("Black", new MyColor(Color.BLACK));
		
		size = kolory.size();
		
		for(Map.Entry<String, MyColor> map : kolory.entrySet()) {
			
			String key = map.getKey();
			Color val =(map.getValue()).getColor();
			
			JMenuItem jmiKolorF = new JMenuItem(key.toString(), kolory.get(key));
			JMenuItem jmiKolorB= new JMenuItem(key.toString(), kolory.get(key));
			
			ActionListener al = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == jmiKolorF)
						area.setForeground(val);
					if(e.getSource() == jmiKolorB)
						area.setBackground(val);
				}
			};
			jmiKolorF.addActionListener(al);
			jmiKolorB.addActionListener(al);

			fore.add(jmiKolorF);
			back.add(jmiKolorB);

		}
		
	}

	public int getMapLength() {
		return size;
	}

}
