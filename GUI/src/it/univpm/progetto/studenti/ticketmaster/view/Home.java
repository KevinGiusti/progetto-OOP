package it.univpm.progetto.studenti.ticketmaster.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home {
	
	public Home() {
		
		JFrame home = new JFrame();
		
		ImageIcon icona = new ImageIcon("images/Logo The Last Of Events - Icon.png");
		ImageIcon titolo = new ImageIcon("images/THE LAST OF EVENTS.png");
		ImageIcon logo = new ImageIcon("images/Logo/Logo The Last Of Events.png");
		ImageIcon cursore = new ImageIcon("images/Cursore.png");
		
		JLabel iconaLbl = new JLabel(icona);
		JLabel titoloLbl = new JLabel(titolo);
		JLabel logoLbl = new JLabel(logo);
		
		JButton entra = new JButton("Entra");
		JButton exit = new JButton("Exit");
		
		home.setSize(900, 650);
		home.setTitle("The Last Of Events");
		home.setLayout(null);
		home.setLocationRelativeTo(null);
		home.setResizable(false);
		home.setUndecorated(true);
		home.getContentPane().setBackground(new Color(30, 30, 30));
		home.setIconImage(icona.getImage());
		home.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		home.setVisible(true);

		
		iconaLbl.setBounds(5, 5, 20, 20);
		home.add(iconaLbl);
		
		titoloLbl.setBounds(-50, 60, 1000, 100);
		home.add(titoloLbl);
		
		logoLbl.setBounds(295, 170, 300, 300);
		home.add(logoLbl);
		
		
		entra.setBounds(395, 510, 100, 40);
		entra.setFocusable(false);
		entra.setBackground(Color.BLACK);
		entra.setForeground(Color.WHITE);
		entra.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		entra.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		entra.setMargin(new Insets(20, 0, 0, 0));
		entra.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				entra.setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createLineBorder(Color.WHITE, 1), 
			            BorderFactory.createEmptyBorder(14, 0, 0, 0)));
		    }
		    public void mouseExited(MouseEvent evt) {
		    	entra.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	entra.setContentAreaFilled(false);
		    	entra.setBounds(398, 513, 94, 34);
		    	entra.setFont(new Font("Press Gothic", Font.PLAIN, 24));
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	entra.setContentAreaFilled(true);
		    	entra.setBounds(395, 510, 100, 40);
		    	entra.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  home.setVisible(false);
		    	  new Filtraggio();
		      }
		    });
		home.add(entra);
		
		exit.setBounds(770, 600, 100, 30);
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);
		exit.setBorder(null);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Arial", Font.ITALIC, 15));
		exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				exit.setFont(new Font("Arial", Font.ITALIC, 17));
		    }
		    public void mouseExited(MouseEvent evt) {
		    	exit.setFont(new Font("Arial", Font.ITALIC, 15));
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	exit.setForeground(Color.GRAY);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	exit.setForeground(Color.WHITE);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  System.exit(0);
		      }
		    });
		home.add(exit);
		
		
		home.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				cursore.getImage(),
				new Point(0,0),"Cursore biglietto"));
	
	}
	
}
