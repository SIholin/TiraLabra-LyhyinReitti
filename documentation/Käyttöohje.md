# Käyttöohje

## Tiedoston suorittaminen

Sovelluksen saa käynnistettyä kloonaamalla sen githubista tietokoneelle. Alla on terminaalissa käytettävät komennot sovelluksen lataamiseen githubista ja käynnistämiseen. Sovelluksen voi käynnistää myös lataamalla jar tiedoston, joka löytyy releasen alta, haluamaansa kansioon ja tekemällä kyseisessä kansiossa komennon **java -jar tiralabra-LyhyinReitti.jar**.

```
git clone git@github.com:SIholin/tiralabra-Labyrintti.git
cd tiralabra-Labyrintti
cd LabyrintinRatkaisija
grdle run
```

## Toiminnot

Ohjelman käynnistyessä se kysyy käyttäjältä halutun labyrintin kokoa. Tämän jälkeen ohjelma kysyy käyttäjältä haluaako käyttäjä antaa itse labyrintin vai antaa ohjelman generoida labyrintin. **Huom** jotta generointi toimisi kunnolla tulee käyttäjän antaa labyrintin kooksi vähintään 4x4. "S" tarkoittaa että käyttäjä haluaa itse syöttää labyrintin ja "G" tarkoittaa että ohjelma generoi labyrintin.

Jos käyttäjä haluaa itse luoda labyrintin ohjelma kysyy käyttäjältä labyrintin rakennetta. Rakenne tarkoittaa labyrintin 
sisällä olevien seinien "0" ja mahdollisten kulkureittien "1" järejestäytmistä keskenään. Tällöin käyttäjän antamien merkkien tulisi olla vain 0 ja 1. Jos käyttäjä antaa jonkun muun kokonaisluvun pyytää ohjelma uutta numeroa. Jos käyttäjä antaa vaikka kirjaimen ohjelma ilmoittaa virheestä ja sammutta ohjelman. Jos käyttäjä haluaa ohjelman generoivan labyrintin niin ohjelma tekee niin.

Tämän jälkeen labyrintti tulostetaan käyttäjän näkyviin, jonka jälkeen käyttäjältä kysytään ratkaistaanko labyrintti leveyssuuntaisellahaulla vai A* algoritmilla. "A" tarkoittaa A* ja "B" tarkoittaa leveyssuuntaistahakua. Jos käyttäjä syöttää jotain muuta käyttäjälle ilmoitetaan virheestä ja ohjelma suljetaan.

Sen jälkeen ohjelma kertoo käyttäjälle onko labyrinttiä mahdollista ratkaista vai onko se mahdoton. Jos labyrintti on mahdollinen käyttäjälle kerrotaan myös vaadittujen siirtymien määrä alusta loppuun sekä polun koordinaatit, jota pitkin alusta loppuun pääsee.

Lopuksi käyttäjän on mahdollista valita suoritetaanko suorituskyky testaus, jos sen tahtoo suorittaa tulee ohjelmalle antaa "K". Tämän jälkeen ohjelma suorittaa suorituskykytestauksen, josta voi tarkemmin lukea [täältä](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Testaus.md). Ohjelman annettua käyttäjälle suorituskyky testuaksen tulokset, se sulkeutuu itsestään.
