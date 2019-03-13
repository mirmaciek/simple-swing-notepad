import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class FileListener {
	
	JTextArea area;
	File plik = null;
	JMenuItem open;
	JMenuItem exit;
	JMenuItem save;
	JMenuItem saveAs;
	JFrame jf;
	
	public FileListener(JTextArea area, File plik, JMenuItem open, JMenuItem exit, JMenuItem save, JMenuItem saveAs, JFrame jf) {
		this.area = area;
		this.plik = plik;
		this.open = open;
		this.exit = exit;
		this.save = save;
		this.saveAs = saveAs;
		this.jf = jf;
		
		
	}
	
	
	public void doListener() {
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				
				if(e.getSource() == open) {
					if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
						plik = fc.getSelectedFile();
						jf.setTitle("Text Editor    " + plik.getAbsolutePath());
						
						try {
							Reader reader = new FileReader(plik);
							area.read(reader, null);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				if(e.getSource() == saveAs) {
					fc.setApproveButtonText("Save");
					if(fc.showSaveDialog(saveAs) == JFileChooser.APPROVE_OPTION) {
						//
						plik = fc.getSelectedFile();
						saveAsMethod();
						//to METODA
					}
				}
				if(e.getSource() == save) {
					if(plik == null) {
						if(fc.showSaveDialog(saveAs) == JFileChooser.APPROVE_OPTION) {
							plik = fc.getSelectedFile();
							saveAsMethod();
						}
					}if(plik != null){
						saveAsMethod();
					}
				}
				if(e.getSource() == exit)
					System.exit(0);
			}
			
		};
		
		open.addActionListener(listener);
		save.addActionListener(listener);
		saveAs.addActionListener(listener);
		exit.addActionListener(listener);
	}
	protected void saveAsMethod() {
		
		try {
			//BufferedWriter writer = new BufferedWriter(new FileWriter(plik, true));
			FileWriter writer = new FileWriter(plik);
			area.write(writer);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
