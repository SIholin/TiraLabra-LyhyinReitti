# Testausdokumentti

## Yksikkötestit

![Testikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/ensimm%C3%A4inenKuva.png)

**Huom! Paketti ui on ilman testejä, koska sillä ei ole varsinaista sovelluslogiikkaa muuten kuin kutsumalla muita paketteja. Yksikkötestit ovat automaattisia Junit yksikkötestejä ja ne voidaan suorittaa sellaisenaan.**

### Paketti algortihms 

#### Luokka BreadthFirstSearch
Kyseiselle luokalle riitti vain muutama testi. Testeillä testattiin mahdollisia ja mahdottomia labyrinttejä ja katsottiin palauttaako testit tästä oikean boolean arvon eli "true" sovellus mahdollinen ja "false" sovellus mahdoton labyrntti.

![BfsTestikattavuus](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Testikattavuusbfs.png)

#### Luokka Node
Kyseiselle luokalle ei tarvinnut tehdä erikseen testejä, sillä luokan BreadthFirstSeardch testit testasivat samalla Node luokan, kuten yläpuolella olevasta testikattavuusraposrtista näkee.




