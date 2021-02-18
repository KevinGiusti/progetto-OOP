package it.univpm.progetto.studenti.ticketmaster.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
import it.univpm.progetto.studenti.ticketmaster.api.ChiamataGeneri;
import it.univpm.progetto.studenti.ticketmaster.api.ChiamataStati;

public class Filtraggio {

	private Vector<String> statiVect = ChiamataStati.chiamata();
	private Vector<String> generiVect = ChiamataGeneri.chiamata();
	private String[] statiArr;
	private String[] generiArr;
	private Vector<JComboBox<String>> cBStatiVect = new Vector<JComboBox<String>>();
	private Vector<JTextField> tFStatiVect = new Vector<JTextField>();
	private Vector<JComboBox<String>> cBGeneriVect = new Vector<JComboBox<String>>();
	private Vector<JTextField> tFGeneriVect = new Vector<JTextField>();
	private Vector<Integer> anni = new Vector<Integer>();
	private Vector<String> mesi = new Vector<String>();
	private Vector<String> giorni = new Vector<String>();
	private Vector<String> statiGet;
	private Vector<String> paesiGet;
	private Vector<String> generiGet;
	private Vector<String> periodoGet;

	public Filtraggio() {

		UIManager.put("ComboBox.selectionBackground", Color.WHITE);

		for (int i = 0; i < statiVect.size(); i++) {
			if (!statiVect.elementAt(i).equals(statiVect.lastElement())) {
				String statoTemp = statiVect.elementAt(i);
				statoTemp += ", AU";
				statiVect.set(i, statoTemp);
			} else {
				String statoTemp = statiVect.elementAt(i);
				statoTemp += ", NZ";
				statiVect.set(i, statoTemp);
			}
		}

		statiVect.add(0, "Tutti Gli Stati");
		generiVect.add(0, "Tutti I Generi");

		statiArr = statiVect.toArray(new String[statiVect.size()]);
		generiArr = generiVect.toArray(new String[generiVect.size()]);

		Date d = new Date(System.currentTimeMillis());
		String data = d.toString();
		String anno = data.substring(data.length() - 4, data.length());
		int annoInt = Integer.parseInt(anno);

		for (int i = annoInt - 20; i <= annoInt + 10; i++) {
			anni.add(i);
		}

		for (int i = 1; i <= 12; i++) {

			String m = new String();

			if (i < 10) {
				m = "0" + i;
			} else
				m = Integer.toString(i);

			mesi.add(m);

		}

		for (int i = 1; i <= 31; i++) {

			String g = new String();

			if (i < 10)
				g = "0" + i;
			else
				g = Integer.toString(i);

			giorni.add(g);

		}

		JFrame filtraggio = new JFrame();

		ImageIcon icona = new ImageIcon("images/Logo The Last Of Events - Icon.png");
		ImageIcon titoloSmall = new ImageIcon("images/THE LAST OF EVENTS - small.png");
		ImageIcon plus = new ImageIcon("images/Plus.png");
		ImageIcon plusClicked = new ImageIcon("images/PlusClicked.png");
		ImageIcon cursore = new ImageIcon("images/Cursore.png");

		JLabel slashData;
		JLabel separatoreBig;
		JLabel separatoreDate = new JLabel();
		JLabel separatoreTitolo = new JLabel("|");
		JLabel iconaLbl = new JLabel(icona);
		JLabel titoloSmallLbl = new JLabel(titoloSmall);
		JLabel plusClicked1 = new JLabel(plusClicked);
		JLabel plusClicked2 = new JLabel(plusClicked);
		JLabel plusClicked3 = new JLabel(plusClicked);
		JLabel plusClicked4 = new JLabel(plusClicked);
		JLabel plusClicked5 = new JLabel(plusClicked);
		JLabel plusClicked6 = new JLabel(plusClicked);
		JLabel plusClicked7 = new JLabel(plusClicked);
		JLabel plusClicked8 = new JLabel(plusClicked);
		JLabel plusClicked9 = new JLabel(plusClicked);
		JLabel plusClicked10 = new JLabel(plusClicked);
		JLabel plusClicked11 = new JLabel(plusClicked);
		JLabel plusClicked12 = new JLabel(plusClicked);
		JLabel plusClicked13 = new JLabel(plusClicked);
		JLabel plusClicked14 = new JLabel(plusClicked);
		JLabel stati = new JLabel("STATI");
		JLabel generi = new JLabel("GENERI");
		JLabel periodo = new JLabel("PERIODO");
		JLabel dataInit = new JLabel("Data iniziale:");
		JLabel dataFin = new JLabel("Data finale:");

		JComboBox<String> statiBox1 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox1);
		JComboBox<String> statiBox2 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox2);
		JComboBox<String> statiBox3 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox3);
		JComboBox<String> statiBox4 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox4);
		JComboBox<String> statiBox5 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox5);
		JComboBox<String> statiBox6 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox6);
		JComboBox<String> statiBox7 = new JComboBox<String>(statiArr);
		cBStatiVect.add(statiBox7);
		JComboBox<String> generiBox1 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox1);
		JComboBox<String> generiBox2 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox2);
		JComboBox<String> generiBox3 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox3);
		JComboBox<String> generiBox4 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox4);
		JComboBox<String> generiBox5 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox5);
		JComboBox<String> generiBox6 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox6);
		JComboBox<String> generiBox7 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox7);
		JComboBox<String> generiBox8 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox8);
		JComboBox<String> generiBox9 = new JComboBox<String>(generiArr);
		cBGeneriVect.add(generiBox9);
		JComboBox<Integer> annoInitBox = new JComboBox<Integer>(anni);
		JComboBox<String> meseInitBox = new JComboBox<String>(mesi);
		JComboBox<String> giornoInitBox = new JComboBox<String>(giorni);
		JComboBox<Integer> annoFinBox = new JComboBox<Integer>(anni);
		JComboBox<String> meseFinBox = new JComboBox<String>(mesi);
		JComboBox<String> giornoFinBox = new JComboBox<String>(giorni);

		JButton plus1 = new JButton(plus);
		JButton plus2 = new JButton(plus);
		JButton plus3 = new JButton(plus);
		JButton plus4 = new JButton(plus);
		JButton plus5 = new JButton(plus);
		JButton plus6 = new JButton(plus);
		JButton plus7 = new JButton(plus);
		JButton plus8 = new JButton(plus);
		JButton plus9 = new JButton(plus);
		JButton plus10 = new JButton(plus);
		JButton plus11 = new JButton(plus);
		JButton plus12 = new JButton(plus);
		JButton plus13 = new JButton(plus);
		JButton plus14 = new JButton(plus);
		JButton cerca = new JButton("Cerca");
		JButton svuota = new JButton("Svuota");
		JButton homeReturn = new JButton("Home");
		JButton exit = new JButton("Exit");

		for (JComboBox<String> cBStati : cBStatiVect) {
			cBStati.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			cBStati.setBackground(Color.WHITE);
			cBStati.setEditable(true);
			cBStati.setSelectedItem("");
			JTextField tF = (JTextField) cBStati.getEditor().getEditorComponent();
			tFStatiVect.add(tF);
		}

		for (JTextField tF : tFStatiVect) {
			tF.setText("Inserire uno stato...");
			tF.setForeground(new Color(0, 0, 0, 70));
		}

		for (JComboBox<String> cBGeneri : cBGeneriVect) {
			cBGeneri.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			cBGeneri.setBackground(Color.WHITE);
			cBGeneri.setEditable(true);
			cBGeneri.setSelectedItem("");
			JTextField tF = (JTextField) cBGeneri.getEditor().getEditorComponent();
			tFGeneriVect.add(tF);
		}

		for (JTextField tF : tFGeneriVect) {
			tF.setText("Inserire un genere...");
			tF.setForeground(new Color(0, 0, 0, 70));
		}

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
		stati.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(stati);

		statiBox1.setBounds(100, 130, 250, 30);
		statiBox1.setFont(new Font("Arial", Font.BOLD, 14));
		aggiungiStatiFocusListener(0);
		aggiungiStatiKeyListener(0);
		filtraggio.add(statiBox1);

		plusClicked1.setBounds(106, 171, 23, 23);
		plusClicked1.setVisible(false);
		filtraggio.add(plusClicked1);

		plus1.setBounds(105, 170, 25, 25);
		plus1.setFocusable(false);
		plus1.setContentAreaFilled(false);
		plus1.setBorder(null);
		plus1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus1.setVisible(false);
				plusClicked1.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus1.setVisible(true);
				plusClicked1.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus1.setVisible(false);
				statiBox2.setVisible(true);
				plus2.setVisible(true);
			}
		});
		filtraggio.add(plus1);

		statiBox2.setBounds(100, 190, 250, 30);
		statiBox2.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox2.setVisible(false);
		aggiungiStatiFocusListener(1);
		aggiungiStatiKeyListener(1);
		filtraggio.add(statiBox2);

		plusClicked2.setBounds(106, 231, 23, 23);
		plusClicked2.setVisible(false);
		filtraggio.add(plusClicked2);

		plus2.setBounds(105, 230, 25, 25);
		plus2.setFocusable(false);
		plus2.setContentAreaFilled(false);
		plus2.setBorder(null);
		plus2.setVisible(false);
		plus2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus2.setVisible(false);
				plusClicked2.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus2.setVisible(true);
				plusClicked2.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus2.setVisible(false);
				statiBox3.setVisible(true);
				plus3.setVisible(true);
			}
		});
		filtraggio.add(plus2);

		statiBox3.setBounds(100, 250, 250, 30);
		statiBox3.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox3.setVisible(false);
		aggiungiStatiFocusListener(2);
		aggiungiStatiKeyListener(2);
		filtraggio.add(statiBox3);

		plusClicked3.setBounds(106, 291, 23, 23);
		plusClicked3.setVisible(false);
		filtraggio.add(plusClicked3);

		plus3.setBounds(105, 290, 25, 25);
		plus3.setFocusable(false);
		plus3.setContentAreaFilled(false);
		plus3.setBorder(null);
		plus3.setVisible(false);
		plus3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus3.setVisible(false);
				plusClicked3.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus3.setVisible(true);
				plusClicked3.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus3.setVisible(false);
				statiBox4.setVisible(true);
				plus4.setVisible(true);
			}
		});
		filtraggio.add(plus3);

		statiBox4.setBounds(100, 310, 250, 30);
		statiBox4.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox4.setVisible(false);
		aggiungiStatiFocusListener(3);
		aggiungiStatiKeyListener(3);
		filtraggio.add(statiBox4);

		plusClicked4.setBounds(106, 351, 23, 23);
		plusClicked4.setVisible(false);
		filtraggio.add(plusClicked4);

		plus4.setBounds(105, 350, 25, 25);
		plus4.setFocusable(false);
		plus4.setContentAreaFilled(false);
		plus4.setBorder(null);
		plus4.setVisible(false);
		plus4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus4.setVisible(false);
				plusClicked4.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus4.setVisible(true);
				plusClicked4.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus4.setVisible(false);
				statiBox5.setVisible(true);
				plus5.setVisible(true);
			}
		});
		filtraggio.add(plus4);

		statiBox5.setBounds(100, 370, 250, 30);
		statiBox5.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox5.setVisible(false);
		aggiungiStatiFocusListener(4);
		aggiungiStatiKeyListener(4);
		filtraggio.add(statiBox5);

		plusClicked5.setBounds(106, 411, 23, 23);
		plusClicked5.setVisible(false);
		filtraggio.add(plusClicked5);

		plus5.setBounds(105, 410, 25, 25);
		plus5.setFocusable(false);
		plus5.setContentAreaFilled(false);
		plus5.setBorder(null);
		plus5.setVisible(false);
		plus5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus5.setVisible(false);
				plusClicked5.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus5.setVisible(true);
				plusClicked5.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus5.setVisible(false);
				statiBox6.setVisible(true);
				plus6.setVisible(true);
			}
		});
		filtraggio.add(plus5);

		statiBox6.setBounds(100, 430, 250, 30);
		statiBox6.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox6.setVisible(false);
		aggiungiStatiFocusListener(5);
		aggiungiStatiKeyListener(5);
		filtraggio.add(statiBox6);

		plusClicked6.setBounds(106, 471, 23, 23);
		plusClicked6.setVisible(false);
		filtraggio.add(plusClicked6);

		plus6.setBounds(105, 470, 25, 25);
		plus6.setFocusable(false);
		plus6.setContentAreaFilled(false);
		plus6.setBorder(null);
		plus6.setVisible(false);
		plus6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus6.setVisible(false);
				plusClicked6.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus6.setVisible(true);
				plusClicked6.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus6.setVisible(false);
				statiBox7.setVisible(true);
			}
		});
		filtraggio.add(plus6);

		statiBox7.setBounds(100, 490, 250, 30);
		statiBox7.setFont(new Font("Arial", Font.BOLD, 14));
		statiBox7.setVisible(false);
		aggiungiStatiFocusListener(6);
		aggiungiStatiKeyListener(6);
		filtraggio.add(statiBox7);

		separatoreBig = new JLabel();
		separatoreBig.setBounds(400, 75, 1, 595);
		separatoreBig.setOpaque(true);
		separatoreBig.setBackground(Color.WHITE);
		filtraggio.add(separatoreBig);

		generi.setBounds(450, 75, 80, 60);
		generi.setForeground(Color.WHITE);
		generi.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(generi);

		generiBox1.setBounds(450, 130, 250, 30);
		generiBox1.setFont(new Font("Arial", Font.BOLD, 14));
		aggiungiGeneriFocusListener(0);
		aggiungiGeneriKeyListener(0);
		filtraggio.add(generiBox1);

		plusClicked7.setBounds(456, 171, 23, 23);
		plusClicked7.setVisible(false);
		filtraggio.add(plusClicked7);

		plus7.setBounds(455, 170, 25, 25);
		plus7.setFocusable(false);
		plus7.setContentAreaFilled(false);
		plus7.setBorder(null);
		plus7.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus7.setVisible(false);
				plusClicked7.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus7.setVisible(true);
				plusClicked7.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus7.setVisible(false);
				generiBox2.setVisible(true);
				plus8.setVisible(true);
			}
		});
		filtraggio.add(plus7);

		generiBox2.setBounds(450, 190, 250, 30);
		generiBox2.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox2.setVisible(false);
		aggiungiGeneriFocusListener(1);
		aggiungiGeneriKeyListener(1);
		filtraggio.add(generiBox2);

		plusClicked8.setBounds(456, 231, 23, 23);
		plusClicked8.setVisible(false);
		filtraggio.add(plusClicked8);

		plus8.setBounds(455, 230, 25, 25);
		plus8.setFocusable(false);
		plus8.setContentAreaFilled(false);
		plus8.setBorder(null);
		plus8.setVisible(false);
		plus8.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus8.setVisible(false);
				plusClicked8.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus8.setVisible(true);
				plusClicked8.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus8.setVisible(false);
				generiBox3.setVisible(true);
				plus9.setVisible(true);
			}
		});
		filtraggio.add(plus8);

		generiBox3.setBounds(450, 250, 250, 30);
		generiBox3.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox3.setVisible(false);
		aggiungiGeneriFocusListener(2);
		aggiungiGeneriKeyListener(2);
		filtraggio.add(generiBox3);

		plusClicked9.setBounds(456, 291, 23, 23);
		plusClicked9.setVisible(false);
		filtraggio.add(plusClicked9);

		plus9.setBounds(455, 290, 25, 25);
		plus9.setFocusable(false);
		plus9.setContentAreaFilled(false);
		plus9.setBorder(null);
		plus9.setVisible(false);
		plus9.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus9.setVisible(false);
				plusClicked9.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus9.setVisible(true);
				plusClicked9.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus9.setVisible(false);
				generiBox4.setVisible(true);
				plus10.setVisible(true);
			}
		});
		filtraggio.add(plus9);

		generiBox4.setBounds(450, 310, 250, 30);
		generiBox4.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox4.setVisible(false);
		aggiungiGeneriFocusListener(3);
		aggiungiGeneriKeyListener(3);
		filtraggio.add(generiBox4);

		plusClicked10.setBounds(456, 351, 23, 23);
		plusClicked10.setVisible(false);
		filtraggio.add(plusClicked10);

		plus10.setBounds(455, 350, 25, 25);
		plus10.setFocusable(false);
		plus10.setContentAreaFilled(false);
		plus10.setBorder(null);
		plus10.setVisible(false);
		plus10.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus10.setVisible(false);
				plusClicked10.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus10.setVisible(true);
				plusClicked10.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus10.setVisible(false);
				generiBox5.setVisible(true);
				plus11.setVisible(true);
			}
		});
		filtraggio.add(plus10);

		generiBox5.setBounds(450, 370, 250, 30);
		generiBox5.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox5.setVisible(false);
		aggiungiGeneriFocusListener(4);
		aggiungiGeneriKeyListener(4);
		filtraggio.add(generiBox5);

		plusClicked11.setBounds(456, 411, 23, 23);
		plusClicked11.setVisible(false);
		filtraggio.add(plusClicked11);

		plus11.setBounds(455, 410, 25, 25);
		plus11.setFocusable(false);
		plus11.setContentAreaFilled(false);
		plus11.setBorder(null);
		plus11.setVisible(false);
		plus11.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus11.setVisible(false);
				plusClicked11.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus11.setVisible(true);
				plusClicked11.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus11.setVisible(false);
				generiBox6.setVisible(true);
				plus12.setVisible(true);
			}
		});
		filtraggio.add(plus11);

		generiBox6.setBounds(450, 430, 250, 30);
		generiBox6.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox6.setVisible(false);
		aggiungiGeneriFocusListener(5);
		aggiungiGeneriKeyListener(5);
		filtraggio.add(generiBox6);

		plusClicked12.setBounds(456, 471, 23, 23);
		plusClicked12.setVisible(false);
		filtraggio.add(plusClicked12);

		plus12.setBounds(455, 470, 25, 25);
		plus12.setFocusable(false);
		plus12.setContentAreaFilled(false);
		plus12.setBorder(null);
		plus12.setVisible(false);
		plus12.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus12.setVisible(false);
				plusClicked12.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus12.setVisible(true);
				plusClicked12.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus12.setVisible(false);
				generiBox7.setVisible(true);
				plus13.setVisible(true);
			}
		});
		filtraggio.add(plus12);

		generiBox7.setBounds(450, 490, 250, 30);
		generiBox7.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox7.setVisible(false);
		aggiungiGeneriFocusListener(6);
		aggiungiGeneriKeyListener(6);
		filtraggio.add(generiBox7);

		plusClicked13.setBounds(456, 531, 23, 23);
		plusClicked13.setVisible(false);
		filtraggio.add(plusClicked13);

		plus13.setBounds(455, 530, 25, 25);
		plus13.setFocusable(false);
		plus13.setContentAreaFilled(false);
		plus13.setBorder(null);
		plus13.setVisible(false);
		plus13.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus13.setVisible(false);
				plusClicked13.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus13.setVisible(true);
				plusClicked13.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus13.setVisible(false);
				generiBox8.setVisible(true);
				plus14.setVisible(true);
			}
		});
		filtraggio.add(plus13);

		generiBox8.setBounds(450, 550, 250, 30);
		generiBox8.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox8.setVisible(false);
		aggiungiGeneriFocusListener(7);
		aggiungiGeneriKeyListener(7);
		filtraggio.add(generiBox8);

		plusClicked14.setBounds(456, 591, 23, 23);
		plusClicked14.setVisible(false);
		filtraggio.add(plusClicked14);

		plus14.setBounds(455, 590, 25, 25);
		plus14.setFocusable(false);
		plus14.setContentAreaFilled(false);
		plus14.setBorder(null);
		plus14.setVisible(false);
		plus14.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mEP) {
				plus14.setVisible(false);
				plusClicked14.setVisible(true);
			}

			public void mouseReleased(MouseEvent mEP) {
				plus14.setVisible(true);
				plusClicked14.setVisible(false);
			}

			public void mouseClicked(MouseEvent me) {
				plus14.setVisible(false);
				generiBox9.setVisible(true);
			}
		});
		filtraggio.add(plus14);

		generiBox9.setBounds(450, 610, 250, 30);
		generiBox9.setFont(new Font("Arial", Font.BOLD, 14));
		generiBox9.setVisible(false);
		aggiungiGeneriFocusListener(8);
		aggiungiGeneriKeyListener(8);
		filtraggio.add(generiBox9);

		separatoreBig = new JLabel();
		separatoreBig.setBounds(800, 75, 1, 595);
		separatoreBig.setOpaque(true);
		separatoreBig.setBackground(Color.WHITE);
		filtraggio.add(separatoreBig);

		periodo.setBounds(850, 75, 100, 60);
		periodo.setForeground(Color.WHITE);
		periodo.setFont(new Font("Press Gothic", Font.PLAIN, 40));
		filtraggio.add(periodo);

		dataInit.setBounds(850, 165, 95, 60);
		dataInit.setForeground(Color.WHITE);
		dataInit.setFont(new Font("Press Gothic", Font.PLAIN, 25));
		filtraggio.add(dataInit);

		annoInitBox.setBounds(850, 265, 80, 35);
		annoInitBox.setFont(new Font("Arial", Font.BOLD, 14));
		annoInitBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		annoInitBox.setBackground(Color.WHITE);
		annoInitBox.setSelectedItem(annoInt);
		filtraggio.add(annoInitBox);

		slashData = new JLabel("/");
		slashData.setBounds(935, 255, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);

		meseInitBox.setBounds(950, 265, 60, 35);
		meseInitBox.setFont(new Font("Arial", Font.BOLD, 14));
		meseInitBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		meseInitBox.setBackground(Color.WHITE);
		filtraggio.add(meseInitBox);

		slashData = new JLabel("/");
		slashData.setBounds(1015, 255, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);

		giornoInitBox.setBounds(1030, 265, 60, 35);
		giornoInitBox.setFont(new Font("Arial", Font.BOLD, 14));
		giornoInitBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		giornoInitBox.setBackground(Color.WHITE);
		giornoInitBox.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				Vector<String> giorniTemp = new Vector<String>();
				giorniTemp.addAll(giorni);

				String init;

				switch ((String) meseInitBox.getSelectedItem()) {

				case "02":
					giorniTemp.remove(giorni.size() - 1);
					giorniTemp.remove(giorni.size() - 2);
					if (!((int) annoInitBox.getSelectedItem() % 4 == 0))
						giorniTemp.remove(giorni.size() - 3);
					init = (String) giornoInitBox.getSelectedItem();
					giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoInitBox.setSelectedItem(init);
					break;
				case "04":
					giorniTemp.remove(giorni.size() - 1);
					init = (String) giornoInitBox.getSelectedItem();
					giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoInitBox.setSelectedItem(init);
					break;
				case "06":
					giorniTemp.remove(giorni.size() - 1);
					init = (String) giornoInitBox.getSelectedItem();
					giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoInitBox.setSelectedItem(init);
					break;
				case "09":
					giorniTemp.remove(giorni.size() - 1);
					init = (String) giornoInitBox.getSelectedItem();
					giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoInitBox.setSelectedItem(init);
					break;
				case "11":
					giorniTemp.remove(giorni.size() - 1);
					init = (String) giornoInitBox.getSelectedItem();
					giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoInitBox.setSelectedItem(init);
					break;
				}
			}

			public void focusLost(FocusEvent e) {
				String init = (String) giornoInitBox.getSelectedItem();
				giornoInitBox.setModel(new DefaultComboBoxModel<String>(giorni));
				giornoInitBox.setSelectedItem(init);
			}

		});
		filtraggio.add(giornoInitBox);

		separatoreDate.setBounds(850, 385, 240, 1);
		separatoreDate.setOpaque(true);
		separatoreDate.setBackground(Color.WHITE);
		filtraggio.add(separatoreDate);

		dataFin.setBounds(850, 455, 95, 60);
		dataFin.setForeground(Color.WHITE);
		dataFin.setFont(new Font("Press Gothic", Font.PLAIN, 25));
		filtraggio.add(dataFin);

		annoFinBox.setBounds(850, 555, 80, 35);
		annoFinBox.setFont(new Font("Arial", Font.BOLD, 14));
		annoFinBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		annoFinBox.setBackground(Color.WHITE);
		annoFinBox.setSelectedItem(annoInt);
		filtraggio.add(annoFinBox);

		slashData = new JLabel("/");
		slashData.setBounds(935, 545, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);

		meseFinBox.setBounds(950, 555, 60, 35);
		meseFinBox.setFont(new Font("Arial", Font.BOLD, 14));
		meseFinBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		meseFinBox.setBackground(Color.WHITE);
		filtraggio.add(meseFinBox);

		slashData = new JLabel("/");
		slashData.setBounds(1015, 545, 10, 60);
		slashData.setForeground(Color.WHITE);
		slashData.setFont(new Font("Arial", Font.PLAIN, 30));
		filtraggio.add(slashData);

		giornoFinBox.setBounds(1030, 555, 60, 35);
		giornoFinBox.setFont(new Font("Arial", Font.BOLD, 14));
		giornoFinBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		giornoFinBox.setBackground(Color.WHITE);
		giornoFinBox.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				Vector<String> giorniTemp = new Vector<String>();
				giorniTemp.addAll(giorni);

				String fin;

				switch ((String) meseFinBox.getSelectedItem()) {

				case "02":
					giorniTemp.remove(giorni.size() - 1);
					giorniTemp.remove(giorni.size() - 2);
					if (!((int) annoFinBox.getSelectedItem() % 4 == 0))
						giorniTemp.remove(giorni.size() - 3);
					fin = (String) giornoFinBox.getSelectedItem();
					giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoFinBox.setSelectedItem(fin);
					break;
				case "04":
					giorniTemp.remove(giorni.size() - 1);
					fin = (String) giornoFinBox.getSelectedItem();
					giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoFinBox.setSelectedItem(fin);
					break;
				case "06":
					giorniTemp.remove(giorni.size() - 1);
					fin = (String) giornoFinBox.getSelectedItem();
					giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoFinBox.setSelectedItem(fin);
					break;
				case "09":
					giorniTemp.remove(giorni.size() - 1);
					fin = (String) giornoFinBox.getSelectedItem();
					giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoFinBox.setSelectedItem(fin);
					break;
				case "11":
					giorniTemp.remove(giorni.size() - 1);
					fin = (String) giornoFinBox.getSelectedItem();
					giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorniTemp));
					giornoFinBox.setSelectedItem(fin);
					break;
				}
			}

			public void focusLost(FocusEvent e) {
				String fin = (String) giornoFinBox.getSelectedItem();
				giornoFinBox.setModel(new DefaultComboBoxModel<String>(giorni));
				giornoFinBox.setSelectedItem(fin);
			}

		});
		filtraggio.add(giornoFinBox);

		cerca.setBounds(1130, 150, 100, 40);
		cerca.setFocusable(false);
		cerca.setBackground(Color.BLACK);
		cerca.setForeground(Color.WHITE);
		cerca.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		cerca.setFont(new Font("Press Gothic", Font.PLAIN, 30));
		cerca.setMargin(new Insets(20, 0, 0, 0));
		cerca.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cerca.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 1),
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

				statiGet = new Vector<String>();
				paesiGet = new Vector<String>();
				generiGet = new Vector<String>();
				periodoGet = new Vector<String>();

				boolean flag = true;

				try {
					for (int i = 0; i < cBStatiVect.size(); i++) {

						JComboBox<String> cBTemp = cBStatiVect.elementAt(i);

						if (cBTemp.isVisible() && cBTemp.getSelectedItem().equals("")) {
							throw new Exception();
						}

					}

					for (int i = 0; i < cBGeneriVect.size(); i++) {

						JComboBox<String> cBTemp = cBGeneriVect.elementAt(i);

						if (cBTemp.isVisible() && cBTemp.getSelectedItem().equals("")) {
							throw new Exception();
						}

					}

					String dataInit = "";
					dataInit += annoInitBox.getSelectedItem();
					dataInit += "-" + meseInitBox.getSelectedItem();
					dataInit += "-" + giornoInitBox.getSelectedItem();

					String dataFin = "";
					dataFin += annoFinBox.getSelectedItem();
					dataFin += "-" + meseFinBox.getSelectedItem();
					dataFin += "-" + giornoFinBox.getSelectedItem();

					LocalDate dataIn = LocalDate.parse(dataInit);
					LocalDate dataFn = LocalDate.parse(dataFin);

					if (!dataIn.isBefore(dataFn)) {
						flag = false;
						JOptionPane.showMessageDialog(null, "La data iniziale dev'essere inferiore a quella finale",
								"Attenzione", JOptionPane.WARNING_MESSAGE);
					}

					periodoGet.add(dataInit);
					periodoGet.add(dataFin);

					if (flag) {

						for (int i = 0; i < cBStatiVect.size(); i++) {

							String statoPaese = (String) cBStatiVect.elementAt(i).getSelectedItem();
							if (!statoPaese.isEmpty() && !statoPaese.equals("Tutti Gli Stati")) {
								statiGet.add(statoPaese.substring(0, statoPaese.indexOf(",")));
								paesiGet.add(statoPaese.substring(statoPaese.length() - 2, statoPaese.length()));
							}

						}

						for (int i = 0; i < cBGeneriVect.size(); i++) {

							String genere = (String) cBGeneriVect.elementAt(i).getSelectedItem();
							if (!genere.isEmpty() && !genere.equals("Tutti I Generi")) {
								generiGet.add(genere);
							}

						}

						for (int i = 0; i < cBStatiVect.size(); i++) {

							JComboBox<String> cBTemp = cBStatiVect.elementAt(i);

							if (cBTemp.isVisible() && cBTemp.getSelectedItem().equals(statiVect.firstElement())) {
								statiGet.clear();
								paesiGet.clear();
								for (int j = 1; j < statiVect.size(); j++) {
									String s = statiVect.elementAt(j);
									statiGet.add(s.substring(0, s.indexOf(",")));
									paesiGet.add(s.substring(s.indexOf(",") + 1, s.length()));
								}
							}

						}

						for (int i = 0; i < cBGeneriVect.size(); i++) {

							JComboBox<String> cBTemp = cBGeneriVect.elementAt(i);

							if (cBTemp.isVisible() && cBTemp.getSelectedItem().equals(generiVect.firstElement())) {
								generiGet.clear();
							}

						}
						String responsoText = ChiamataEventi.chiamata(statiGet, paesiGet, generiGet, periodoGet);
						filtraggio.setVisible(false);
						new Responso(responsoText);
					}
					
				} catch (NullPointerException nPE) {
					JOptionPane.showMessageDialog(null, "Non ci sono eventi disponibili", "Errore",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Inserire tutti i campi", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				}
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
				svuota.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 1),
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
				new Filtraggio();
				filtraggio.setVisible(false);
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

		filtraggio.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursore.getImage(), new Point(0, 0),
				"Cursore biglietto"));

	}

	private void aggiungiStatiFocusListener(int n) {

		JTextField tF = tFStatiVect.elementAt(n);

		tF.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (tF.getText().equals("Inserire uno stato...")) {
					tF.setText("");
					tF.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (tF.getText().isEmpty()) {
					tF.setText("Inserire uno stato...");
					tF.setForeground(new Color(0, 0, 0, 70));
				}
			}

		});

	}

	private void aggiungiStatiKeyListener(int n) {

		JTextField tF = tFStatiVect.elementAt(n);

		tF.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent kE) {

				String s = tF.getText();

				s = controlloStati(s);

				filtroStati(s, n);
			}
		});

	}

	private void aggiungiGeneriFocusListener(int n) {

		JTextField tF = tFGeneriVect.elementAt(n);

		tF.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (tF.getText().equals("Inserire un genere...")) {
					tF.setText("");
					tF.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (tF.getText().isEmpty()) {
					tF.setText("Inserire un genere...");
					tF.setForeground(new Color(0, 0, 0, 70));
				}
			}

		});

	}

	private void aggiungiGeneriKeyListener(int n) {

		JTextField tF = tFGeneriVect.elementAt(n);

		tF.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent kE) {

				String s = tF.getText();

				s = controlloGeneri(s);

				filtroGeneri(s, n);
			}
		});

	}

	private String controlloStati(String s) {

		if (!s.isEmpty()) {

			s = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
			char[] cArr = s.toCharArray();

			for (int i = 0; i < cArr.length; i++) {

				char c = cArr[i];
				if (c == ' ' && i != cArr.length - 1)
					cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);

			}

			s = new String(cArr);
		}

		int i;

		for (i = 0; i < statiArr.length;) {

			String temp = statiArr[i];

			if (!temp.contains(s))
				i++;
			else
				i += statiArr.length + 1;

		}

		if (i == statiArr.length && !s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
		}
		return s;

	}

	private void filtroStati(String s, int n) {

		Vector<String> vectTemp = new Vector<String>();

		for (int i = 0; i < statiArr.length; i++) {

			if (statiArr[i].contains(s)) {
				vectTemp.add(statiArr[i]);

			}
		}

		if (vectTemp.size() > 0) {

			cBStatiVect.elementAt(n).setModel(new DefaultComboBoxModel<String>(vectTemp));
			cBStatiVect.elementAt(n).setSelectedItem(s);
			cBStatiVect.elementAt(n).showPopup();
		} else {
			cBStatiVect.elementAt(n).setModel(new DefaultComboBoxModel<String>(vectTemp));
			cBStatiVect.elementAt(n).setSelectedItem(s);
			cBStatiVect.elementAt(n).hidePopup();
		}

	}

	private String controlloGeneri(String s) {

		if (!s.isEmpty()) {

			s = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
			char[] cArr = s.toCharArray();

			for (int i = 0; i < cArr.length; i++) {

				char c = cArr[i];
				if (c == ' ' && i != cArr.length - 1)
					cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);

			}

			s = new String(cArr);
		}

		int i;

		for (i = 0; i < generiArr.length;) {

			String temp = generiArr[i];

			if (!temp.contains(s))
				i++;
			else
				i += generiArr.length + 1;

		}

		if (i == generiArr.length && !s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
		}
		return s;

	}

	private void filtroGeneri(String s, int n) {

		Vector<String> vectTemp = new Vector<String>();

		for (int i = 0; i < generiArr.length; i++) {

			if (generiArr[i].contains(s)) {
				vectTemp.add(generiArr[i]);

			}
		}

		if (vectTemp.size() > 0) {

			cBGeneriVect.elementAt(n).setModel(new DefaultComboBoxModel<String>(vectTemp));
			cBGeneriVect.elementAt(n).setSelectedItem(s);
			cBGeneriVect.elementAt(n).showPopup();
		} else {
			cBGeneriVect.elementAt(n).setModel(new DefaultComboBoxModel<String>(vectTemp));
			cBGeneriVect.elementAt(n).setSelectedItem(s);
			cBGeneriVect.elementAt(n).hidePopup();
		}

	}

}
