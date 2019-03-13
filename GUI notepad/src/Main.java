import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Main {

	JTextArea area = new JTextArea();
	File plik = null;
	JFrame jf = new JFrame();

	public static void main(String[] args) {
		
		new Main();
	}
	public Main() {
		SwingUtilities.invokeLater(() -> createGUI());
	}
	public void createGUI() {
		
		jf.setPreferredSize(new Dimension(800,800));
		jf.setTitle("Text Editor");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar jmb = new JMenuBar();

		jmb.add(file());
		jmb.add(edit());
		jmb.add(options());
		
		
		jf.setJMenuBar(jmb);
		
		JScrollPane jsp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jf.add(jsp);
		jf.setVisible(true);
		jf.pack();
	}

	protected JMenu file() {
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke("control O"));
		open.setMnemonic('O');
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke("control S"));
		save.setMnemonic('S');
		JMenuItem saveAs = new JMenuItem("Save As");		
		saveAs.setAccelerator(KeyStroke.getKeyStroke("control shift A"));
		saveAs.setMnemonic('A');
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke("control shift E"));
		exit.setMnemonic('E');

		FileListener fl = new FileListener(area, plik, open, exit, save, saveAs, jf);
		fl.doListener();

		open.setBorder(BorderFactory.createRaisedBevelBorder());
		save.setBorder(BorderFactory.createRaisedBevelBorder());
		saveAs.setBorder(BorderFactory.createRaisedBevelBorder());
		exit.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JMenu file = new JMenu("File");
		
		JSeparator sep = new JSeparator();
		sep.setBorder(BorderFactory.createRaisedBevelBorder());
		sep.setBackground(Color.RED);
		
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(sep);
		file.add(exit);
		
		return file;
	}
	protected JMenu edit() {
		
		JMenu adresy = new JMenu("Adresy");
		adresy.setBorder(BorderFactory.createRaisedBevelBorder());
		JMenuItem praca = new JMenuItem("Praca");
		JMenuItem szkola = new JMenuItem("Szko³a");
		JMenuItem dom = new JMenuItem("Dom");
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == praca)
					area.replaceSelection("Z³ota 44");
				if(e.getSource() == szkola)
					area.replaceSelection("Koszykowa 86");
				if(e.getSource() == dom)
					area.replaceSelection("Worcella 3");
			}
		};
		
		praca.addActionListener(listener);
		szkola.addActionListener(listener);
		dom.addActionListener(listener);
		
		praca.setAccelerator(KeyStroke.getKeyStroke("control shift P"));
		praca.setMnemonic('P');
		szkola.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		szkola.setMnemonic('S');
		dom.setAccelerator(KeyStroke.getKeyStroke("control shift D"));
		dom.setMnemonic('D');
		adresy.add(praca);
		adresy.add(szkola);
		adresy.add(dom);
		
		JMenu edit = new JMenu("Edit");
		edit.add(adresy);
		return edit;
	}

	protected JMenu options() {
		
		JMenu back = new JMenu("Background");
		JMenu fore = new JMenu("Foreground");
		JMenu font = new JMenu("Font size");
		back.setBorder(BorderFactory.createRaisedBevelBorder());
		fore.setBorder(BorderFactory.createRaisedBevelBorder());
		font.setBorder(BorderFactory.createRaisedBevelBorder());
		
		MapaKolor mk = new MapaKolor(area, back, fore);
		mk.getMapa();
		
		Czcionka czcionka = new Czcionka(area, font);
		czcionka.getCzcionka();
		
		JMenu options = new JMenu("Options");
		
		options.add(back);
		options.add(fore);
		options.add(font);
		
		return options;
	}
}