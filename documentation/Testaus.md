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

#### Luokka MyRandom
Kyseistä luokkaa ei ole vielä toteutettu, joten testejä ei ole vielä luotu.

## Suorituskykytestit

**Suorituskyky testit on myös tehty junit testeinä, joten ne voi suortittaa yksikkötestien ohessa. Toki ohjelma generoi testejä varten aina uuden labyrintin, joten tulos vaihtelee. Nämä testit löytyvät testipakkauksen luokasta PerformanceTest.**

### Generoitu labyrintti pysyy samana
Testillä sameMazeTime() testataan A* ja leveyssuuntaisenhaku algoritmin metodien solve() toimintaa niin että generoitu labyrintti pysyy samana koko testauksen ajan. Labyrintin koko testin aikana on 1000x1000. Testissä kummankin algoritmin solve() metodia kutsutaan satakertaa ja otetaa aikaa kuinka kauan metodin suoritukseen menee. Kummankin algoritmin tulokset tallennetaan omiin jonoihin, jonka jälkeen kummastakin jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään mikrosekunnin tarkkuudella.

**A***

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.291 | 0.239 | 23.018 |
| 2 | 0.291 | 0.235 | 22.02  |
| 3 | 0.191 | 0.169 | 22.96  |
| 4 | 0.295 | 0.25  | 25.789 |
| 5 | 0.177 | 0.166 | 18.628 |

**Leveyssuuntainenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 0.303 | 0.269 | 8.547 |
| 2 | 0.307 | 0.23  | 7.79  |
| 3 | 0.208 | 0.181 | 6.061 |
| 4 | 0.324 | 0.268 | 7.436 |
| 5 | 0.184 | 0.158 | 5.427 |

### Generoitu labyrintti vaihtelee
Testillä differentMazeTime() testataan A* ja leveyssuuntaisenhaku algoritmin metodien solve() toimintaa niin että generoitu labyrintti vaihtuu aina sen jälkeen kun kummalakin algoritmillä on kerran kutsuttu solve(). Labyrintin koko pysyy kuitenkin samana koko testin ajan ja on 1000x1000. Testissä kummankin algoritmin solve() metodia kutsutaan satakertaa ja otetaa aikaa kuinka kauan metodin suoritukseen menee. Kummankin algoritmin tulokset tallennetaan omiin jonoihin, jonka jälkeen kummastakin jonosta etsitään mediaani ja tämä kerrotaan käyttäjälle. Tulokset esitetään mikrosekunnin tarkkuudella.

**A***

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 4.982 | 4.099 | 18.609 |
| 2 | 4.912 | 4.092 | 18.172 |
| 3 | 5.025 | 2.628 | 18.12  |
| 4 | 5.06  | 2.546 | 17.263 |
| 5 | 5.026 | 3.748 | 17.114 |

**Levyssuuntianenhaku**

|Testikerta| Aikojen mediaani | Pienin kulunut aika  | Suurin kulunut aika |
|:---:|:---:|:---:|:---:|
| 1 | 1.729 | 1.246 | 5.39  |
| 2 | 1.679 | 1.208 | 5.034 |
| 3 | 1.573 | 1.061 | 4.856 |
| 4 | 1.541 | 0.987 | 5.543 |
| 5 | 1.663 | 1.228 | 5.024 |

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

