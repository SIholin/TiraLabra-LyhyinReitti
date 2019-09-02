# Testausdokumentti

## Yksikkötestit

![Testikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/KaikkiKattavuus.png)

**Huom! Paketti ui on ilman testejä, koska sillä ei ole varsinaista sovelluslogiikkaa muuten kuin kutsumalla muita paketteja. Yksikkötestit ovat automaattisia Junit yksikkötestejä ja ne voidaan suorittaa sellaisenaan.**

### Paketti algortihms 

![AlkoTestikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/AlkoKattavuus.png)

#### Luokka BreadthFirstSearch
Kyseiselle luokalle riitti vain muutama testi. Testeillä testattiin mahdollisia ja mahdottomia labyrinttejä ja katsottiin palauttaako testit tästä oikean kokoisen listan tai null mikäli labyrintti on mahdoton.

#### Luokka AStar
Kyseiselle luokalle riitti myös vain muutama testi.  Testeillä testattiin mahdollisia ja mahdottomia labyrinttejä ja katsottiin palauttaako testit tästä oikean kokoisen listan tai null mikäli labyrintti on mahdoton.

#### Luokka Algorithm
Kyseiselle abstraktille luokalle ei tarvinnut erikseen luoda testejä. 

### Paketti dataStructures

![DataKattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/DatastructureKattavuus.png)

#### Luokat Vector ja MyQueue
Kyseisiltä luokilta piti testata add metodia sekä increaseSize metodia. Muilta osin luokat on tullut testattua muiden testien ohessa.

#### Luokka Coordinate
Kyseiselle luokalla luotiin usemapi testi. Testeillä varmistetaan että equals metodi palauttaa oikean boolean arvon riippuen siitä onko annettu koordinaatti sama kuin nykyinen koordinaatti. Niillä varmistetaan myös että metodit up, down, right ja left palauttavat oikeat koordinaatit.

#### Luokka Maze
Aiempien testien alvulla on testattu suurin osa Maze luokan metodeista, mutta generate metodia ei ollut. Tämän seurauksena luotiin Maze luokalle testi generate metodin toiminnallisuutta testaamaan. Myös testattiin että taulukon set metodi toimii kunnolla.

#### Luokka Estimate
Kyseiseltä luokalta piti testata vertailu metodi, mutta muuten ei tarvinnut luoda uusia testejä, sillä aiemmat testit ovat testanneet luokan muilta osin riittävän hyvin. 

#### Luokka Random
Random luokalle tehtiin RandomTest testiluokka, jossa testataan satunnaisia totuusarvoja ja numeroita. Numeroissa satunnainen numero arvotaan väliltä 0-1000. **Huom! Luokka Random luokka ei ole täydellisen satunnainen!**

|Testikerta| Satunnainen numero | Satunnainen totuusarvo |
|:---:|:---:|:---:|
| 1 | 349 | false |
| 2 | 768 | false |
| 3 | 451 | true  |
| 4 | 642 | false |
| 5 | 504 | true  |

## Suorituskykytestit

**Suorituskyky testit on myös tehty junit testeinä, joten ne voi suortittaa yksikkötestien ohessa. Toki ohjelma generoi testejä varten aina uuden labyrintin, joten tulos vaihtelee. Nämä testit löytyvät testipakkauksen luokasta PerformanceTest.**

### Generoitu labyrintti pysyy samana
Testillä sameMazeTime() testataan A* ja leveyssuuntaisenhaku algoritmin metodien solve() toimintaa niin että generoitu labyrintti pysyy samana koko testauksen ajan. Labyrintin koko testin aikana on 1000x1000. Testissä kummankin algoritmin solve() metodia kutsutaan satakertaa ja otetaa aikaa kuinka kauan metodin suoritukseen menee. Kummankin algoritmin tulokset tallennetaan omiin jonoihin, jonka jälkeen kummastakin jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään sekunnin tarkkuudella.

