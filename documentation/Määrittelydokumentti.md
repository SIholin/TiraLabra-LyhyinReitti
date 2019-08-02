# Määrittelydokumentti

Projekti toteutetaan Java ohjelmointikielellä. Projektin tarkoituksena on löytää annetusta labyrintistä lyhyin tai nopein 
mahdollinen reitti. 

Työssä käytetään usemapaa algoritmia. Tarkoituksena on ensin toteuttaa leveyshaku ja a* algoritmi, sekä vertailla näitä 
toisiinsa. Työn edetessä mahdollisuuksien mukaan totetutetaan lisää algortimejä. Kyseiset algoritmit valikoituivat sen 
takia, koska ne ovat yksiä tunnetuimpia reitinhaku algortimejä ainakin itselle. 

Käyttäjä antaa ohjelmalle syötteenä binääri labyrintin ja sen koon. Tällä hetkellä reitti etsitään labyrintin ensimmäisestä merkistä viimeiseen merkkiin, mutta tulossa on mahdollisus jossa käyttäjä saa itse valita aloitus ja lopetus ruudun.  Labyrintistä etsitään lähtösolmusta lyhyin reitti päätössolmuun, jonka jälkeen kyseisen reitin pituus annetaan käyttäjälle tai kerrotaan ettei labyrinttiä ole mahdollista ratkaista. Labyrintti koostuu 0, joka tarkoittaa seinää ja 1, joka tarkoittaa mahdollista kulkureittiä. Jos aikaa jää tarkoituksena on myös tarkoituksena toteuttaa toiminto, joka näyttää käyttäjälle antamastaan labyrintistä reitin, jota pitkin on kujettu.

Työssä käytettävien algortimien aikavaativuus riippu pitkälti totetutus tavasta, mutta tarkoituksena on päästä 
mahdollisiman tehokkaaseen aikavaativuuteen. Toki aluksi tärkeintä on saada algoritmit totetututtua, jonka jälkeen 
parempaa aikavaativuutta voi lähteä toteuttamaan. Leveyshaun aikavaativuus yritetään saada O(n + m), missä n on solmujen määrä ja m on kaarten määrä.
