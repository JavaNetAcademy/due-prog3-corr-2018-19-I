# due-prog3-corr-2018-19-I

## Telepítés

### Java JDK 8

* Windows

[Letöltés](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* Debian alapú Linux

```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
```

* Debian 9.x

```
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 93C4A3FD7BB9C367 &&
sudo touch /etc/apt/sources.list.d/webupd8team.list &&
echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | sudo tee /etc/apt/sources.list.d/webupd8team.list &&
echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | sudo tee -a /etc/apt/sources.list.d/webupd8team.list

sudo apt update
sudo apt install oracle-java8-installer

sudo update-alternatives --config java
```

### Netbeans 8.2

Mindenképp a netbeans.org oldalon lévőt szedjétek le, ami az App Store-ban van pl. Ubuntu-n, az nem működik random hiba miatt. Sima next->next telepítés, a legelső oldalon 'Customize' és az Apache Tomcat-et is pipáljátok be, plusz figyeljétek, hogy a JDK elérési út helyes-e.
Linux-on még arra figyeljetek, hogy ne 'sudo'-val telepítsétek, mert gondokat okozhat futtatásnál a jogosultságok miatt.

* Debian 9.x

[Letöltés](https://netbeans.org/downloads/) Platform: OS Independent Zip

### MySQL

* Windows

[Letöltés](https://dev.mysql.com/downloads/installer/)

* Debian alapú Linux

```
sudo apt-get install mysql-server
```

*  Debian 9.x

```
wget --directory-prefix=/tmp/ https://dev.mysql.com/get/mysql-apt-config_0.8.10-1_all.deb
sudo dpkg -i /tmp/mysql-apt-config_0.8.10-1_all.deb
rm -f /tmp/mysql-apt-config_0.8.10-1_all.deb

sudo apt update
sudo apt install mysql-community-server
sudo apt install mysql-server

sudo systemctl status mysql
```

Ezen felül a Workbench hozzá megtalálható az App Store-ban és az működik. Annyi extra van még ezen felül, hogy fel kell venni kézzel a user-eteket (és a 'hoe' user-t) a MySQL user táblájába. Erről találtok számtalan leírást a neten.

**Ha készen vagytok a táblátokkal, akkor a következő paranccsal egyszerűen kiexportálhatjátok a scriptjét:**

```
SHOW CREATE TABLE tablename
```

**Ezután a result részen jobb klikk a scriptre és 'Copy field (unquoted)', azután pedig mentsétek az 'SQLScripts' mappába táblanév.sql-ként és Commit-nál ezt is hozzá fogja dobni.**

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

## Design és menü

A design-hoz hozzácsaptam a főprojekthez a jquery-t és a bootstrap 4-es verziót. A dokumentációt (html kódrészletek, amik tartalmát kell csak kb átírni) itt találjátok hozzá, illetve a menüre és a Pets modul jsp-ire már ráhúztam:
[Bootstrap](https://getbootstrap.com/docs/4.0/components/)

A menüt jelenleg a következő sorral tudjátok hozzáadni az oldalaitokhoz (lehet kell hozzá dependency-ként a users-web a saját XY-web-etekhez, de nem tuti):

```
<jsp:include page="/user/menu.jsp"></jsp:include>
```

## Discord

Ha bármi kérdés van, elérhetőek vagyunk Discord-on, ha kapok e-mail címet vagy valami más elérést, akkor tudok küldeni invite link-et (Heyzel itt Github-on).
