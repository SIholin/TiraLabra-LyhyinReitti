# Määrittelydokumentti

Projekti toteutetaan Java ohjelmointikielellä. Projektin tarkoituksena on löytää annetusta labyrintistä lyhyin/nopein mahdollinen reitti.

Työssä käytetään usemapaa algoritmia. Tällä hetkellä työssä on toteutettuna leveyssuuntainenhaku ja a* algoritmi. Työn edetessä mahdollisuuksien mukaan totetutetaan lisää algortimejä. Kyseiset algoritmit valikoituivat sen takia, koska ne tulivat useaan otteeseen esiin etsiessäni algorimtejä, jotka löytäisviät annetusta labyrintistä nopeasti lyhyimmän reitin. 

Käyttäjä antaa ohjelmalle syötteenä labyrintin ja sen koon. Tällä hetkellä reitti etsitään labyrintin ensimmäisestä merkistä viimeiseen merkkiin, mutta tulossa on mahdollisus jossa käyttäjä saa itse valita aloitus ja lopetus ruudun.  Labyrintistä etsitään lähtösolmusta lyhyin reitti päätössolmuun, jonka jälkeen kyseisen reitin siirtymien määrä annetaan käyttäjälle tai kerrotaan ettei labyrinttiä ole mahdollista ratkaista. Labyrintti koostuu 0, joka tarkoittaa seinää ja 1, joka tarkoittaa mahdollista kulkureittiä. Jos aikaa jää tarkoituksena on myös tarkoituksena toteuttaa toiminto, joka näyttää käyttäjälle antamastaan labyrintistä reitin, jota pitkin on kujettu. Käyttäjän antamt tiedot tallennetaan Maze luokkaan, jossa on muun muassa int taulukko, joka kuvaa käyttäjän antamaa labyrinttiä. 

Työssä käytettävien algortimien aikavaativuus riippu pitkälti totetutus tavasta, mutta tarkoituksena on päästä 
mahdollisiman tehokkaaseen aikavaativuuteen. Leveyssuuntaisenhaun sekä A* algoritmin aikavaativuus on O(n), missä n on solmujen määrä.

**Lähteet:**
- https://en.wikipedia.org/wiki/Maze_solving_algorithm 
