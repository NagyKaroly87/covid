### Bevezetés
Egy koronavírus adatokat kezelő statisztikai webalkalmazás projektje Java-ban Spring Boot keretrendszerben lefejlesztve.

Az előzetes hétvégi felkészülés és tanulás nélkül nem tudtam volna elkészíteni ezt a munkát.

### Hasznalt technologiak:

A következő technológiákat használtam:

- Spring boot 2.4.0 keretrendszert az microservice rest technológiát használó enterprise alkalmazás felépítésére
- H2 DB (in-memory) az adatbázisra
- JUnit a tesztek futtatása
- Hibernate 5.4.25 a perzisztenciához
- modelmapper library 2.1.1. objektumok átalakítása miatt
- jayway and json a restes hívásokra és JSON átalakításra


### Adatréteg
Két tábla az adataink tárolására
- Country
- CountryStat

Ezeknek van két megfelelő entitása ugyanezen a néven.

#### Id generálás
Az id-kat az egyszerűség és a későbbi könnyebb tárolás, és adatok kinyerése miatt a következőképpen építettem fel:
- Country: alpha3Code (iso3Code)
- CountryStat: countryId + day

### Adatok előzetes feltöltése
Az alkalmazás futása során a következő lépések hajtódnak végre:
1. A következő URL-ről GET REST hívás során begyűjtjük az országok adatait: "https://restcountries.eu/rest/v2/all"
2. Ezeket a kapott adatokat (JSON) áttranszformáljuk a mi rendszerünk model-jeire,
3. Elmentjük az adatokat a Country táblában,

### Elérhető REST endpointok:

1. Összes ország adatait lekérjük: (GET) http://localhost:8080//country/
2. Egy adott ország adatait lekérjük: (GET) http://localhost:8080//country/{alpha3Code} tehát pl:
http://localhost:8080//country/HUN
3. Feltöltünk egy országhoz tartozó napi statisztikát: (POST) http://localhost:8080//countrystat/ és pl. következő feltöltött adatok:
{
"countryId":"HUN",
"dailyCases":"614",
"dailyRecovered":"513640",
"dailyDeaths":"9",
"day":"2012-10-23T18:25:43.511Z",
"user": "Kabul"
}
4. Lekérjük az országhoz tartozó feltöltött statisztikákat: (POST) http://localhost:8080//countrystat/{alpha3Code}
tehát pl: http://localhost:8080//countrystat/HUN

### A projekt beallitasa es futtatasa:
1. clone github project: git clone https://github.com/NagyKaroly87/covid.git
2. import project to intellij/eclipse
3. JDK 11 verzio előzetes telepítése és beállítása a projetkben,
4. maven update project futtatás
5. megfelelő IDE-ban a run project-el el kell indulnia

### Kimaradt és későbbi fejlesztési lehetőségek:
1. Bekért adatok validációja,
2. Spring restTemplate (szabványos) használata a REST hívásokra, ErrorHandler controllerhez, code további cleanup, refactor,
3. A dataserviceImpl lebontása két service, az entitások és modellek elkülönült használata, pl: a kívülről jövő adatok UI modelbe történő fogadása vagy country feltöltésénél kapott response használata,
4. Nagyobb lefedettségű unit és integrációs tesztek,
5. Több endpoint az adatok lekérésére és modosítására,
6. Vaadin vagy egyéb UI, adatok megjelenítése és grafikonok generálása, stb.
7. Jogosultságok kezelése,
8. Logadatok kivezetése endpointokhoz admin jogosultsággalű

 
