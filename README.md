# Labyrintti

Labyrintti koostuu 0 ja 1 merkeistä. 0 tarkoittaa seinää ja 1 mahdollista kulkureittiä. Sovelluksen tarkoituksena on löytää lyhyin reitti labyrintistä mahdollisimman nopeasti alusta loppuun, jos tämä on mahdollista. Kyseisen reitin löytämiseen käytetään leveyssuuntainenhaku ja A* algoritmejä. Käyttäjän on mahdollista itse määrittää haluamansa labyrintti tai valita ohjelman generoimaan hänelle tietyn kokoisen labyrintin. Generoitu labyrintti voi olla niin mahdollisesti läpäistävä tai mahdoton läpäistä.

## Dokumentaatio

[Käyttöohje](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/K%C3%A4ytt%C3%B6ohje.md)

[Määrittelydokumentti](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/M%C3%A4%C3%A4rittelydokumentti.md)

[Testausdokumentti](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Testaus.md)

[Toteutusdokumentti](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Toteutusdokumentti.md)


**Viikkoraportit**
- [Viikkoraportti 1](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Viikkoraportit/viikkoraportti1.md) 
- [Viikkoraportti 2](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Viikkoraportit/Viikkoraportti2.md)
- [Viikkoraportti 3](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Viikkoraportit/Viikkoraportti3.md)
- [Viikkoraportti 4](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Viikkoraportit/Viikkoraportti4.md)


**Testaus**

Testikattavuuden saa suorittamalla gradle-projektin juuressa (<code>LabyrintinRatkaisija</code>) antamalla komennon <code>gradle test jacocoTestReport</code>. Generoitu testikattavuus löytyy polusta <code>build/reports/jacoco/test/html/index.html</code>.


**Javadoc**

Suorittamalla komennon <code>gradle javadoc</code> saa generoitua Javadocin. Tämä löytyy polusta <code>build/docs/javadoc/index.html</code>.