**A***

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.425 | 0.350 | 1.133 |
| 2 | 0.175 | 0.157 | 0.512 |
| 3 | 0.145 | 0.120 | 0.357 |
| 4 | 0.164 | 0.147 | 0.503 |
| 5 | 0.165 | 0.149 | 0.319 |

**Leveyssuuntainenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.392 | 0.337 | 0.677 |
| 2 | 0.161 | 0.139 | 0.268 |
| 3 | 0.137 | 0.117 | 0.218 |
| 4 | 0.149 | 0.132 | 0.258 |
| 5 | 0.160 | 0.136 | 0.306 |

### Generoitu labyrintti vaihtelee
Testillä differentMazeTime() testataan A* ja leveyssuuntaisenhaku algoritmin metodien solve() toimintaa niin että generoitu labyrintti vaihtuu aina sen jälkeen kun kummalakin algoritmillä on kerran kutsuttu solve(). Labyrintin koko pysyy kuitenkin samana koko testin ajan ja on 1000x1000. Testissä kummankin algoritmin solve() metodia kutsutaan satakertaa ja otetaa aikaa kuinka kauan metodin suoritukseen menee. Kummankin algoritmin tulokset tallennetaan omiin jonoihin, jonka jälkeen kummastakin jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään sekunnin tarkkuudella.

**A***

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.370 | 0.061 | 0.622 |
| 2 | 0.411 | 0.117 | 0.859 |
| 3 | 0.214 | 0.079 | 0.404 |
| 4 | 0.215 | 0.048 | 0.324 |
| 5 | 0.198 | 0.064 | 0.345 |

**Levyssuuntianenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.341 | 0.059 | 0.626 |
| 2 | 0.372 | 0.114 | 0.618 |
| 3 | 0.204 | 0.067 | 0.346 |
| 4 | 0.195 | 0.041 | 0.387 |
| 5 | 0.192 | 0.061 | 0.315 |

### Generoidun labyrintin suorituskyky
Testillä generateTime() testataan labyrintin generointiin kuluvaa aikaa, kun generoitavana on 1000x1000 kokoinen labyrintti.
Testissä Maze luokan generate() metodia kutsutaan satakertaa ja otetaan aikaa kuinka metodin suoritukseen menee. Tulokset tallennetaan jonoon, jonka jälkeen jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään millisekunnin tarkkuudella.

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 17.602 | 12.665 | 38.330 |
| 2 | 18.394 | 12.604 | 37.549 |
| 3 | 11.899 | 11.588 | 24.778 |
| 4 | 11.677 | 11.384 | 30.486 |
| 5 | 11.921 | 11.612 | 20.231 |

### A* algoritmin keon maksimikoko ja solmuvierailuiden määrä
Testeillä maximSizeOfQueueAStar ja visitedCellsAStar testataan A* algoritmin keon maksimi suuruutta sekä solmujen määrää, jossa on vierailtu suorituksen aikana. Labyrintin koko on 1000x1000.

|Testikerta| Keon maksimikoko | Solmuvierailut |
|:---:|:---:|:---:|
| 1 | 241 | 2444700 |
| 2 | 189 | 2502055 |
| 3 | 229 | 1585047 |
| 4 | 307 | 925424  |
| 5 | 153 | 2536011 |


### Leveyssuuntaisenhaku algoritmin keon maksimikoko ja solmuvierailuiden määrä
Testeillä maximSizeOfQueueBFS ja visitedCellsBFS testataan leveyssuuntaisenhaku algoritmin keon maksimi suuruutta sekä solmujen määrää, jossa on vierailtu suorituksen aikana. Labyrintin koko on 1000x1000.

|Testikerta| Keon maksimikoko | Solmuvierailut |
|:---:|:---:|:---:|
| 1 | 206 | 587940 |
| 2 | 287 | 627757 |
| 3 | 139 | 601204 |
| 4 | 291 | 511244 |
| 5 | 183 | 626295 |



