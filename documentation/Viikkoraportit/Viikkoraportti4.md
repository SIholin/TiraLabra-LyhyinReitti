# Viikkoraportti 4

Tällä viikolla olen aloittanut luomaan algoritmia, joka luo itse labyrintin. Myös jonkun verran testejä on tullut 
kirjoitettua sekä aloitettua omien tietorakenteiden teon. Ensimmäisenä oma tietorakenteena tein listan joka löytyy 
luokasta MyList.java. Tähän on lisätty myös jonon poll ominaisuus, jotta sitä voidaan käyttä BreadthFirstSearch.java 
luokassa myös jonon korvikkeena. Käyttöliittymä on kaivannut myös päivitystä uusien toiminnallisuuksien myötä. 
Lähestulkoon kaikkiin luokkiin on tehty vähintään muutama muutos viikon kuluessa. Dokumentaatio on myös kaivannut 
rutkasti päivityksiä ajantasaisuuteen.

Sopiva labyrintin luomis algortmia miettiessäni tuli tutkittua paljon muiden ihmisten vastaavia ratkaisuja, joten 
varmasti muiden koodinluku taito on ainakin jollain tasolla kasvanut. Myös rekursion käyttö on viimeaikoina jäänyt hyvin 
vähäiseksi, joten valitsin labyrintin luomis algoritmiksi recursive divisionin, jotta rekursiivisuus palaisi vähän 
mieleen.

Epäselväksi jäi miksei labyrintin generointi algoritmi toimi täydellisesti eli aina tulisi mahdollinen labyrintti. 
Toisaalta jos aina ei tule mahdollista labyrinttiä niin sillon voi paremmin testailla reitinhaku algoritmien reaktiota 
mahdottomiin labyrintteihin. Vähän auki jäi myös että kuinka tarkasti tilavaativuudet sekä suorituskyky halutaan 
testattavan ja miten.

Seuraavaksi jatkan omien tietorakenteiden tekoa sekä labyrintin generointi algoritmin parantelua. Myös joku sopiva 
optimointia A* algortimille on suunnitteilla.

**Tällä viikolla aikaa työhön käytetty 17 tuntia**
