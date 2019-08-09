# Viikkoraportti 2

Viikon alussa päätin, että haluan vaihtaa vielä aihettani, joten siirryin eri reitinhaku algoritmien tutkinnasta labyrinttien tutkintaan ja siihen kuinka siitä löytyy lyhyin mahdollinen reitti. Aiheen muutos ja siitä neitstä googlailu vei yllättävän paljon aikaa. Tällä viikolla olen lisännyt dokumentaatio kansioon vaadittavat dokumentti tiedostot ja täyttänyt niistä osaa jo alustavasti. Lisäksi olen tehnyt testejä, sekä kirjoittanut ohjelmaan lisää koodia.

Ohjelman koodiin on luotu alustava tekstikäyttöliittymä, joka kysyy käyttäjältä vaaditut tiedot. Myös ensimmäinen algoritmi, joka löytää lyhyimmän reitin on kutakuinkin valmis. Kyseiselle leveyssuuntaisenhaun tekevälle algortimille on myös luotu oma luokkansa sekä apuloukka Node. Myös testit on kyseiselle luokalle tehtynä.

Tällä viikolla opin tekemään leveyssuuntaisen haun tekevän algoritmin melko yksinkertaisella tavalla. Myös netistä googlailessa tuli gradlesta opittua lisää.

Vaikeuksia tuotti koodaamisen aloittaminen. Oli vaikeaa keksiä kuinka lähden toteuttamaan leveyssuuntiasenhaun toteuttavaa algoritmia. Myös gradle tuotti aluksi kovasti päänvaivaa enkä vielä ole saanut checkstyle:siä toimimaan. Seuraavan algortimin toteutus vähän pelottaa, vaikka edellisen algortimin sai loppupeleissä melko pienellä vaivalla toimimaan.

Seuraavaksi on tarkoitus toteuttaa uusi algortimi mahdollisesti A*. Myös käyttöliittymää on tarkoitus parantaa todennäköisesti edellee kuitenkin tekstipohjainen. Käyttöliittymään olisi tarkoitus vaihe, joka näyttää käyttäjälle lyhyimmän mahdollisen reitin, sekä lisätä toiminnalisuus että käyttäjä voi lisätä itse aloitus ja lopetus paikan. Tavoitteena on myös luoda virheilmoituksia käyttäjälle, jos vaikka vahingossa syöttää kirjaimen tai väärän numeron eikä niin että ohjelma vain kaatuu kyseisissä tapauksissa.

**Tällä viikolla aikaa kului työn tekoon noin 15 tuntia**
