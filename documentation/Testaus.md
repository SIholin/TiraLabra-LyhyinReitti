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
| 1 | 0.212 | 0.173 | 0.486 |
| 2 | 0.236 | 0.210 | 0.420 |
| 3 | 0.030 | 0.026 | 0.202 |
| 4 | 0.181 | 0.171 | 0.376 |
| 5 | 0.188 | 0.174 | 0.385 |

**Leveyssuuntainenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.196 | 0.169 | 0.348 |
| 2 | 0.225 | 0.203 | 0.393 |
| 3 | 0.027 | 0.024 | 0.138 |
| 4 | 0.181 | 0.168 | 0.234 |
| 5 | 0.180 | 0.169 | 0.277 |

### Generoitu labyrintti vaihtelee
Testillä differentMazeTime() testataan A* ja leveyssuuntaisenhaku algoritmin metodien solve() toimintaa niin että generoitu labyrintti vaihtuu aina sen jälkeen kun kummalakin algoritmillä on kerran kutsuttu solve(). Labyrintin koko pysyy kuitenkin samana koko testin ajan ja on 1000x1000. Testissä kummankin algoritmin solve() metodia kutsutaan satakertaa ja otetaa aikaa kuinka kauan metodin suoritukseen menee. Kummankin algoritmin tulokset tallennetaan omiin jonoihin, jonka jälkeen kummastakin jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään sekunnin tarkkuudella.

**A***

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.233 | 0.048 | 0.447 |
| 2 | 0.203 | 0.069 | 0.327 |
| 3 | 0.199 | 0.038 | 0.380 |
| 4 | 0.193 | 0.045 | 0.308 |
| 5 | 0.186 | 0.045 | 0.322 |

**Levyssuuntianenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.201 | 0.037 | 0.406 |
| 2 | 0.193 | 0.051 | 0.327 |
| 3 | 0.189 | 0.037 | 0.391 |
| 4 | 0.187 | 0.033 | 0.295 |
| 5 | 0.171 | 0.032 | 0.295 |

### Generoidun labyrintin suorituskyky
Testillä generateTime() testataan labyrintin generointiin kuluvaa aikaa, kun generoitavana on 1000x1000 kokoinen labyrintti.
Testissä Maze luokan generate() metodia kutsutaan satakertaa ja otetaan aikaa kuinka metodin suoritukseen menee. Tulokset tallennetaan jonoon, jonka jälkeen jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään millisekunnin tarkkuudella.

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 13.573 | 13.056 | 15.536 |
| 2 | 13.400 | 13.072 | 14.732 |
| 3 | 13.894 | 13.129 | 18.542 |
| 4 | 13.685 | 13.103 | 20.539 |
| 5 | 14.075 | 13.409 | 20.637 |

### A* keon maksimikoko ja solmuvierailuiden määrä
Testeillä maximSizeOfQueueAStar ja visitedCellsAStar testataan A* algoritmin keon maksimi suuruutta sekä solmujen määrää, jossa on vierailtu suorituksen aikana. 
Labyrintin koko on 1000x1000.

|Testikerta| Keon maksimikoko | Solmuvierailut |
|:---:|:---:|:---:|
| 1 | 241 | 2444700 |
| 2 | 189 | 2502055 |
| 3 | 229 | 1585047 |
| 4 | 307 | 925424  |
| 5 | 153 | 2536011 |

