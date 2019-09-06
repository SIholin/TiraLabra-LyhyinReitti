# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelman koodi on jaoteltu kolmeen eri pakkaukseen lyhyinreitti.algorithms, lyhyinreitti.dataStructure ja lyhyinreitti.ui. Testit löytyvät lyhyinreitti.tests kansiosta.

Algorithms pakkauksen sisällä on ohjelmassa käytetyt algorimit kuten A* (AStar.java) ja leveyssuuntainenhaku (BreadthFirstSearch.java). Algorithms pakkauksessa on myös abstrakti luokka Algorithm.java, jonka niin A* kuin leveyssuuntainenhaku algortimi extendaa.

DataStructure pakkauksen sisälle tulevat omat tietorakenteet kuten oma lista (Vector.java), random (Random.java), ja prioriteettijono (MyQueue.java). Kyseisen pakkauksen sisältä löytyy myös labyrinttiä käsittelevä luokka (Maze.java), joka sisältää labyrintin generointi recursive division algoritmin. Sieltä löytyvät myös koordinaatteja (Coordinate.java) ja estimaatteja (Estimate.java) käsittelevät luokat.

Luokat Ui, BreadthFirstSearch, Algorithm ja AStar käyttävät Vector luokkaa listojen ja jonojen muodostukseen. Random luokkaa käytetään labyrintin generointiin Maze luokassa. MyQueue luokkaa hyödynnetään prioriteettijonona AStar.java luokassa.

Käyttäliittymä Ui pyytää käyttäjää antamaan tulevan labyrintin leveyden ja korkeuden, jonka perusteella Ui tekee tyhjän taulukon. Tämän jälkeen kysytään haluaako käyttäjä luoda itse labyrintin vai tekeekö ohjelma sen hänen puolestaan. 

Tapauksesta riippumatta luodaan lähtökoordinaatti eli taulukon vasempi ylänurkka sekä maalikoordinaatti eli oikea alanurkka. Lisäksi alustetaan Maze luokka. Jos labyrintti luodaan itse Ui kuuntelee käyttäjän syöttämät merkit ja tallettaa ne Maze luokan graph muuttujaan. Jos ohjelma generoi labyrintin kutsutaan Maze luokan generate metodia, joka generoinnin tekee. 

Tämän jälkeen käyttäjä valitsee ratkaistaanko kyseinen labyrintti leveyssuuntaisellahaulla vai A* algoritmilla. Riippuen käyttäjän valinnasta alustetaan joko AStar luokka tai BreadthFirstSearch luokka. Labyrintti ratkaistaan ja kerrotaan käyttäjälle onko mahdollista päästä lähdöstä maaliin vai ei. Jos maaliin on mahdollista päästä käyttäjälle annetaan vaadittujen siirtojen määrä lähdöstä maaliin sekä käytetyn polun koordinaatit. 

Lopuksi käyttäjä valitsee haluaako suorittaa suorituskyky testauksen. Jos käyttäjä valitsee suorituskykytestuaksen niin PerformanceTest luokka alustetaan ja sitten suoritetaan testuksen suorittavat metodit. Jos taas käyttäjä ei valitse suorituskyky testausta ohjelma suljetaan.

## Saavutetut aika- ja tilavaativuudet

Levyessuuntainenhaku ja A* algoritmeillä sekä labyrintin generoinnilla on kaikilla aikavaativuutenaan O(n), missä n on solmujen lukumäärä. Ohjelman tilavaativuus on myös O(n). 

## Suorituskyky- ja O-analyysivertaiu

[Testidokumenttia](https://github.com/SIholin/tiralabra-Labyrintti/blob/master/documentation/Testaus.md) katsoessa huomaa ettei A* ja leveyssuuntainenhaku algorimteillä ole kovin suuria eroja suorituskyvyssä. 

Kun generoitu labyrintti pysyy saman niin leveyssuuntaisellahaku algortimillä on jokaisella testikerralla ollut parempi mediaani arvo ja ero on vaihdellut 0.005-0.033 välillä. Myös pienin kulunut aika kierroksilla on aina ollut leveyssuuntaisellahaku algortimillä ja ero on vaihdellut 0.003-0.018 välillä. Suurin kulunut aika on joka kerta ollut A* algoritmillä ja ero on vaihdellut 0.013-0.456 välillä, joten vaihtelu on ollut huomattavasti suurempaa kuin mediaanin ja pienimmän kuluneen ajan kohdalla.

Kun labyrintti muuttuu aina kun kuumallakin algoritmillä on kerran kutsuttu solve() metodia niin tulos pysyy suhteellisen samana kuin muuttumattoman labyrintin kohdalla. A* algoritmi häviää leveyssuuntaisellehaku algoritmille. A* algortimin mediaani on joka kerta isompi samoin kuin pienin kulunut aika ja tällöin aikaerot ovat vaihdelleet 0.002-0.039 välillä. Myös suurin kulunut aika on A* algortimillä yleensä suurempi paitsi testikerroilla 1 (eroa 0.004 A* hyväksi) ja 4 (eroa 0.063 A* hyväksi).

Labyrintin generoinnin suorituskyvyn mediaani on testikerrasta riippumatta suunnilleen aina samaa luokkaa. Lukuunottamatta kahta ensimmäistä testikertaa, jolloin koneella on tainnut olla käynnissä muita hommia. Pienin kulunut aika myös pysyy suhteellisen samana jokaisella testikerralla, mutta suurin kulunut aika on jokaisella kerralla myös melko suuri ja se on vaihdellut melko rajusti jopa 18 millisekunnin eroja ilmenee.

Keon maksimikoon määrä suorituksen aikana on niin A* kuin leveyssuuntainenhaku algoritmillä ollut keskenään suunnilleen sama, joka testikerralla. Ero on ollut vain yhdestä kolmeen solmua algortimien välillä, mutta suurempi maksimikeko on aina ollut A* algoritmillä.

Suorituksen aikaisten solmuvierailuiden määrässä on kuitenkin suuri ero A* ja leveyssuuntaisenhaku algoritmin välillä. A* vierailee noin neljä kertaa enenmmän solmuissa kuin leveyssuuntainenhaku algoritmi. 

## Työn puutteet ja parannusehdotukset

Labyrintin generointi algoritmi ei ole paras mahdollinen, mutta se toimii. Myös Random luokassa on suuria puutteita, mutta se tuntuu toimivan tähän tarkoitukseen tarpeeksi hyvin. A* algortimi vierailee liian monessa eri solmussa suorituksensa aikana, joten se on selkeä puute, jota pitäisi parantaa. Käyttöliittymä olisi myös parantelua vailla.
