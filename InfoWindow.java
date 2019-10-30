package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InfoWindow extends JFrame{
	
	public InfoWindow(String str){
		try {
			this.setLocation(300, 300);
			this.setTitle("Okno z informacjami o pracowniku");
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBackground(Color.white);
			panel.setPreferredSize(new Dimension(500,300));
			JTextArea ta = new JTextArea();
			ta.setLineWrap(true);
			ta.setFont(new Font("Arial", Font.PLAIN, 18));
			ta.setText(str);
			JScrollPane sp = new JScrollPane(ta);
			panel.add(sp);
			this.getContentPane().add(panel);
			this.pack();
			this.setVisible(true);
		}catch(Exception e){}
	}

}
