User stories:

User story 1:
Som medarbejder vil jeg kunne oprette en lejeaftale, så en kunde kan leje en bil. 
Tasks:
US 1.1 Opsæt biltabel i databasen, og connect den med intellij
US 1.2 Opret vis bil HTML.
US 1.3 Opret kundeinformationer HTML
US 1.4 Lav en metode der kan redigere bilobjekt til at have kunde informationer tilknyttet.

User story 2:
Som mekaniker, vil jeg kunne registrere skader på en returneret bil, så bilen kan vurderes og repareres. 
Tasks:
US 2.1: Lav en tabel i sql der hedder skaderapport
US 2.2: Lav HTML funktionalitet, der gør man enten kan indsætte skaderapport txt dokument, eller ny html side, hvor man udfylder skade informationerne. 
US2.3: Lav metode der gemmer skaderapport i sql og tilknytter den med den enkelte bil.

User story 3:
Som medarbejder vil jeg kunne se status på alle biler, så jeg kan se hvilke biler der er ledige eller udlejede. 
Tasks:
US3.1: Lav dashboard HTML over ledige biler.
US3.2: Lav dashboard HTML over ikke ledige biler.
US3.3: Opret funktionalitet så dashboard HTML kan snakke sammen med model og repository, så de kan vise de forskellige bil objekter.

User story 4:
Som medarbejder vil jeg kunne ændre status på en bil, så systemet viser hvor bilen befinder sig i processen. 
US4.1: Tilføj drop down menu i visBil html der viser de forskellige mulige statusser.
US4.2: Tilføj HTML funktionalitet, så man kan trykke på en bils status, og gemme det.
US4.3: Tilføj metode der kan ændre et bil objekts parameter og gemme dem.
US4.4: Lav en enum klasse der hedder status, og definer de forskellige statusser.

User story 5:
Som medarbejder, vil jeg kunne se detaljer om en bil, herunder kunde og  leje information, så jeg  hurtig kan få overblik over bilen 
Tasks: 
US5.1: Lav opdateret visBilHTML side, der viser alle informationer. 
US5.2: Lav metode der viser alle indsatte parameter (kundeinformationer, skaderapport, osv).




User story 6:
Som medarbejder ville jeg kunne søge efter en bil via stelnummer, så jeg kan hurtig finde bilens informationer 
US. 6.1: Opret SQL - query/metode i repository/service-laget, der kan finde en bil via stelnummer.
US. 6.2:  Lav HTML-side med inputfelt til stelnummer og en søgeknap 
US 6.3: Lav controller-metode der modtager stelnummer fra HTML-formen og kalder søgemetoden
US 6.4: Vis bilens information på en HTML-resultatside (fx model, mærke, status, kundeinfo hvis udlejet).
US 6.5: Tilføj fejlbesked hvis stelnummer ikke findes i databasen.



User story 7
Som bogholder vil jeg kunne se statistik over sidste måneds udlejninger og samlede indkomst, så virksomhedens økonomi kan overvåges 


US 7.1: Lav SQL-query der henter alle udlejninger fra sidste måned
US 7.2: Lav SQL-query der beregner samlet indkomst for sidste måned.
US 7.3: Lav metode i service-laget der samler statistidataene. 
US 7.4: Lav controller-metode der sender statistikdata til HTML-view. 
US 7.5:  Lav HTM-side der viser 
antal udlejninger sidste måned
samlet indkomst sidste måned


