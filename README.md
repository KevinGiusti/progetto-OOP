# The Last of Events
## an OOP-Java project made with Spring
### Repository progetto programmazione OO febbraio 2021

## Sommario:
* Introduzione
* Installazione/Clone
* Configurazione API Ticketmaster
* UML
  * Use Case Diagram
  * Class Diagram
  * Sequence Diagram
  * Sequence Diagram Rotta “/eventi”
* Rotte
  * Filtri e Stats Richiesti
  * Filtri e Stats aggiuntivi
* Test
* Documentazione
* Software Utilizzati
* Autori

## Introduzione
Il tema principale, da cui origina l’applicazione ivi presentata, descritta e documentata, è quello di realizzare una Filter-App dell’applicativo Ticketmaster, un noto software dedito alla gestione ed alla prenotazione di eventi musicali, teatrali, cinematografici ed artistici, reperibile presso l’indirizzo https://www.ticketmaster.it/.
In particolare, attraverso le API derivate dalla pagina TM Developer, accessibili mediante l’indirizzo Discovery API - The Ticketmaster Developer Portal, il programma dovrà valutare esclusivamente gli eventi siti in Australia ed in  Nuova Zelanda, al fine di cercare gli eventi relativi ad ogni Stato e di produrre statistiche, che possono essere di Default o Personalizzate, in base ai risultati ottenuti dalla ricerca.
Continuando, dal punto di vista delle specifiche tecniche, il Web Service proposto offre le seguenti funzionalità:
* filtraggio degli eventi, previsti in Australia e/o Nuova Zelanda, attraverso la selezione di  uno o più Stati, a cui segue la produzione di statistiche relative allo Stato o agli Stati scelti.
* filtraggio degli eventi, previsti in Australia e/o Nuova Zelanda, attraverso la selezione di uno o più generi, a cui segue la produzione di statistiche relative al genere o ai generi scelti.
* funzione di filtraggio avanzata degli eventi, che prevede l’introduzione di una sottostringa contenuta nel nome degli Stati come, ad esempio, A*, e che fornisce un suggerimento circa i possibili Stati da inserire.
* funzione di filtraggio avanzata delle statistiche, che prevede l’introduzione di un periodo ti tempo personalizzato, costituito da una data iniziale e da una data finale, entrambe nel formato yyyy-mm-dd, su cui effettuare il calcolo delle statistiche relative ad uno o più Stati selezionati.
In particolare, una volta scelto il periodo personalizzato, esso verrà ripetuto tante volte quanto è contenuto in un anno a partire dalla data iniziale scelta;
ad esempio, se il periodo è di 182 giorni (ovvero metà anno), allora esso può essere ripetuto solo due volte a partire dalla data iniziale scelta, mentre se il periodo è di 121 giorni (ovvero ⅓ di anno), allora esso può essere ripetuto tre volte a partire dalla data iniziale scelta, ecc;

e fornisce altresì le seguenti statistiche:
* numero totale di eventi in ogni Stato
* numero totale di eventi raggruppati per genere in ogni Stato
* numero minimo, massimo e media degli eventi mensili in ogni Stato

## Installazione/Clone
È possibile eseguire il download della Filter-App The Last of Events attraverso tre semplici passaggi:
* creare una cartella sul desktop che possa ospitare l’applicativo
* aprire il terminale nella cartella appena generata
* digitare:  `git clone https://github.com/KevinGiusti/progetto-OOP`


## Configurazione API Ticketmaster
 Le API derivate dalla pagina TM Developer di Ticketmaster, impiegate per la definizione delle classi relative all’applicativo The Last of Events, presentano la seguente struttura:
 

che può essere sintetizzata mediante il seguente grafico:
