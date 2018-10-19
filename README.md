# due-prog3-corr-2018-19-I

## Telepítés

### Java JDK 8

* Windows

```
[Letöltés](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
```

* Debian alapú Linux

```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
```

### Netbeans 8.2

Mindenképp a netbeans.org oldalon lévőt szedjétek le, ami az App Store-ban van pl. Ubuntu-n, az nem működik random hiba miatt. Sima next->next telepítés, a legelső oldalon 'Customize' és az Apache Tomcat-et is pipáljátok be, plusz figyeljétek, hogy a JDK elérési út helyes-e.
Linux-on még arra figyeljetek, hogy ne 'sudo'-val telepítsétek, mert gondokat okozhat futtatásnál a jogosultságok miatt.

### MySQL

* Windows

```
[Letöltés](https://dev.mysql.com/downloads/installer/)
```

* Debian alapú Linux

```
sudo apt-get install mysql-server

```

Ezen felül a Workbench hozzá megtalálható az App Store-ban és az működik. Annyi extra van még ezen felül, hogy fel kell venni kézzel a user-eteket (és a 'hoe' user-t) a MySQL user táblájába. Erről találtok számtalan leírást a neten.

## Github

* Clone gomb a projektnél jobb felül, HTTPS link másolása.
* Netbeans-ben: Team -> Git -> Clone
* Változtatásnál 'hoe' jobb klikk, Git -> Commit, megnézitek a különbségeket, és hogy jó fájlok vannak-e bent, adtok neki egy kommentet és Commit
* Utána nem árt egy 'hoe' jobb klikk, Git -> Remote -> Pull-t csinálni, ami leszedi a legutolsó változtatásokat, ha esetleg vannak
* Végül 'hoe' jobb klikk, Git -> Remote -> Push, és ezzel felkerülnek Github-ra a változtatások

## Futtatás / Munka

Van a főkönyvtárban egy 'SQLScripts' nevű mappa, amiben a táblalétrehozások fekszenek. Értelemszerűen ezeket a webalkalmazás használata előtt le kell futtatni a localhost-on létrehozott 'hoe' adatbázisra, a 'user'-el kezdve. Vannak foreign key-ek is itt-ott, úgyhogy nem árt azokat is nézni eközben.

* 'hoe' projektre Clean and Build ha bármit is változtattok
* A 'web' projektet tudjátok Run-olni vagy Debug-olni

## Discord

Ha bármi kérdés van, elérhetőek vagyunk Discord-on, ha kapok e-mail címet vagy valami más elérést, akkor tudok küldeni invite link-et (Heyzel itt Github-on).
