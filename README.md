## weather-app

Aplikacja na projekt z przedmiotu Platformy Programistyczne .Net i Java


##OPIS APLIKACJI

1. Aplikacja pobiera prognozę pogody z https://openweathermap.org/api w formacie JSON, następnie parsuje te dane i wyświetla
  w formie tabel. Parser danych został wygenerowany za pomocą quicktype.io.
2. Użytkownik może wybrać miasto, w którym chce sprawdzić pogodę. W przypadku braku połącznenia z internetem aplikacja
  wyświetli stosowny komunikat. Dane są automatycznie wstawiane do bazy danych.
3. Połączenie z bazą danych mySQL zlokalizowaną na localhoście, zbudowane na JOOQ. Użytkownik może: 
  - wyświetlić wszystkie rekordy
  - usunąć wszystkie rekordy
  - znaleźć rekordy odpowiadające szukanemu miastu
4. Aplikacja wyświetla wykres temperatury co 3h z dzisiaj.


##MAVEN DEPENDENCIES

 <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
    	<groupId>com.fasterxml.jackson.core</groupId>
    	<artifactId>jackson-databind</artifactId>
    	<version>2.9.0</version>
    </dependency>
    <dependency>
    	<groupId>commons-io</groupId>
    	<artifactId>commons-io</artifactId>
    	<version>2.4</version>
    </dependency>
    <dependency>
    	<groupId>org.jooq</groupId>
    	<artifactId>jooq</artifactId>
    	<version>3.11.0</version>
    </dependency>
    <dependency>
    	<groupId>org.jooq</groupId>
    	<artifactId>jooq-meta</artifactId>
    	<version>3.11.0</version>
    </dependency>
    <dependency>
    	<groupId>org.jooq</groupId>
    	<artifactId>jooq-codegen</artifactId>
    	<version>3.11.0</version>
    </dependency>
    <dependency>
    	<groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<version>8.0.11</version>
    </dependency>
    <dependency>
    	<groupId>javax.xml.bind</groupId>
    	<artifactId>jaxb-api</artifactId>
    	<version>2.3.0</version>
    </dependency>
    <dependency>
    	<groupId>com.sun.xml.bind</groupId>
    	<artifactId>jaxb-core</artifactId>
    	<version>2.2.11</version>
    </dependency>
    <dependency>
    	<groupId>com.sun.xml.bind</groupId>
    	<artifactId>jaxb-impl</artifactId>
    	<version>2.2.11</version>
    </dependency>
    <dependency>
    	<groupId>org.jfree</groupId>
    	<artifactId>jfreechart</artifactId>
    	<version>1.0.19</version>
    </dependency>
  <dependency>
    	<groupId>joda-time</groupId>
    	<artifactId>joda-time</artifactId>
    	<version>2.10</version>
    </dependency>
  </dependencies>


##DOKŁADNY OPIS

  ShowParsedDataWindow.java jest głównym oknem aplikacji, gdzie wyświetlane są odpowiednie komponenty. Komponenty są definiują mniejsze 
fragmenty kodu i można ich używać wielokrotnie i współdzielą właściwości(kolor, zachowanie). Kilka z nich to: 
  -WeatherAppButton- pomarańczowy przycisk
  -WeatherAppTextField- pomarańczowa ramka, inny kolor po aktywacji
  -DataTable- tabelka wyswietlająca pogodę
 
 W celu parsowania danych pobranych z internetu używamy paczki io.quicktype, która generuje odpowiednie dane dla pliku. 
Domyślnym miastem, dla którego aplikacja pobiera dane to Wrocław. DataParser.java pobiera, konwertuje i upraszcza wyświetlanie danych.
W przypadku braku połączenia z internetem wyświetli się odpowiedni komunikat.

  DataBaseWindow.java zajmuje się wyświetlaniem danych z bazy danych w postaci tabeli. Możliwymi operacjami na bazie danych w tym oknie 
 to usuwanie wszystkich rekordów, szukanie rekordów wg wpisanego miasta. Wszystkie operacje na bazie danych są w DBConnector, który 
jest singletonem. Paczki db.tables, db.tables.records są pregenerowane przez jooq za pomocą komendy:

*java -classpath jooq-3.11.0.jar;jooq.meta-3.11.0.jar;jooq-codegen-3.11.0.jar;mysql-connector-java-8-0-11.jar;. --add-modules java.xml.bind org.jooq.codegen.GenerationTOll pogoda.xml*

i zawierają model tabeli Pogoda w Javie. 

  WeatherChart generuje wykres pogody dla zadanych danych.
