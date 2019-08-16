# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelman koodi on jaoteltu kolmeen eri pakkaukseen lyhyinreitti.algorithms, lyhyinreitti.dataStructure ja lyhyinreitti.ui. Testit löytyvät lyhyinreitti.tests kansiosta.

Algorithms pakkauksen sisällä on ohjelmassa käytetyt algorimit kuten A* (AStar.java), leveyssuuntainenhaku (BreadthFirstSearch.java) ja labyrintin generointi algoritmi recursive division (metodi Maze.java sisällä). Algorithms pakkakusesta löytyvät myös koordinaatteja (Coordinate.java), estimaatteja (Estimate.java) ja labyrinttiä (Maze.java) käsittelevät luokat.

DataStructure pakkauksen sisälle tulevat omat tietorakenteet kuten oma lista, random, ja priorityqueue. Tällä hetkellä sieltä löytyy oma lista (MyList.java), johon on sisällytetty ArrayDeque. Luokat Ui, BreadthFirstSearch, Algorithm ja AStar käyttävät MyList luokkaa listojen muodostukseen.

Käyttäliittymä Ui pyytää käyttäjää antamaan tulevan labyrintin leveyden ja korkeuden, jonka perusteella Ui tekee tyhjän taulukon. Tämän jälkeen kysytään haluaako käyttäjä luoda itse labyrintin vai tekeekö ohjelma sen hänen puolestaan. 

Tapauksesta riippumatta luodaan lähtökoordinaatti eli taulukon vasempi ylänurkka sekä maalikoordinaatti eli oikea alanurkka. Lisäksi alustetaan Maze luokka. Jos labyrintti luodaan itse Ui kuuntelee käyttäjän syöttämät merkit ja tallettaa ne Maze luokan graph muuttujaan. Jos ohjelma generoi labyrintin kutsutaan Maze luokan generate metodia, joka generoinnin tekee. 

Tämän jälkeen käyttäjä valitsee ratkaistaanko kyseinen labyrintti leveyssuuntaisellahaulla vai A* algoritmilla. Riippuen käyttäjän valinnasta alustetaan joko AStar luokka tai BreadthFirstSearch luokka. Labyrintti ratkaistaan ja kerrotaan käyttäjälle onko mahdollista päästä lähdöstä maaliin vai ei. Jos maaliin on mahdollista päästä käyttäjälle annetaan vaadittujen siirtojen määrä lähdöstä maaliin sekä käytetyn polun koordinaatit. 


## Saavutetut aika- ja tilavaativuudet



## Suorituskyky- ja O-analyysivertaiu



## Työn puutteet ja parannusehdotukset

Labyrintin generointi algoritmi ei toimi tällä hetkellä täydellisesti, joten sitä pitää vielä työstää. Omat priorityqueue ja random luokat pitää tehdä.
