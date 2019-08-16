# Määrittelydokumentti

Projekti toteutetaan Java ohjelmointikielellä. Projektin tarkoituksena on löytää labyrintistä lyhyin/nopein mahdollinen reitti. Käyttäjä voi joko itse antaa ohjelmalle labyrintin tai ohjelma voi generoida sellaisen käyttäjän niin halutessa.

Työssä käytetään usemapaa algoritmia. Tällä hetkellä työssä on toteutettuna leveyssuuntainenhaku, A* ja recursive division algoritmi. Työn edetessä mahdollisuuksien mukaan totetutetaan lisää algortimejä, kuten joku optimointi A* algoritmiin. Kyseiset algoritmit valikoituivat sen takia, koska ne tulivat useaan otteeseen esiin etsiessäni algorimtejä, jotka löytäisviät annetusta labyrintistä nopeasti lyhyimmän reitin tai generoisi halutun kokoisen labyrintin. 

Käyttäjä antaa ohjelmalle syötteenä labyrintin koon. Reitti etsitään labyrintin ensimmäisestä merkistä eli vasemmasta yläruudusta viimeiseen merkkiin eli oikeaan alanurkkaan. Käyttäjä voi joko itse antaa labyrintin tai pyytää ojelmaa luomaan sen hänelle. Labyrintistä etsitään lähtösolmusta lyhyin reitti päätössolmuun, jonka jälkeen kyseisen reitin siirtymien määrä annetaan käyttäjälle sekä koordinaatit jota pitkin kuljettu tai kerrotaan ettei labyrinttiä ole mahdollista ratkaista. Labyrintti koostuu 0, joka tarkoittaa seinää ja 1, joka tarkoittaa mahdollista kulkureittiä. Jos aikaa jää tarkoituksena on myös tarkoituksena toteuttaa toiminto, joka näyttää käyttäjälle antamastaan labyrintistä reitin, jota pitkin on kujettu. 

Työssä käytettävien algortimien aikavaativuus riippu pitkälti totetutus tavasta, mutta tarkoituksena on päästä 
mahdollisiman tehokkaaseen aikavaativuuteen. Leveyssuuntaisenhaun sekä A* algoritmin aikavaativuus on O(n), missä n on solmujen määrä.

**Lähteet:**
- https://en.wikipedia.org/wiki/Maze_solving_algorithm 
