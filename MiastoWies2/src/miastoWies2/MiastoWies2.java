package miastoWies2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

public class MiastoWies2 
{
	public static void main(String argv[]) 
	{
		Query.hasSolution("use_module(library(jpl))"); // only because we call e.g. jpl_pl_syntax/1 below
		Term swi = Query.oneSolution("current_prolog_flag(version_data,Swi)").get("Swi");
		System.out.println("swipl.version = " + swi.arg(1) + "." + swi.arg(2) + "." + swi.arg(3));
		System.out.println("swipl.syntax = " + Query.oneSolution("jpl_pl_syntax(Syntax)").get("Syntax"));
		System.out.println("swipl.home = " + Query.oneSolution("current_prolog_flag(home,Home)").get("Home").name());
		System.out.println("jpl.jar = " + JPL.version_string());
		System.out.println("jpl.dll = " + org.jpl7.fli.Prolog.get_c_lib_version());
		System.out.println("jpl.pl = " + Query.oneSolution("jpl_pl_lib_version(V)").get("V").name());

		String t1 = "consult('miasto-wies.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}	

class MainFrame extends JFrame
{
	JLabel wynikLabel;
	JCheckBox duzyRuchCheckBox;
	JCheckBox tlumyCheckBox;
	JCheckBox prawoJazdyCheckBox;
	JCheckBox pracaWMiescieCheckBox;
	JCheckBox kinoCheckBox;
	JCheckBox dalekoDoSklepuCheckBox;
	JCheckBox goryCheckBox;
	JCheckBox sportyZimoweCheckBox;
	JCheckBox plazaCheckBox;
	JCheckBox zagleCheckBox;
	JCheckBox autoCheckBox;
	JCheckBox ksiazkiCheckBox;
	JCheckBox zabytkiCheckBox;
	JCheckBox muzeaCheckBox;
	JCheckBox brakZasieguCheckBox;
	JCheckBox zachodCheckBox;
	JCheckBox wschodCheckBox;
	JCheckBox zielenCheckBox;
	JCheckBox nocaZamieraCheckBox;
	JCheckBox nocaTetniCheckBox;
	public MainFrame()
	{
		setTitle("Miasto czy Wieœ?");
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10,2));
		add(panel,BorderLayout.CENTER);
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String t1 = "retractall(zapamietane(_,_,_))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				t1 = "retractall(zapamietane(_,_))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				t1 = "retractall(zapamietane(_))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				
				//nie_przeszkadza_duzy_ruch
				if(duzyRuchCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(nie_przeszkadza_duzy_ruch, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//nie_przeszkadzaja_tlumy
				if(tlumyCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(nie_przeszkadza_tlumy, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//masz_prawo_jazdy
				if(prawoJazdyCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(masz_prawo_jazdy, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//praca_zwiazana_z_miastem
				if(pracaWMiescieCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(praca_zwiazana_z_miastem, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//wolisz_bliskosc_kina_niz_lasu
				if(kinoCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(wolisz_bliskosc_kina_niz_lasu, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//nie_przeszkadza_duza_odleglosc_do_sklepu
				if(dalekoDoSklepuCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(nie_przeszkadza_duza_odleglosc_do_sklepu, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_chodzic_po_gorach
				if(goryCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_chodzic_po_gorach, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//uprawiasz_sporty_zimowe
				if(sportyZimoweCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(uprawiasz_sporty_zimowe, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_wypoczywac_na_plazy
				if(plazaCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_wypoczywac_na_plazy, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//zeglujesz
				if(zagleCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(zeglujesz, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_jezdzic_autem
				if(autoCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_jezdzic_autem, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_czytac_ksiazki
				if(ksiazkiCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_czytac_ksiazki, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_zwiedzac_zabytki
				if(zabytkiCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_zwiedzac_zabytki, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_zwiedzac_muzea
				if(muzeaCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_zwiedzac_muzea, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//nie_przeszkadza_brak_lub_slaby_zasieg_telefoniczny
				if(brakZasieguCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(nie_przeszkadza_brak_lub_slaby_zasieg_telefoniczny, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//zalezy_aby_mieszkac_na_zachodzie
				if(zachodCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(zalezy_aby_mieszkac_na_zachodzie, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//zalezy_aby_mieszkac_na_wschodzie
				if(wschodCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(zalezy_aby_mieszkac_na_wschodzie, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//bardziej_od_mozliwosci_rozwoju_zawodowego_cenisz_bliskosc_zieleni
				if(zielenCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(bardziej_od_mozliwosci_rozwoju_zawodowego_cenisz_bliskosc_zieleni, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_gdy_miasto_noca_zamiera
				if(nocaZamieraCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_gdy_miasto_noca_zamiera, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				//lubisz_gdy_miasto_noca_tetni_zyciem
				if(nocaTetniCheckBox.isSelected())
					t1 = "tak";
				else
					t1 = "nie";
				t1 = "assertz(zapamietane(lubisz_gdy_miasto_noca_tetni_zyciem, " + t1 + "))";
				System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
				
				String t4 = "powinien_mieszkac_w(X)";
				boolean queryResult = Query.hasSolution(t4);
				System.out.println(t4 + " " + (queryResult ? "succeeded" : "failed"));
				
				if(queryResult)
				{
					String wynik = "";
					//String wynik = Query.oneSolution(t4).get("X").toString();
					////System.out.println("first solution of " + t4 + ": X = " + Query.oneSolution(t4).get("X"));
					//System.out.println("first solution of " + t4 + ": X = " + wynik);
					//wynikLabel.setText(wynik);
					Map<String, Term>[] ss4 = Query.allSolutions(t4);
					Set<String> mySet =  Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());					
					for (int i = 0; i < ss4.length; i++) 
					{
						mySet.add(ss4[i].get("X").toString().toUpperCase());
					}
					for (Iterator<String> it = mySet.iterator();it.hasNext();) 
					{
						String element = it.next();
						if(it.hasNext() && wynik.length()>0)
							wynik = wynik + ", " + element;
						else if(!it.hasNext() && wynik.length()>0)
							wynik = wynik + " lub " + element + ".";
						else wynik = wynik + element;
					}
					wynik = "Dobrym miejscem dla Ciebie mo¿e byæ " + wynik;
					wynikLabel.setText(wynik);
				}
				else
					wynikLabel.setText("Nie znalaz³em jeszcze dobrego miejsca dla Ciebie. Szukaj dalej.");
			}
		};
		
		//nie_przeszkadza_duzy_ruch
		duzyRuchCheckBox = new JCheckBox("Nie przeszkadza mi du¿y ruch.");
		duzyRuchCheckBox.addActionListener(listener);
		panel.add(duzyRuchCheckBox);		
		//nie_przeszkadzaja_tlumy
		tlumyCheckBox = new JCheckBox("Nie przeszkadzaj¹ mi t³umy.");
		tlumyCheckBox.addActionListener(listener);
		panel.add(tlumyCheckBox);		
		//masz_prawo_jazdy
		prawoJazdyCheckBox = new JCheckBox("Mam prawo jazdy.");
		prawoJazdyCheckBox.addActionListener(listener);
		panel.add(prawoJazdyCheckBox);		
		//praca_zwiazana_z_miastem
		pracaWMiescieCheckBox = new JCheckBox("Praca zwi¹zana z miastem.");
		pracaWMiescieCheckBox.addActionListener(listener);
		panel.add(pracaWMiescieCheckBox);		
		//wolisz_bliskosc_kina_niz_lasu
		kinoCheckBox = new JCheckBox("Wolê bliskoœæ kina ni¿ lasu.");
		kinoCheckBox.addActionListener(listener);
		panel.add(kinoCheckBox);
		//nie_przeszkadza_duza_odleglosc_do_sklepu
		dalekoDoSklepuCheckBox = new JCheckBox("Nie przeszkadza mi du¿a odleg³oœæ do sklepu.");
		dalekoDoSklepuCheckBox.addActionListener(listener);
		panel.add(dalekoDoSklepuCheckBox);
		//lubisz_chodzic_po_gorach
		goryCheckBox = new JCheckBox("Lubiê chodziæ po górach.");
		goryCheckBox.addActionListener(listener);
		panel.add(goryCheckBox);
		//uprawiasz_sporty_zimowe
		sportyZimoweCheckBox = new JCheckBox("Uprawiam sporty zimowe.");
		sportyZimoweCheckBox.addActionListener(listener);
		panel.add(sportyZimoweCheckBox);
		//lubisz_wypoczywac_na_plazy
		plazaCheckBox = new JCheckBox("Lubiê wypoczywaæ na pla¿y.");
		plazaCheckBox.addActionListener(listener);
		panel.add(plazaCheckBox);
		//zeglujesz
		zagleCheckBox = new JCheckBox("¯eglujê.");
		zagleCheckBox.addActionListener(listener);
		panel.add(zagleCheckBox);
		//lubisz_jezdzic_autem
		autoCheckBox = new JCheckBox("Lubiê jeŸdziæ autem.");
		autoCheckBox.addActionListener(listener);
		panel.add(autoCheckBox);
		//lubisz_czytac_ksiazki
		ksiazkiCheckBox = new JCheckBox("Lubiê czytaæ ksi¹¿ki.");
		ksiazkiCheckBox.addActionListener(listener);
		panel.add(ksiazkiCheckBox);
		//lubisz_zwiedzac_zabytki
		zabytkiCheckBox = new JCheckBox("Lubiê zwiedzaæ zabytki.");
		zabytkiCheckBox.addActionListener(listener);
		panel.add(zabytkiCheckBox);
		//lubisz_zwiedzac_muzea
		muzeaCheckBox = new JCheckBox("Lubiê zwiedzaæ muzea.");
		muzeaCheckBox.addActionListener(listener);
		panel.add(muzeaCheckBox);
		//nie_przeszkadza_brak_lub_slaby_zasieg_telefoniczny
		brakZasieguCheckBox = new JCheckBox("Nie przeszkadza mi brak lub s³aby zasiêg telefoniczny.");
		brakZasieguCheckBox.addActionListener(listener);
		panel.add(brakZasieguCheckBox);
		//zalezy_aby_mieszkac_na_zachodzie
		zachodCheckBox = new JCheckBox("Zale¿y mi aby mieszkaæ na zachodzie.");
		zachodCheckBox.addActionListener(listener);
		panel.add(zachodCheckBox);
		//zalezy_aby_mieszkac_na_wschodzie
		wschodCheckBox = new JCheckBox("Zale¿y mi aby mieszkaæ na wschodzie.");
		wschodCheckBox.addActionListener(listener);
		panel.add(wschodCheckBox);
		//bardziej_od_mozliwosci_rozwoju_zawodowego_cenisz_bliskosc_zieleni
		zielenCheckBox = new JCheckBox("Bardziej od mo¿liwoœci rozwoju zawodowego ceniê sobie bliskoœæ zieleni.");
		zielenCheckBox.addActionListener(listener);
		panel.add(zielenCheckBox);
		//lubisz_gdy_miasto_noca_zamiera
		nocaZamieraCheckBox = new JCheckBox("Lubiê gdy miasto noc¹ zamiera.");
		nocaZamieraCheckBox.addActionListener(listener);
		panel.add(nocaZamieraCheckBox);
		//lubisz_gdy_miasto_noca_tetni_zyciem
		nocaTetniCheckBox = new JCheckBox("Lubiê gdy miasto noc¹ têtni ¿yciem.");
		nocaTetniCheckBox.addActionListener(listener);
		panel.add(nocaTetniCheckBox);
		
		wynikLabel = new JLabel("Jeszcze nie wiem jakie bêdzie dobre miejsce dla Ciebie.");
		wynikLabel.setFont(new Font("Serif",Font.PLAIN,24));
		wynikLabel.setForeground(Color.RED);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		wynikLabel.setBorder(border);
		add(wynikLabel,BorderLayout.SOUTH);
		pack();
	}
}
