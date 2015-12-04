:- dynamic
    zapamietane/2.

powinien_mieszkac_w(ustrzyki_gorne) :- woli_mieszkac(na_wsi),
                        wskazana_bliskosc(gory),
						lubi(odosobnienie).

powinien_mieszkac_w(zawoja) :- woli_mieszkac(na_wsi),
                        wskazana_bliskosc(gory),
						\+lubi(odosobnienie).

powinien_mieszkac_w(krzyze) :- woli_mieszkac(na_wsi),
                        wskazana_bliskosc(woda).

powinien_mieszkac_w(gdansk) :- woli_mieszkac(w_miescie),
                        wskazana_bliskosc(woda).

powinien_mieszkac_w(krakow) :- woli_mieszkac(w_miescie),
						lubi(miasta_turystyczne),
                        wskazana_bliskosc(gory).

powinien_mieszkac_w(warszawa) :- woli_mieszkac(w_miescie),
                        preferuje_dojazd(komunikacja_miejska),
						przeklada_mozliwosci_nad_spokoj.

powinien_mieszkac_w(rzeszow) :- woli_mieszkac(w_miescie),
							preferuje_dojazd(auto),
							\+zalezy_aby_mieszkac(na_zachodzie).
powinien_mieszkac_w(rzeszow) :- woli_mieszkac(w_miescie),
							wskazana_bliskosc(gory),
							\+zalezy_aby_mieszkac(na_zachodzie).

powinien_mieszkac_w(zakopane) :- wskazana_bliskosc(gory),
								pozytywne(nie_przeszkadza_duzy_ruch),
								pozytywne(nie_przeszkadzaja_tlumy).

powinien_mieszkac_w(sandomierz) :- lubi(miasta_turystyczne),
									zalezy_aby_mieszkac(na_wschodzie).
powinien_mieszkac_w(sandomierz) :- lubi(miasta_turystyczne),
									przeklada_spokoj_nad_mozliwosci.

powinien_mieszkac_w(poznan) :- woli_mieszkac(w_miescie),
								przeklada_spokoj_nad_mozliwosci,
								\+lubi(miasta_turystyczne).

powinien_mieszkac_w(wroclaw) :- woli_mieszkac(w_miescie),
								zalezy_aby_mieszkac(na_zachodzie),
								przeklada_mozliwosci_nad_spokoj.

woli_mieszkac(na_wsi) :- moze_mieszkac(na_wsi), spelnia_warunki(na_wsi).

woli_mieszkac(w_miescie) :- spelnia_warunki(w_miescie).

moze_mieszkac(na_wsi) :- pozytywne(masz_prawo_jazdy).
moze_mieszkac(na_wsi) :- negatywne(praca_zwiazana_z_miastem).

spelnia_warunki(na_wsi) :- negatywne(wolisz_bliskosc_kina_niz_lasu),
                           pozytywne(nie_przeszkadza_duza_odleglosc_do_sklepu).

spelnia_warunki(w_miescie) :- pozytywne(wolisz_bliskosc_kina_niz_lasu),
                              pozytywne(nie_przeszkadza_duzy_ruch).

wskazana_bliskosc(gory) :- pozytywne(lubisz_chodzic_po_gorach).
wskazana_bliskosc(gory) :- pozytywne(uprawiasz_sporty_zimowe).

wskazana_bliskosc(woda) :- pozytywne(lubisz_wypoczywac_na_plazy).
wskazana_bliskosc(woda) :- pozytywne(zeglujesz).

preferuje_dojazd(komunikacja_miejska) :- negatywne(lubisz_jezdzic_autem).
preferuje_dojazd(komunikacja_miejska) :- pozytywne(nie_przeszkadzaja_tlumy),
									     pozytywne(lubisz_czytac_ksiazki).
preferuje_dojazd(auto) :- pozytywne(lubisz_jezdzic_autem),
                          pozytywne(masz_prawo_jazdy).


lubi(miasta_turystyczne) :- pozytywne(nie_przeszkadzaja_tlumy),
							pozytywne(lubisz_zwiedzac_zabytki),
							pozytywne(lubisz_zwiedzac_muzea).

lubi(odosobnienie) :- negatywne(nie_przeszkadzaja_tlumy),
                        pozytywne(nie_przeszkadza_brak_lub_slaby_zasieg_telefoniczny).

zalezy_aby_mieszkac(na_wschodzie) :- negatywne(zalezy_aby_mieszkac_na_zachodzie),
									   pozytywne(zalezy_aby_mieszkac_na_wschodzie).

zalezy_aby_mieszkac(na_zachodzie) :- negatywne(zalezy_aby_mieszkac_na_wschodzie),
									   pozytywne(zalezy_aby_mieszkac_na_zachodzie).

przeklada_spokoj_nad_mozliwosci :- pozytywne(bardziej_od_mozliwosci_rozwoju_zawodowego_cenisz_bliskosc_zieleni),
                                   pozytywne(lubisz_gdy_miasto_noca_zamiera).

przeklada_mozliwosci_nad_spokoj :- pozytywne(lubisz_gdy_miasto_noca_tetni_zyciem),
								   negatywne(bardziej_od_mozliwosci_rozwoju_zawodowego_cenisz_bliskosc_zieleni).

negatywne(X) :- \+pozytywne(X).

pozytywne(X) :- zapamietane(X, tak),
              !.

pozytywne(X) :- zapamietane(X, _),
              !,
			  fail.
