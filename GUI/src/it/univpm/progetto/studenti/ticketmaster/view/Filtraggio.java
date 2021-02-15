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

public class Filtraggio {

	public Filtraggio() {

		JFrame filtraggio = new JFrame();

		ImageIcon icona = new ImageIcon("images/Logo The Last Of Events - Icon.png");
		ImageIcon titoloSmall = new ImageIcon("images/THE LAST OF EVENTS - small.png");
		ImageIcon cursore = new ImageIcon("images/Cursore.png");
		
		JLabel slashData;
		JLabel separatoreBig;
		JLabel separatoreDate = new JLabel();
		JLabel separatoreTitolo = new JLabel("|");
		JLabel iconaLbl = new JLabel(icona);
		JLabel titoloSmallLbl = new JLabel(titoloSmall);
		JLabel stati = new JLabel("STATI");
		JLabel generi = new JLabel("GENERI");
		JLabel periodo = new JLabel("PERIODO");
		JLabel dataInit = new JLabel("Data iniziale:");
		JLabel dataFin = new JLabel("Data finale:");
		
		JButton plus = new JButton("+");
		JButton cerca = new JButton("Cerca");
		JButton svuota = new JButton("Svuota");
		JButton homeReturn = new JButton("Home");
		JButton exit = new JButton("Exit");

		
		filtraggio.setSize(1280, 720);
		filtraggio.setTitle("The Last Of Events");
		filtraggio.setLayout(null);
		filtraggio.setLocationRelativeTo(null);
		filtraggio.setResizable(false);
		filtraggio.setUndecorated(true);
		filtraggio.getContentPane().setBackground(new Color(30, 30, 30));
		filtraggio.setIconImage(icona.getImage());
		filtraggio.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		filtraggio.setVisible(true);
		
		
		iconaLbl.setBounds(5, 5, 20, 20);
		filtraggio.add(iconaLbl);
		
		separatoreTitolo.setBounds(35, 5, 3, 18);
		separatoreTitolo.setForeground(Color.WHITE);
		filtraggio.add(separatoreTitolo);
		
		titoloSmallLbl.setBounds(50, 5, 135, 20);
		filtraggio.add(titoloSmallLbl);
		
		
		stati.setBounds(100, 75, 65, 60);
		stati.setForeground(Color.WHITE);
//		stati.setOpaque(true);
//		stati.setBackground(Color.RED);
		stati.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(stati);
		
		separatoreBig = new JLabel();
		separatoreBig.setBounds(400, 75, 1, 595);
		separatoreBig.setOpaque(true);
		separatoreBig.setBackground(Color.WHITE);
		filtraggio.add(separatoreBig);
		
		
		generi.setBounds(450, 75, 80, 60);
		generi.setForeground(Color.WHITE);
//		generi.setOpaque(true);
//		generi.setBackground(Color.RED);
		generi.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(generi);
		
		separatoreBig = new JLabel();
		separatoreBig.setBounds(800, 75, 1, 595);
		separatoreBig.setOpaque(true);
		separatoreBig.setBackground(Color.WHITE);
		filtraggio.add(separatoreBig);
		
		
		periodo.setBounds(850, 75, 100, 60);
		periodo.setForeground(Color.WHITE);
//		periodo.setOpaque(true);
//		periodo.setBackground(Color.RED);
		periodo.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(periodo);
		
		
		dataInit.setBounds(850, 165, 95, 60);
		dataInit.setForeground(Color.WHITE);
//		dataInit.setOpaque(true);
//		dataInit.setBackground(Color.RED);
		dataInit.setFont(new Font("Press Gothic", Font.PLAIN, 25));
		filtraggio.add(dataInit);
		
		slashData = new JLabel("/");
		slashData.setBounds(880, 255, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);
		
		slashData = new JLabel("/");
		slashData.setBounds(920, 255, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);
		
		
		separatoreDate.setBounds(850, 385, 220, 1);
		separatoreDate.setOpaque(true);
		separatoreDate.setBackground(Color.WHITE);
		filtraggio.add(separatoreDate);

		
		dataFin.setBounds(850, 455, 95, 60);
		dataFin.setForeground(Color.WHITE);
//		dataFin.setOpaque(true);
//		dataFin.setBackground(Color.RED);
		dataFin.setFont(new Font("Press Gothic", Font.PLAIN, 25));
		filtraggio.add(dataFin);
		
		slashData = new JLabel("/");
		slashData.setBounds(880, 545, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);
		
		slashData = new JLabel("/");
		slashData.setBounds(920, 545, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);
		
		
		cerca.setBounds(1130, 150, 100, 40);
		cerca.setFocusable(false);
		cerca.setBackground(Color.BLACK);
		cerca.setForeground(Color.WHITE);
		cerca.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		cerca.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		cerca.setMargin(new Insets(20, 0, 0, 0));
		cerca.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cerca.setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createLineBorder(Color.WHITE, 1), 
			            BorderFactory.createEmptyBorder(14, 0, 0, 0)));
		    }
		    public void mouseExited(MouseEvent evt) {
		    	cerca.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	cerca.setContentAreaFilled(false);
		    	cerca.setBounds(1133, 153, 94, 34);
		    	cerca.setFont(new Font("Press Gothic", Font.PLAIN, 24));
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	cerca.setContentAreaFilled(true);
		    	cerca.setBounds(1130, 150, 100, 40);
		    	cerca.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  filtraggio.setVisible(false);
		    	  new Responso();
		      }
		    });
		filtraggio.add(cerca);
		
		svuota.setBounds(1130, 250, 100, 40);
		svuota.setFocusable(false);
		svuota.setBackground(Color.BLACK);
		svuota.setForeground(Color.WHITE);
		svuota.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		svuota.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		svuota.setMargin(new Insets(20, 0, 0, 0));
		svuota.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				svuota.setBorder(BorderFactory.createCompoundBorder(
			            BorderFactory.createLineBorder(Color.WHITE, 1), 
			            BorderFactory.createEmptyBorder(14, 0, 0, 0)));
		    }
		    public void mouseExited(MouseEvent evt) {
		    	svuota.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	svuota.setContentAreaFilled(false);
		    	svuota.setBounds(1133, 253, 94, 34);
		    	svuota.setFont(new Font("Press Gothic", Font.PLAIN, 24));
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	svuota.setContentAreaFilled(true);
		    	svuota.setBounds(1130, 250, 100, 40);
		    	svuota.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  
		      }
		    });
		filtraggio.add(svuota);
		
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
		    	  filtraggio.setVisible(false);
		    	  new Home();
		      }
		    });
		filtraggio.add(homeReturn);
		
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
		filtraggio.add(exit);
		
		
		filtraggio.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				cursore.getImage(),
				new Point(0,0),"Cursore biglietto"));
		
	}

}
