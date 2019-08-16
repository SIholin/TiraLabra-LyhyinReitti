# Testausdokumentti

## Yksikkötestit

![Testikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/KaikkiKattavuua.png)

**Huom! Paketti ui on ilman testejä, koska sillä ei ole varsinaista sovelluslogiikkaa muuten kuin kutsumalla muita paketteja. Yksikkötestit ovat automaattisia Junit yksikkötestejä ja ne voidaan suorittaa sellaisenaan. Kuten yltä huomaa ei testikattavuus ole vielä sadassa prosentissa.**

### Paketti algortihms 

![AlkoTestikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/AlkoKattavuus.png)

#### Luokka BreadthFirstSearch
Kyseiselle luokalle riitti vain muutama testi. Testeillä testattiin mahdollisia ja mahdottomia labyrinttejä ja katsottiin palauttaako testit tästä oikean kokoisen listan tai null mikäli labyrintti on mahdoton.

#### Luokka AStar
Kyseiselle luokalle riitti myös vain muutama testi.  Testeillä testattiin mahdollisia ja mahdottomia labyrinttejä ja katsottiin palauttaako testit tästä oikean kokoisen listan tai null mikäli labyrintti on mahdoton.

#### Luokka Coordinate
Kyseiselle luokalla luotiin usemapi testi. Testeillä varmistetaan että equals metodi palauttaa oikean boolean arvon riippuen siitä onko annettu koordinaatti sama kuin nykyinen koordinaatti. Niillä varmistetaan myös että metodit up, down, right ja left palauttavat oikeat koordinaatit.

#### Luokka Maze
Aiempien testien alvulla on testattu suurin osa Maze luokan metodeista, mutta generate metodia ei ollut. Tämän seurauksena luotiin Maze luokalle testi generate metodin toiminnallisuutta testaamaan.

#### Luokat Estimate, Algorithm
Kyseisille luokille ei tarvinnut erikseen luoda testejä, sillä muiden luokkien testit kattavat myös nämä. 

### Paketti dataStructures

![DataKattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Kuvat/DataKattavuus.png)

#### Luokka MyList
Kyseiseltä luokalta piti testata add metodia sekä increaseSize metodia, joita ei ole vielä testattu.
