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
import javax.swing.JTextArea;

public class Responso {
	
	public Responso() {
		
		JFrame responso = new JFrame();
		
		ImageIcon icona = new ImageIcon("images/Logo The Last Of Events - Icon.png");
		ImageIcon titoloSmall = new ImageIcon("images/THE LAST OF EVENTS - small.png");
		ImageIcon cursore = new ImageIcon("images/Cursore.png");
		
		JLabel separatoreTitolo = new JLabel("|");
		JLabel iconaLbl = new JLabel(icona);
		JLabel titoloSmallLbl = new JLabel(titoloSmall);
		
		JTextArea risultato = new JTextArea();
		
		JButton nuovaRicerca = new JButton("Nuova ricerca");
		JButton homeReturn = new JButton("Home");
		JButton exit = new JButton("Exit");
		
		
		responso.setSize(1280, 720);
		responso.setTitle("The Last Of Events");
		responso.setLayout(null);
		responso.setLocationRelativeTo(null);
		responso.setResizable(false);
		responso.setUndecorated(true);
		responso.getContentPane().setBackground(new Color(30, 30, 30));
		responso.setIconImage(icona.getImage());
		responso.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		responso.setVisible(true);
		
		
		iconaLbl.setBounds(5, 5, 20, 20);
		responso.add(iconaLbl);
		
		separatoreTitolo.setBounds(35, 5, 3, 18);
		separatoreTitolo.setForeground(Color.WHITE);
		responso.add(separatoreTitolo);
		
		titoloSmallLbl.setBounds(50, 5, 135, 20);
		responso.add(titoloSmallLbl);
		
		
		risultato.setBounds(60, 50, 1150, 550);
		risultato.setBackground(new Color(50, 50, 50));
		responso.add(risultato);
		
		
		
		nuovaRicerca.setBounds(550, 620, 180, 40);
		nuovaRicerca.setFocusable(false);
		nuovaRicerca.setBackground(Color.BLACK);
		nuovaRicerca.setForeground(Color.WHITE);
		nuovaRicerca.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		nuovaRicerca.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		nuovaRicerca.setMargin(new Insets(20, 0, 0, 0));
		nuovaRicerca.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				nuovaRicerca.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createLineBorder(Color.WHITE, 1), 
		            BorderFactory.createEmptyBorder(14, 0, 0, 0)));
			}
			public void mouseExited(MouseEvent evt) {
				nuovaRicerca.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
			}
			public void mousePressed(MouseEvent mEP) {
				nuovaRicerca.setContentAreaFilled(false);
				nuovaRicerca.setBounds(553, 623, 174, 34);
				nuovaRicerca.setFont(new Font("Press Gothic", Font.PLAIN, 24));
			}
			public void mouseReleased(MouseEvent mEP) {
				nuovaRicerca.setContentAreaFilled(true);
				nuovaRicerca.setBounds(550, 620, 180, 40);
				nuovaRicerca.setFont(new Font("Press Gothic", Font.PLAIN, 30));
			}
			public void mouseClicked(MouseEvent me) {
				responso.setVisible(false);
				new Filtraggio();
			}
	    	});
		responso.add(nuovaRicerca);
	

		homeReturn.setBounds(30, 670, 100, 30);
		homeReturn.setFocusable(false);
		homeReturn.setContentAreaFilled(false);
		homeReturn.setBorder(null);
		homeReturn.setForeground(Color.WHITE);
		homeReturn.setFont(new Font("Arial", Font.ITALIC, 15));
		homeReturn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				homeReturn.setFont(new Font("Arial", Font.ITALIC, 17));
		    }
		    public void mouseExited(MouseEvent evt) {
		    	homeReturn.setFont(new Font("Arial", Font.ITALIC, 15));
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	homeReturn.setForeground(Color.GRAY);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	homeReturn.setForeground(Color.WHITE);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  responso.setVisible(false);
		    	  new Home();
		      }
		    });
		responso.add(homeReturn);
		
		
		exit.setBounds(1150, 670, 100, 30);
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
		responso.add(exit);
		
		
		responso.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				cursore.getImage(),
				new Point(0,0),"Cursore biglietto"));
		
	}
	
}
