# AppDev07
AppDev repo voor AD_IT07
Gert Claeskens
Brian Thys
Rafael Sarrechia
Philippe Lienart
Sam Wuytens

SPRINT 1

- Finah-Backend
  Web-API voorlopig met Hard-coded gegevens (sprint1)
  Testmethoden in Web API werken nog niet, omdat we nog niet met repositories werken.
  Automatische migratie werkt niet, om de database te updaten, moet men dit handmatig doen in de packet manager console
  De database linkt voorlopig ook nog naar de localhost ipv naar Azure.
  
- Finah-Desktop
  Indien nodig, moeten de nodige libraries toegevoegd worden in het project, deze zijn te vinden in de map /lib
  Testmethoden in Java werken wel, buiten 2 testmethoden in de Unit Test TestBevragingDAO, omdat er een verschil in
  datumnotatie is tussen C# en Java.
- Finah-Web
  We zijn gestart met een MVC-applicatie, maar schakelen vanaf sprint2 over naar php.

SPRINT 2
Om de Java Fx applicatie te kunnen openen, kan je deze tutorial volgen  : <a href="http://code.makery.ch/library/javafx-8-tutorial/part1/">Tutorial Java FX</a>

  - Gert Claeskens : Backend code geschreven om de gegevens uit database te halen om nieuwe gegevens aan te maken en overzichten te tonen + json loop error opgelost. Seed method geschreven. Web pagina's aan database gelinkt. Controllers verder afgewerkt en modelklassen afgewerkt.
  - Rafaël Sarrechia : Nieuwe layout gemaakt voor de website en voorzien van een responsive design(bootstrap). 
  - Brian Thys : Layout gemaakt van de enquête. 
  - Philippe Liénart: 
  - Sam Wuytens: Java gui omgezet naar java fx(basis).


  Enkele screenshots van de website: 
  
![vraagoverzicht](https://cloud.githubusercontent.com/assets/10980532/7396481/a7abdb14-eea1-11e4-9675-2ea8438f45d5.JPG)
![bevragingscreen](https://cloud.githubusercontent.com/assets/10980532/7396482/a7ac103e-eea1-11e4-92bc-935d43eeb332.JPG)
![bevragingcreate](https://cloud.githubusercontent.com/assets/10980532/7396480/a7a9c87e-eea1-11e4-8d0b-0dc8b8dca84c.jpg)
![responsivedesign2](https://cloud.githubusercontent.com/assets/10980532/7396484/aac4ebd8-eea1-11e4-8d51-f62be4b4d7bb.JPG)
![responsivedesign](https://cloud.githubusercontent.com/assets/10980532/7396483/aac2c51a-eea1-11e4-9922-bccae1aa9a2e.JPG)
